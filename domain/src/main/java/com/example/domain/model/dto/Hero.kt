package com.example.domain.model.dto

import androidx.annotation.Nullable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hero(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "localizedName") val localizedName: String,
    @ColumnInfo(name = "primaryAttr") val primaryAttr: String,
    @ColumnInfo(name = "attackType") val attackType: String,
    @ColumnInfo(name = "icon") var icon: String
)


