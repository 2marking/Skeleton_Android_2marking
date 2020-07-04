package com.example.customskeleton_android_2marking.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customskeleton_android_2marking.CustomSkeleton.Skeleton
import com.example.customskeleton_android_2marking.CustomSkeleton.SkeletonScreen
import com.example.customskeleton_android_2marking.R
import com.example.customskeleton_android_2marking.ui.adapter.TopicAdapter
import java.lang.ref.WeakReference

class ViewActivity : AppCompatActivity() {
    private var skeletonScreen: SkeletonScreen? = null

    class MyHandler internal constructor(activity: ViewActivity?) : Handler() {
        private val activityWeakReference: WeakReference<ViewActivity?> = WeakReference(activity)
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (activityWeakReference.get() != null) {
                activityWeakReference.get()!!.skeletonScreen!!.hide()
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        val mType = intent.getStringExtra(PARAMS_TYPE)
        val rootView = findViewById<View>(R.id.rootView)
        val recyclerView =
            findViewById<View>(R.id.recyclerView) as RecyclerView
        val adapter = TopicAdapter()
        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        if (TYPE_VIEW == mType) {
            skeletonScreen =
                Skeleton.bind(rootView)
                    .load(R.layout.activity_view_skeleton)
                    .duration(1000)
                    .color(R.color.shimmer_color)
                    .angle(0)
                    .show()
        }
        if (TYPE_IMG_LOADING == mType) {
            skeletonScreen =
                Skeleton.bind(rootView)
                    .load(R.layout.layout_img_skeleton)
                    .duration(1000)
                    .color(R.color.shimmer_color_for_image)
                    .show()
        }
        val myHandler =
            MyHandler(
                this
            )
        myHandler.sendEmptyMessageDelayed(1, 3000)
    }

    companion object {
        private const val PARAMS_TYPE = "params_type"
        const val TYPE_IMG_LOADING = "type_img"
        const val TYPE_VIEW = "type_view"
        fun start(context: Context, type: String?) {
            val intent = Intent(context, ViewActivity::class.java)
            intent.putExtra(PARAMS_TYPE, type)
            context.startActivity(intent)
        }
    }
}