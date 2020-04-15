package com.yeonproject.dodam_mvp.data.repository

interface Callback<T> {
    fun onSuccess(response: T)
    fun onFailure(message: String)
}