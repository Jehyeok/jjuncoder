package com.example.hyeonjehyeog.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.hyeonjehyeog.myapplication.network2.ApiService
import com.example.hyeonjehyeog.myapplication.network2.dto.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers


class AdvancedNetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val adapter = Adapter(object: ViewHolder.EventListener {
            override fun onClick(repository: Repository) {
                startActivity(
                        Intent(this@AdvancedNetworkActivity,
                                GithubDetailActivity::class.java).apply {
                            putExtra("id", repository.id)
                        }
                )
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        ApiService
                .githubService
                .getRepoList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { repositories ->
                    adapter.items.addAll(repositories)
                    adapter.notifyDataSetChanged()
                }, Consumer {
                    it.printStackTrace()
                })
    }
}
