package com.example.kurdpoem.model;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;

public class MyPref {

    private final Context context;
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;

    public static final String ID = "ID";

    public MyPref(Context context) {
        this.context = context;

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void saveUserData(UserDataModel userDataModel){

        editor.putString(ID , userDataModel.getId());
    }

    ArrayList data;

    public void delete(FavoriteListModel favoriteListModel){

        data.remove(favoriteListModel);
    }
}
