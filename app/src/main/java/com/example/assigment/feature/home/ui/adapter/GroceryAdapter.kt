package com.example.assigment.feature.home.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assigment.databinding.NameCartBinding
import com.example.assigment.feature.home.data.model.dto.Category
import com.example.assigment.feature.home.data.model.dto.GroceryItemDto

class GroceryAdapter : RecyclerView.Adapter<GroceryAdapter.ViewHolder>() {

    private var items: List<GroceryItemDto> = emptyList()

    class ViewHolder(val binding: NameCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NameCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = items[position].name
            // Load image using Glide or Picasso
            Glide.with(holder.itemView.context)
                .load(items[position].image)
                .into(holder.binding.ivImage)
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(newItems: List<GroceryItemDto>) {
        items = newItems
        notifyDataSetChanged()
    }
}