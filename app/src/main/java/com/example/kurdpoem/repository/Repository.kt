package com.example.kurdpoem.repository

import androidx.lifecycle.LiveData
import com.example.kurdpoem.model.*

class Repository {

    var mainResponse = MainResponse()

    fun getRepositoryNewsBanner(): LiveData<List<NewsBannerModel>>{

        return mainResponse.getNewsBannerMutableLiveData()
    }

    fun getRepositoryAllPoem(): LiveData<List<AllPoemModel>>{

        return mainResponse.getAllPoemMutableLiveData()
    }

    fun getRepositoryAllBooks(): LiveData<List<AllBooksModel>>{

        return mainResponse.getAllBooksMutableLiveData()
    }

    fun getRepositoryPoemDetail(id: String): LiveData<List<PoemDetailModel>>{

        return mainResponse.getMutableLiveDataPoemDetail(id)
    }

    fun getRepositoryAllBooksList(): LiveData<List<AllBooksModel>>{

        return mainResponse.getMutableLiveDataAllBooksList()
    }

    fun getRepositoryBooksOfPoem(id: String): LiveData<List<AllBooksModel>>{

        return mainResponse.getMutableLiveDataBooksOfPoem(id)
    }

    fun getRepositoryBookDetail(id: String): LiveData<List<BookDetailModel>>{

        return mainResponse.getMutableLiveDataBookDetail(id)
    }

    fun getRepositoryContentBook(id: String): LiveData<List<ContentBookModel>>{

        return mainResponse.getMutableLiveDataContentBook(id)
    }

    fun getRepositoryVerseDetail(id: String): LiveData<List<VerseDetailModel>>{

        return mainResponse.getMutableLiveDataVerseDetail(id)
    }

    fun getRepositoryVerse(id: String): LiveData<List<VerseModel>>{

        return mainResponse.getMutableLiveDataVerse(id)
    }
}