package com.example.hyeonjehyeog.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.LinearLayout

class MainActivity2 : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val layout = findViewById<LinearLayout>(R.id.layout)

        val views = (0..1000).map {
            LayoutInflater
                    .from(this)
                    .inflate(R.layout.item, null)
        }

        views.forEach { view ->
            layout.addView(view)
        }
    }
}
