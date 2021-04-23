package com.example.data.mapper

import com.example.data.model.HeroResponse
import com.example.domain.model.dto.Hero

fun HeroResponse.mapToUser() = Hero(
    id = id,
    name = name,
    localizedName = localizedName,
    primaryAttr = primaryAttr,
    attakType = attackType

)

fun List<HeroResponse>.mapToUsersList(): List<Hero> {
    return this.map {
        it.mapToUser()
    }
}