package com.example.hyeonjehyeog.myapplication

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hyeonjehyeog.myapplication.network2.dto.Repository
import timber.log.Timber


class ViewHolder(
        itemView: View,
        private val eventListener: EventListener)
    : RecyclerView.ViewHolder(itemView) {

    fun onBind(repository: com.example.hyeonjehyeog.myapplication.network2.dto.Repository) {
        itemView.findViewById<TextView>(R.id.title_text_view)
                .text = repository.name

        itemView.findViewById<TextView>(R.id.sub_title_text_view)
                .text = repository.fullName

        itemView.findViewById<TextView>(R.id.description_text_view)
                .text = repository.description

        Glide.with(itemView)
                .load(repository.owner.avatarUrl)
                .into(itemView.findViewById(R.id.image_view))

        itemView.setOnClickListener {
            Timber.d("onClick!")
            eventListener.onClick(repository)
        }
    }

    interface EventListener {
        fun onClick(repository: Repository)
    }
}