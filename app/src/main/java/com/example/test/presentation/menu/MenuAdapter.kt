package com.example.test.presentation.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.databinding.RecyclerViewMenuBinding
import com.example.test.presentation.menu.models.MealInfo

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.MenuViewHolder {
        val binding = RecyclerViewMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class MenuViewHolder(private val binding: RecyclerViewMenuBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(vo: MealInfo) {
            binding.apply {
                headerTitle.text = vo.header
                description.text = vo.description
                price.text = vo.price
                Glide.with(imageView)
                    .load(vo.icon)
                    .centerCrop()
                    .into(imageView)
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<MealInfo>() {
        override fun areItemsTheSame(oldItem: MealInfo, newItem: MealInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MealInfo, newItem: MealInfo): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}