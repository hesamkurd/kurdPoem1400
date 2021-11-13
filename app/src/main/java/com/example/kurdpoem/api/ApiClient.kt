package com.example.kurdpoem.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        var retrofit: Retrofit?= null

        var BASE_URL = "http://192.168.214.197/kurdistan_poem/"

        fun getApiClient(): Retrofit {

            val gson = GsonBuilder().setLenient().create()

            if (retrofit == null){

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }

            return retrofit!!

        }
    }

}