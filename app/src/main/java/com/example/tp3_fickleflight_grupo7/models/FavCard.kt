package com.example.tp3_fickleflight_grupo7.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_table")
data class FavCard(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "isFavorite") val isFavorite: Boolean = false
)
