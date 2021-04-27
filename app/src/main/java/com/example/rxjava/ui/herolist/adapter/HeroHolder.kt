package com.example.rxjava.ui.herolist.adapter

import android.graphics.BitmapFactory
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.domain.model.HeroModel
import com.example.domain.model.dto.Hero
import com.example.rxjava.R
import com.example.rxjava.databinding.FragmentTestBinding
import com.squareup.picasso.Picasso
import java.io.File

class HeroHolder(itemView: View
): RecyclerView.ViewHolder(itemView) {
    val tvName: TextView = itemView.findViewById(R.id.tvHeroName)
    val icon: ImageView = itemView.findViewById(R.id.icon)


    fun bind(item: HeroModel, position: Int) {
        tvName.text = item.localizedName
        val file  = File(item.icon)
        val bitmap = BitmapFactory.decodeFile(file.absolutePath)
        icon.setImageBitmap(bitmap)
    }
}