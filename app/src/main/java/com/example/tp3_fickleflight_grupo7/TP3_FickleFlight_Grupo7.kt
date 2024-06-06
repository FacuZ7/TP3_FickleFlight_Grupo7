package com.example.tp3_fickleflight_grupo7

import android.app.Application
import androidx.room.Room
import com.example.tp3_fickleflight_grupo7.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TP3_FickleFlight_Grupo7 : Application(){
    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "fav_database"
    ).build()
}

