package com.task.base.helpers

//This is supposed to include helper functions for save/get different data types,
// but since we need just the boolean for now we are good to go with :D
interface ISharedPreferenceHelper {
    fun saveBoolean(key: String, value: Boolean): Boolean
    fun getBoolean(key: String, defaultValue: Boolean): Boolean
}