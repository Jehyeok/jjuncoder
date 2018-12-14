package com.example.hyeonjehyeog.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.airbnb.deeplinkdispatch.DeepLink
import com.example.hyeonjehyeog.myapplication.network2.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import android.support.v4.app.NotificationCompat.getExtras




@DeepLink("foo://detail/{id}")
class GithubDetailActivity2 : AppCompatActivity() {

    private var id: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_detail)

        id = if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            val parameters = intent.extras
            val idString = parameters.getString("id")
            // Do something with idString
            idString.toLong()
        } else {
            savedInstanceState?.getLong("id")
                    ?: intent.getLongExtra("id", 0)
        }

        ApiService.githubService
                .getRepo(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {
                    findViewById<TextView>(R.id.name_text_view)
                            .text = it.name
                })

        findViewById<TextView>(R.id.name_text_view)
                .setOnClickListener {

                }

        Timber.d("onCreate")
    }
}
