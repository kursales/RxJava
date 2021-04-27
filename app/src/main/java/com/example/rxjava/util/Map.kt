package com.example.rxjava.util

import com.example.domain.model.HeroModel
import com.example.domain.model.dto.Hero

fun Hero.mapToModel() = HeroModel(
    id = id,
    type = 1,
    name = name,
    localizedName = localizedName,
    primaryAttr = primaryAttr,
    attackType = attackType,
    icon = icon,
    parent = 1
)

fun List<Hero>.mapToHeroModelList():List<HeroModel>{
    return this.map{
        it.mapToModel()
    }
}