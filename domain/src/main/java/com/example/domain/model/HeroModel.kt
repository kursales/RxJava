package com.example.domain.model

import androidx.room.ColumnInfo

data class HeroModel(
    val id: Int,
    var type: Int,
    val name: String,
    val localizedName: String,
    val primaryAttr: String,
    val attackType: String,
    var icon: String,
    var parent: Int
)