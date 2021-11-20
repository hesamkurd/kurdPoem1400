package com.example.kurdpoem.model

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager


class SharedPref(private val context: Context) {

    private val sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor


    companion object {
        const val ID = "ID"
        const val PHONE = "PHONE"
        const val EMAIL = "EMAIL"
        const val IS_LOGGED_ID = "IS_LOGGED_ID"
    }

    init {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        editor = sharedPreferences.edit()
    }

    fun saveUserData(userDataModel: UserDataModel) {

        editor.putString(ID, userDataModel.id)
        editor.putString(PHONE, userDataModel.phone)
        editor.putString(EMAIL, userDataModel.email)
        editor.putBoolean(IS_LOGGED_ID, true)
        editor.commit()
    }

    fun logout(){

        editor.clear()
        editor.commit()
    }

    fun getUserData(): HashMap<String, String>{

        val userData: HashMap<String,String> = HashMap()
        userData.put(ID, sharedPreferences.getString(ID, null)!!)
        userData.put(PHONE, sharedPreferences.getString(PHONE, null)!!)
        userData.put(EMAIL, sharedPreferences.getString(EMAIL, null)!!)
        return userData
    }

    fun isLoggedIn(): Boolean{

        return sharedPreferences.getBoolean(IS_LOGGED_ID , false)
    }




}


