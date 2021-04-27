package com.example.rxjava.ui.herolist.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HeroModel
import com.example.domain.model.dto.Hero
import com.example.rxjava.R

class InformationHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val primaryAttr: TextView = itemView.findViewById(R.id.tvPrimaryAttr)
    val baseHealth: TextView = itemView.findViewById(R.id.tvBaseHealth)
    val baseMana: TextView = itemView.findViewById(R.id.tvBaseMana)

    fun onBind(hero: HeroModel, position: Int){
        primaryAttr.text = hero.primaryAttr
    }
}