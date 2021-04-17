package com.task.decadeofmovies.common.helpers

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.task.base.helpers.ISerializationHelper
import java.lang.reflect.Type

class SerilizationHelper: ISerializationHelper {

    override fun <T> fromJsonList(jsonList: String, jsonObjectClass: Class<T>): List<T> {
        val itemListType: Type = object : TypeToken<ArrayList<T?>?>() {}.getType()
        return Gson().fromJson(jsonList,itemListType)
    }

    override fun <T> toJsonList(list: List<T>, jsonObjectClass: Class<T>): String {
       return Gson().toJson(list)
    }
}