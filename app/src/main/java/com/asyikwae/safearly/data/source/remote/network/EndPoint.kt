package com.asyikwae.safearly.data.source.remote.network

import com.asyikwae.safearly.data.source.remote.response.Response
import retrofit2.http.GET

interface EndPoint {
    @GET("articles")
    fun getArticles(): Response
}