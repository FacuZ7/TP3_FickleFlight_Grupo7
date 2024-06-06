package com.example.tp3_fickleflight_grupo7.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp3_fickleflight_grupo7.dao.FavCardDao
import com.example.tp3_fickleflight_grupo7.models.FavCard

@Database(entities = [FavCard::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favCardDao(): FavCardDao
}