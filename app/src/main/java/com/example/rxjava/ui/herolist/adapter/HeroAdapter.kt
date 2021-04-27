package com.example.rxjava.ui.herolist.adapter

import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.HeroModel
import com.example.domain.model.dto.Hero
import com.example.rxjava.R
import com.example.rxjava.common.constants.HERO_CONSTANT
import com.example.rxjava.common.constants.HERO_INFORMATION_CONSTANT
import java.io.File

class HeroAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var heroList = ArrayList<HeroModel>()
    var activeCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == HERO_CONSTANT) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_hero, parent, false)
            return HeroHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.hero_information_item, parent, false)
            return InformationHolder(view)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (heroList[position].type == HERO_CONSTANT) {
            HERO_CONSTANT
        } else {
           HERO_INFORMATION_CONSTANT
        }
    }

    override fun getItemCount(): Int {
        return heroList.size+ activeCount
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (heroList[position].type == HERO_CONSTANT) {
            (holder as HeroHolder).bind(heroList[position], position)
//            holder.itemView.setOnClickListener {
//                if(heroList[position].parent == HERO_CONSTANT&&heroList[position].type == HERO_CONSTANT) {
//                    val hero = HeroModel(
//                        heroList[position].id,
//                        heroList[position].type,
//                        heroList[position].name,
//                        heroList[position].localizedName,
//                        heroList[position].primaryAttr,
//                        heroList[position].attackType,
//                        heroList[position].icon,
//                        heroList[position].parent
//                    )
//                    heroList.add(position, hero)
//                    heroList[position + 1].type = HERO_INFORMATION_CONSTANT
//                    heroList[position].parent = HERO_INFORMATION_CONSTANT
//                    changeData(heroList)
//
//                    insertElement(position + 1)
//                }else if (heroList[position].parent == HERO_INFORMATION_CONSTANT&&heroList[position].type == HERO_CONSTANT){
//                    heroList[position].parent = HERO_CONSTANT
//                    heroList.remove(heroList[position+1])
//                    removeElement(position+1)
//                    notifyDataSetChanged()
//
//                }
//            }
//        } else {
//                (holder as InformationHolder).onBind(heroList[position], position)
//        }

        }
    }
        fun insertElement(position: Int) {
            notifyItemInserted(position)

        }

        fun removeElement(position: Int) {
            notifyItemRemoved(position)
        }

        fun changeData(heroList: ArrayList<HeroModel>) {
            val difUtilCallback = CommentsDiffUtil(this.heroList, heroList)
            val difResult = DiffUtil.calculateDiff(difUtilCallback)
            this.heroList = heroList
            difResult.dispatchUpdatesTo(
                this
            )

        }

        inner class HeroHolder(
            itemView: View
        ) : RecyclerView.ViewHolder(itemView) {
            val tvName: TextView = itemView.findViewById(R.id.tvHeroName)
            val icon: ImageView = itemView.findViewById(R.id.icon)


            fun bind(item: HeroModel, position: Int) {
                tvName.text = item.localizedName
                val file = File(item.icon)
                val bitmap = BitmapFactory.decodeFile(file.absolutePath)
                icon.setImageBitmap(bitmap)
            }

            init {

                itemView.setOnClickListener {
                    if (heroList[adapterPosition].parent == HERO_CONSTANT && heroList[adapterPosition].type == HERO_CONSTANT) {
                        val hero = HeroModel(
                            heroList[adapterPosition].id,
                            heroList[adapterPosition].type,
                            heroList[adapterPosition].name,
                            heroList[adapterPosition].localizedName,
                            heroList[adapterPosition].primaryAttr,
                            heroList[position].attackType,
                            heroList[adapterPosition].icon,
                            heroList[adapterPosition].parent
                        )
                        heroList.add(adapterPosition, hero)
                        heroList[adapterPosition + 1].type = HERO_INFORMATION_CONSTANT
                        heroList[adapterPosition].parent = HERO_INFORMATION_CONSTANT
                        changeData(heroList)

                        insertElement(adapterPosition + 1)
                    } else if (heroList[adapterPosition].parent == HERO_INFORMATION_CONSTANT && heroList[position].type == HERO_CONSTANT) {
                        heroList[adapterPosition].parent = HERO_CONSTANT
                        heroList.remove(heroList[adapterPosition + 1])
                        removeElement(adapterPosition + 1)
                    }
                }
            }

        }
    }


class CommentsDiffUtil(
    private val old: ArrayList<HeroModel>,
    private val new: ArrayList<HeroModel>
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