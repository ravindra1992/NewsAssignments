package com.example.newsassignment.network

import com.example.newsassignment.model.ApiResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/v2/top-headlines?country=in")
    fun getNews(@Query("apiKey") apiKey:String): Deferred<Response<ApiResponse>>

}