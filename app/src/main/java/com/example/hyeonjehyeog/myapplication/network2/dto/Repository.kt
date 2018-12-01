package com.example.hyeonjehyeog.myapplication.network2.dto

data class Repository(
        val id: Long,
        val name: String,
        val fullName: String?,
        val description: String,
        val owner: Owner
)