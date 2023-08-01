package com.example.yesmachintest.network

import com.example.yesmachintest.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("marvel")
    fun getQuotes(): Call<List<DataModel>>
}