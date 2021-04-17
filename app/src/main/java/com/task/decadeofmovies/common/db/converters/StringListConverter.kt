package com.task.decadeofmovies.common.db.converters

import androidx.room.TypeConverter
import com.task.base.helpers.ISerializationHelper
import org.koin.core.KoinComponent
import org.koin.core.inject

object StringListConverter : KoinComponent {

    private val serializationHelper: ISerializationHelper by inject()

    @TypeConverter
    @JvmStatic
    fun fromStringListToString(list: List<String>): String {
        return serializationHelper.toJsonList(list, String::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun fromStringToList(string: String): List<String> {
        return serializationHelper.fromJsonList(string, String::class.java)
    }
}