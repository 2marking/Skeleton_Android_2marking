package com.example.customskeleton_android_2marking.ui.adapter

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class SimpleRcvViewHolder(itemView: View?) : ViewHolder(itemView!!) {
    private val views = SparseArray<View?>()
    fun <V : View?> getView(resId: Int): V? {
        var v = views[resId]
        if (null == v) {
            v = itemView.findViewById(resId)
            views.put(resId, v)
        }
        return v as V?
    }
}