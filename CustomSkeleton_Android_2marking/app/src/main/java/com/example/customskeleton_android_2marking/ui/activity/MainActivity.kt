package com.example.customskeleton_android_2marking.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.customskeleton_android_2marking.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_list).setOnClickListener {
            RecyclerViewActivity.start(
                this@MainActivity,
                RecyclerViewActivity.TYPE_LINEAR
            )
        }
        findViewById<View>(R.id.btn_grid).setOnClickListener {
            RecyclerViewActivity.start(
                this@MainActivity,
                RecyclerViewActivity.TYPE_GRID
            )
        }
        findViewById<View>(R.id.btn_view).setOnClickListener {
            ViewActivity.start(
                this@MainActivity,
                ViewActivity.TYPE_VIEW
            )
        }
        findViewById<View>(R.id.btn_Imgloading).setOnClickListener {
            ViewActivity.start(
                this@MainActivity,
                ViewActivity.TYPE_IMG_LOADING
            )
        }
        findViewById<View>(R.id.btn_status).setOnClickListener {
            startActivity(
                Intent(
                    this@MainActivity,
                    StatusViewActivity::class.java
                )
            )
        }
    }
}