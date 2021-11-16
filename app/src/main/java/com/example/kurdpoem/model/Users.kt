package com.example.kurdpoem.model

class Users {

    private var message: String? = null
    private var status: Boolean? = null
    private var data: UserDataModel? = null

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getStatus(): Boolean? {
        return status
    }

    fun setStatus(status: Boolean?) {
        this.status = status
    }

    fun getData(): UserDataModel? {
        return data
    }

    fun setData(data: UserDataModel?) {
        this.data = data
    }
}