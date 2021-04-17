package com.task.base.helpers

interface ISerializationHelper {

    fun <T> fromJsonList(jsonList: String, jsonObjectClass: Class<T>): List<T>

    fun <T> toJsonList(list: List<T>, jsonObjectClass: Class<T>): String
}