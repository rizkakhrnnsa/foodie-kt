package com.rizka.foodie.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rizka.foodie.data.Foodie
import com.rizka.foodie.databinding.ItemFoodsBinding
import com.rizka.foodie.utils.Utils.loadImage

class FoodieListAdapter: ListAdapter<Foodie, FoodieListAdapter.ViewHolder>(foodieCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemFoodsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemFoodsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Foodie) = with(binding){
            imgFoodie.loadImage(data.imageFoodie)
            tvFoodieName.text = data.nameFoodie
            tvFoodieDescription.text = data.descriptionFoodie

            itemFoodie.setOnClickListener {
                val intent = Intent(it.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, data)
                it.context.startActivity(intent)
            }
        }
    }

    companion object {
        val foodieCallback = object : DiffUtil.ItemCallback<Foodie>(){
            override fun areItemsTheSame(oldItem: Foodie, newItem: Foodie): Boolean {
                return oldItem.nameFoodie == newItem.nameFoodie
            }

            override fun areContentsTheSame(oldItem: Foodie, newItem: Foodie): Boolean {
                return oldItem == newItem
            }
        }
    }
}