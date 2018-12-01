package com.example.hyeonjehyeog.myapplication

interface OnLoadData<T> {
    fun run(list: List<T>)
}