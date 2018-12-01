package com.example.hyeonjehyeog.myapplication.network2.rest

import com.example.hyeonjehyeog.myapplication.network2.dto.Repository
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {

    @GET("repositories")
    fun getRepoList(): Single<List<Repository>>

    @GET("repositories/{id}")
    fun getRepo(@Path("id") id: Long): Single<Repository>
}