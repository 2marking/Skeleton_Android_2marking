package com.example.customskeleton_android_2marking.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.customskeleton_android_2marking.CustomSkeleton.Skeleton
import com.example.customskeleton_android_2marking.CustomSkeleton.SkeletonScreen
import com.example.customskeleton_android_2marking.R
import com.example.customskeleton_android_2marking.ui.adapter.NewsAdapter
import com.example.customskeleton_android_2marking.ui.adapter.PersonAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private var mType: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)
        mType = intent.getStringExtra(PARAMS_TYPE)
        init()
    }

    private fun init() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        if (TYPE_LINEAR == mType) {
            recyclerView.layoutManager = LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
            val adapter = NewsAdapter()
            val skeletonScreen: SkeletonScreen =
                Skeleton.bind(recyclerView)
                    .adapter(adapter)
                    .shimmer(true)
                    .angle(20)
                    .frozen(false)
                    .duration(1200)
                    .count(10)
                    .load(R.layout.item_skeleton_news)
                    .show() //default count is 10
            recyclerView.postDelayed({ skeletonScreen.hide() }, 3000)
            return
        }
        if (TYPE_GRID == mType) {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
            val adapter = PersonAdapter()
            val skeletonScreen: SkeletonScreen =
                Skeleton.bind(recyclerView)
                    .adapter(adapter)
                    .load(R.layout.item_skeleton_person)
                    .shimmer(false)
                    .show()
            recyclerView.postDelayed({ skeletonScreen.hide() }, 3000)
        }
    }

    companion object {
        private const val PARAMS_TYPE = "params_type"
        const val TYPE_LINEAR = "type_linear"
        const val TYPE_GRID = "type_grid"
        fun start(context: Context, type: String?) {
            val intent = Intent(context, RecyclerViewActivity::class.java)
            intent.putExtra(PARAMS_TYPE, type)
            context.startActivity(intent)
        }
    }
}