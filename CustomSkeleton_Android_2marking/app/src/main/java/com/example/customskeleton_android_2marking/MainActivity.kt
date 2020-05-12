package com.example.customskeleton_android_2marking

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_list).setOnClickListener {
            RecyclerViewActivity.Companion.start(
                this@MainActivity,
                RecyclerViewActivity.Companion.TYPE_LINEAR
            )
        }
        findViewById<View>(R.id.btn_grid).setOnClickListener {
            RecyclerViewActivity.Companion.start(
                this@MainActivity,
                RecyclerViewActivity.Companion.TYPE_GRID
            )
        }
        findViewById<View>(R.id.btn_view).setOnClickListener {
            ViewActivity.Companion.start(
                this@MainActivity,
                ViewActivity.Companion.TYPE_VIEW
            )
        }
        findViewById<View>(R.id.btn_Imgloading).setOnClickListener {
            ViewActivity.Companion.start(
                this@MainActivity,
                ViewActivity.Companion.TYPE_IMG_LOADING
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