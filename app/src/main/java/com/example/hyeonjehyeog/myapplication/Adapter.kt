package com.example.hyeonjehyeog.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.hyeonjehyeog.myapplication.network2.dto.Repository
import timber.log.Timber

class Adapter(private val eventListener: ViewHolder.EventListener): RecyclerView.Adapter<ViewHolder>() {
    var items = mutableListOf<Repository>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d("onnCreateView")

        return ViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item, null), eventListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Timber.d("onnBindView: $position")
        viewHolder.onBind(items[position])
    }

    override fun onViewRecycled(holder: ViewHolder) {
        super.onViewRecycled(holder)

        val itemView = holder.itemView
        Glide.with(itemView)
                .clear(itemView
                        .findViewById<ImageView>(R.id.image_view))
    }
}