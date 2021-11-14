package com.example.kurdpoem.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kurdpoem.api.ApiClient
import com.example.kurdpoem.api.ApiService
import com.example.kurdpoem.model.*
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

    fun getAllBooksMutableLiveData(): MutableLiveData<List<AllBooksModel>>{

        val mutableLiveDataAllBooks = MutableLiveData<List<AllBooksModel>>()

        request.getAllBooks().enqueue(object : Callback<List<AllBooksModel>>{
            override fun onResponse(
                call: Call<List<AllBooksModel>>,
                response: Response<List<AllBooksModel>>
            ) {
                mutableLiveDataAllBooks.value = response.body()
            }

            override fun onFailure(call: Call<List<AllBooksModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }


        })
        return mutableLiveDataAllBooks
    }

    fun getMutableLiveDataPoemDetail(id: String): MutableLiveData<List<PoemDetailModel>>{

        val mutableLiveDataPoemDetail = MutableLiveData<List<PoemDetailModel>>()

        request.getPoemDetail(id).enqueue(object : Callback<List<PoemDetailModel>>{
            override fun onResponse(
                call: Call<List<PoemDetailModel>>,
                response: Response<List<PoemDetailModel>>
            ) {
                mutableLiveDataPoemDetail.value = response.body()
            }

            override fun onFailure(call: Call<List<PoemDetailModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }

        })
        return mutableLiveDataPoemDetail
    }

    fun getMutableLiveDataAllBooksList(): MutableLiveData<List<AllBooksModel>>{

        val mutableLiveDataAllBooksList = MutableLiveData<List<AllBooksModel>>()

        request.getAllBooksList().enqueue(object : Callback<List<AllBooksModel>>{
            override fun onResponse(
                call: Call<List<AllBooksModel>>,
                response: Response<List<AllBooksModel>>
            ) {
                mutableLiveDataAllBooksList.value = response.body()
            }

            override fun onFailure(call: Call<List<AllBooksModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)

            }

        })
        return mutableLiveDataAllBooksList
    }

    fun getMutableLiveDataBooksOfPoem(id: String): MutableLiveData<List<AllBooksModel>>{

        val mutableLiveDataBooksOfPoem = MutableLiveData<List<AllBooksModel>>()

        request.getBooksOfPoem(id).enqueue(object : Callback<List<AllBooksModel>>{
            override fun onResponse(
                call: Call<List<AllBooksModel>>,
                response: Response<List<AllBooksModel>>
            ) {
                mutableLiveDataBooksOfPoem.value = response.body()
            }

            override fun onFailure(call: Call<List<AllBooksModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }


        })
        return mutableLiveDataBooksOfPoem
    }

    fun getMutableLiveDataBookDetail(id: String): MutableLiveData<List<BookDetailModel>>{

        val mutableLiveDataBookDetail = MutableLiveData<List<BookDetailModel>>()

        request.getBookDetail(id).enqueue(object : Callback<List<BookDetailModel>>{
            override fun onResponse(
                call: Call<List<BookDetailModel>>,
                response: Response<List<BookDetailModel>>
            ) {
                mutableLiveDataBookDetail.value = response.body()
            }

            override fun onFailure(call: Call<List<BookDetailModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }


        })

        return mutableLiveDataBookDetail
    }

    fun getMutableLiveDataContentBook(id: String): MutableLiveData<List<ContentBookModel>>{

        val mutableLiveDataContentBook = MutableLiveData<List<ContentBookModel>>()

        request.getContentBook(id).enqueue(object : Callback<List<ContentBookModel>>{
            override fun onResponse(
                call: Call<List<ContentBookModel>>,
                response: Response<List<ContentBookModel>>
            ) {
                mutableLiveDataContentBook.value = response.body()
            }

            override fun onFailure(call: Call<List<ContentBookModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }


        })
        return mutableLiveDataContentBook
    }

    fun getMutableLiveDataVerseDetail(id: String): MutableLiveData<List<VerseDetailModel>>{

        val mutableLiveDataVerseDetail = MutableLiveData<List<VerseDetailModel>>()

        request.getVerseDetail(id).enqueue(object : Callback<List<VerseDetailModel>>{
            override fun onResponse(
                call: Call<List<VerseDetailModel>>,
                response: Response<List<VerseDetailModel>>
            ) {
                mutableLiveDataVerseDetail.value = response.body()
            }

            override fun onFailure(call: Call<List<VerseDetailModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)

            }


        })

        return mutableLiveDataVerseDetail
    }

    fun getMutableLiveDataVerse(id: String): MutableLiveData<List<VerseModel>>{

        val mutableLiveDataVerse = MutableLiveData<List<VerseModel>>()

        request.getVerse(id).enqueue(object : Callback<List<VerseModel>>{
            override fun onResponse(
                call: Call<List<VerseModel>>,
                response: Response<List<VerseModel>>
            ) {
                mutableLiveDataVerse.value = response.body()
            }

            override fun onFailure(call: Call<List<VerseModel>>, t: Throwable) {
                Log.i("Error" , "onFailure" + t.message)
            }


        })
        return mutableLiveDataVerse
    }

}