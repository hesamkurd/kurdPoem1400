package com.example.kurdpoem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kurdpoem.model.AllPoemModel
import com.example.kurdpoem.model.NewsBannerModel
import com.example.kurdpoem.repository.Repository

class ViewModel : ViewModel() {

    val repository = Repository()

    fun getNewsBannerViewModel(): LiveData<List<NewsBannerModel>>{

        return repository.getRepositoryNewsBanner()
    }

    fun getAllPoemViewModel(): LiveData<List<AllPoemModel>>{

        return repository.getRepositoryAllPoem()
    }
}