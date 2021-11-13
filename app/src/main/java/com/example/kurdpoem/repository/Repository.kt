package com.example.kurdpoem.repository

import androidx.lifecycle.LiveData
import com.example.kurdpoem.model.AllPoemModel
import com.example.kurdpoem.model.NewsBannerModel

class Repository {

    var mainResponse = MainResponse()

    fun getRepositoryNewsBanner(): LiveData<List<NewsBannerModel>>{

        return mainResponse.getNewsBannerMutableLiveData()
    }

    fun getRepositoryAllPoem(): LiveData<List<AllPoemModel>>{

        return mainResponse.getAllPoemMutableLiveData()
    }
}