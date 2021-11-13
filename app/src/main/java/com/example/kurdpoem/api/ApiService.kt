package com.example.kurdpoem.api

import com.example.kurdpoem.model.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("getNewsBanner.php")
    fun getNewsBanner(): Call<List<NewsBannerModel>>

    @GET("gatAllPoem.php")
    fun getAllPoem(): Call<List<AllPoemModel>>

    @GET("getBooksOfHome.php")
    fun getAllBooks(): Call<List<AllBooksModel>>

    @FormUrlEncoded
    @POST("getPoemDetail.php")
    fun getPoemDetail(@Field("id")id: String): Call<List<PoemDetailModel>>

    @GET("getAllBooks.php")
    fun getAllBooksList(): Call<List<AllBooksModel>>

    @FormUrlEncoded
    @POST("getBooksOfPoem.php")
    fun getBooksOfPoem(@Field("id")id: String): Call<List<AllBooksModel>>


    @FormUrlEncoded
    @POST("getBookDetail.php")
    fun getBookDetail(@Field("id")id: String): Call<List<BookDetailModel>>
}