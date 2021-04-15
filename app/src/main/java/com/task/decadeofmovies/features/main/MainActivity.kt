package com.task.decadeofmovies.features.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }
}