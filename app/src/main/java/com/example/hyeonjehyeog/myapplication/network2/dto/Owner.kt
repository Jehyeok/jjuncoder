package com.example.hyeonjehyeog.myapplication.network2.dto

import com.google.gson.annotations.SerializedName

data class Owner(
        @SerializedName("avatar_url")
        val avatarUrl: String?
)