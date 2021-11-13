package com.example.kurdpoem.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kurdpoem.api.ApiClient
import com.example.kurdpoem.api.ApiService
import com.example.kurdpoem.model.AllPoemModel
import com.example.kurdpoem.model.NewsBannerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainResponse {

    var request = ApiClient.getApiClient().create(ApiService::class.java)

    fun getNewsBannerMutableLiveData(): MutableLiveData<List<NewsBannerModel>>{

        val mutableLiveDataNewsBanner = MutableLiveData<List<NewsBannerModel>>()

        request.getNewsBanner().enqueue(object : Callback<List<NewsBannerModel>>{
            override fun onResponse(
                call: Call<List<NewsBannerModel>>,
                response: Response<List<NewsBannerModel>>
            ) {
                mutableLiveDataNewsBanner.value = response.body()
            }

            override fun onFailure(call: Call<List<NewsBannerModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }


        })
        return mutableLiveDataNewsBanner
    }

    fun getAllPoemMutableLiveData(): MutableLiveData<List<AllPoemModel>>{

        val mutableLiveDataAllPoem = MutableLiveData<List<AllPoemModel>>()

        request.getAllPoem().enqueue(object : Callback<List<AllPoemModel>>{
            override fun onResponse(
                call: Call<List<AllPoemModel>>,
                response: Response<List<AllPoemModel>>
            ) {
                mutableLiveDataAllPoem.value = response.body()
            }

            override fun onFailure(call: Call<List<AllPoemModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }


        })

        return mutableLiveDataAllPoem
    }
}