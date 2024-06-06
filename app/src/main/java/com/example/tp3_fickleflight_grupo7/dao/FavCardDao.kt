package com.example.tp3_fickleflight_grupo7.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp3_fickleflight_grupo7.models.FavCard

@Dao
interface FavCardDao {
    @Query("SELECT * FROM fav_table WHERE id = :id")
    suspend fun getFavCard(id: Int): FavCard?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(favCard: FavCard)
}