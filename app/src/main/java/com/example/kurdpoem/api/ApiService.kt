package com.example.kurdpoem.api

import com.example.kurdpoem.model.AllPoemModel
import com.example.kurdpoem.model.NewsBannerModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("getNewsBanner.php")
    fun getNewsBanner(): Call<List<NewsBannerModel>>

    @GET("gatAllPoem.php")
    fun getAllPoem(): Call<List<AllPoemModel>>
}