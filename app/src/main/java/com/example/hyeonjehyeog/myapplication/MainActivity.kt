package com.example.hyeonjehyeog.myapplication

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.ScrollView
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        Timber.d("MainActivity created")

        val layout = findViewById<LinearLayout>(R.id.layout)

        addChildViews(layout)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Timber.d("ScrollView setListener")
//            findViewById<ScrollView>(R.id.scroll_view).setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
//                val view = (v as ScrollView).let {
//                    it.getChildAt(v.childCount - 1)
//                }
////                Timber.d("view.bottom: ${view.bottom}, v.height: ${v.height}, scrollY: $scrollY")
//                if (view.bottom == v.height + scrollY) {
//                    Timber.d("isBottom!")
//                    addChildViews(layout)
//                }
//            }
        }
    }

    private fun addChildViews(layout: LinearLayout) {
        (0..100).map {
            LayoutInflater.from(this).inflate(R.layout.item, null)
        }.forEach {
            layout.addView(it)
        }
    }
}
