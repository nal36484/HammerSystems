package com.example.test.presentation.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.databinding.RecyclerViewBannerBinding

class BannersAdapter : RecyclerView.Adapter<BannersAdapter.BannersViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannersAdapter.BannersViewHolder {
        val binding = RecyclerViewBannerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BannersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannersAdapter.BannersViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    class BannersViewHolder(private val binding: RecyclerViewBannerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            binding.banner.setImageResource(R.drawable.banner)
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}