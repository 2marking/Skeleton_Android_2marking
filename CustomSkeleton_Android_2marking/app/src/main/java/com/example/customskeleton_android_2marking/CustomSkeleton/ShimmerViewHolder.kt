package com.example.customskeleton_android_2marking.CustomSkeleton

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.customskeleton_android_2marking.R

class ShimmerViewHolder(
    inflater: LayoutInflater,
    parent: ViewGroup?,
    innerViewResId: Int
) : ViewHolder(inflater.inflate(R.layout.layout_shimmer, parent, false)) {
    init {
        val layout = itemView as ViewGroup
        val view = inflater.inflate(innerViewResId, layout, false)
        val lp = view.layoutParams
        if (lp != null) {
            layout.layoutParams = lp
        }
        layout.addView(view)
    }
}