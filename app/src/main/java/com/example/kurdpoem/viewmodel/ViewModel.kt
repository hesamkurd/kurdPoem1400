package com.example.kurdpoem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kurdpoem.model.*
import com.example.kurdpoem.repository.Repository

class ViewModel : ViewModel() {

    val repository = Repository()

    fun getNewsBannerViewModel(): LiveData<List<NewsBannerModel>>{

        return repository.getRepositoryNewsBanner()
    }

    fun getAllPoemViewModel(): LiveData<List<AllPoemModel>>{

        return repository.getRepositoryAllPoem()
    }

    fun getAllBooksViewModel(): LiveData<List<AllBooksModel>>{

        return repository.getRepositoryAllBooks()

    }

    fun getPoemDetailViewModel(id: String): LiveData<List<PoemDetailModel>>{

        return repository.getRepositoryPoemDetail(id)
    }

    fun getAllBooksListViewModel(): LiveData<List<AllBooksModel>>{

        return repository.getRepositoryAllBooksList()
    }

    fun getBooksOfPoemViewModel(id: String): LiveData<List<AllBooksModel>>{

        return repository.getRepositoryBooksOfPoem(id)
    }

    fun getBookDetailViewModel(id: String): LiveData<List<BookDetailModel>>{

        return repository.getRepositoryBookDetail(id)
    }

    fun getContentBookViewModel(id: String): LiveData<List<ContentBookModel>>{

        return repository.getRepositoryContentBook(id)
    }

    fun getVerseDetailViewModel(id: String): LiveData<List<VerseDetailModel>>{

        return repository.getRepositoryVerseDetail(id)
    }

    fun getVerseViewModel(id: String): LiveData<List<VerseModel>>{

        return repository.getRepositoryVerse(id)
    }
}