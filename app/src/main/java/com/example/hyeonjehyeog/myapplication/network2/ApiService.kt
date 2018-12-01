package com.example.hyeonjehyeog.myapplication.network2

import com.example.hyeonjehyeog.myapplication.network2.rest.GithubService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    companion object {
        lateinit var githubService: GithubService

        fun init() {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            githubService = retrofit.create(GithubService::class.java)
        }
    }
}