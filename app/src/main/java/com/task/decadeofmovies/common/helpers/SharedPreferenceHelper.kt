package com.task.decadeofmovies.common.helpers

import android.content.Context
import android.content.SharedPreferences
import com.task.base.helpers.ISharedPreferenceHelper


class SharedPreferenceHelper(private val context: Context): ISharedPreferenceHelper {
    var prefs: SharedPreferences = context.getSharedPreferences(
        "com.task.decadeofmovies", Context.MODE_PRIVATE
    )
    override fun saveBoolean(key: String, value: Boolean): Boolean {
       return prefs.edit().putBoolean(key, value).commit()
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return prefs.getBoolean(key,true)
    }
}