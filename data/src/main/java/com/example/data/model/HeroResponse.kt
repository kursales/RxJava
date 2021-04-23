package com.example.data.model

import com.google.gson.annotations.SerializedName

data class HeroResponse (
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("localized_name") val localizedName: String,
        @SerializedName("primary_attr") val primaryAttr: String,
        @SerializedName("attack_type") val attackType: String
)
