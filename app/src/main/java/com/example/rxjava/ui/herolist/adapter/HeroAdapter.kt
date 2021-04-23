package com.example.rxjava.ui.herolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.dto.Hero
import com.example.rxjava.R

class HeroAdapter (
    private  val openHero: (itemPosition: Int) -> Unit
): RecyclerView.Adapter<HeroHolder>() {

    private var heroList = ArrayList<Hero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(View(parent.context))
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {

    }


    fun changeData(heroList: ArrayList<Hero>) {
        val difUtilCallback = CommentsDiffUtil(this.heroList, heroList)
        val difResult = DiffUtil.calculateDiff(difUtilCallback)
        this.heroList = heroList
        difResult.dispatchUpdatesTo(
            this
        )

    }

}



class CommentsDiffUtil(
    private val old: ArrayList<Hero>,
    private val new: ArrayList<Hero>
) : DiffUtil.Callback() {
    override fun getOldListSize() = old.size
    override fun getNewListSize() = new.size
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].id == new[newItemPosition].id
    }
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }
}