package com.example.customskeleton_android_2marking.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.customskeleton_android_2marking.R

class PersonAdapter : RecyclerView.Adapter<SimpleRcvViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleRcvViewHolder {
        return SimpleRcvViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SimpleRcvViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 10
    }
}