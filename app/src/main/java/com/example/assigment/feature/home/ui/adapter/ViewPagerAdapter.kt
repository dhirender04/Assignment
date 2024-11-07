package com.example.assigment.feature.home.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assigment.R
import com.example.assigment.databinding.ItemViewPagerBinding
import com.example.assigment.feature.home.data.model.dto.Slider

class ViewPagerAdapter(private val imageUrls: List<Slider>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemViewPagerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Load image using Glide or Picasso
        Glide.with(holder.itemView.context)
            .load(imageUrls[position].image)
            .into(holder.binding.ivImage)

        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return imageUrls.size
    }
}