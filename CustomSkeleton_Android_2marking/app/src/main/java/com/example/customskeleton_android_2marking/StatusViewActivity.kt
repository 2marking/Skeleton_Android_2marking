package com.example.customskeleton_android_2marking

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.customskeleton_android_2marking.CustomSkeleton.ViewReplacer

class StatusViewActivity : AppCompatActivity() {
    private var mViewReplacer: ViewReplacer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_view)
        mViewReplacer = ViewReplacer(findViewById(R.id.tv_content))
        findViewById<View>(R.id.btn_loading).setOnClickListener { mViewReplacer!!.replace(R.layout.layout_progress) }
        findViewById<View>(R.id.btn_error).setOnClickListener { mViewReplacer!!.replace(R.layout.layout_error) }
        findViewById<View>(R.id.btn_empty).setOnClickListener { mViewReplacer!!.replace(R.layout.layout_empty_view) }
        findViewById<View>(R.id.btn_content).setOnClickListener { mViewReplacer!!.restore() }
    }

    fun gotoSet(view: View?) {
        val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
        startActivity(intent)
    }
}