package com.example.assigment.feature.product.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assigment.databinding.ProductListItemBinding
import com.example.assigment.feature.product.domain.model.ProductListItem
import kotlin.math.truncate

class ProductInnerAdapter(val productClick: (id:String) -> Unit,val productRemove: (id:String) -> Unit) : RecyclerView.Adapter<ProductInnerAdapter.ViewHolder>() {

    private var items: List<ProductListItem> = emptyList()

    class ViewHolder(val binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            var flag = true
            btnAdd.setOnClickListener {
                productClick(items[position].val_id)
                btnAdd.isEnabled = !flag// Disable btnAdd when flag is true
                btnRemove.isEnabled = flag

            }
            btnRemove.setOnClickListener {
                productRemove(items[position].val_id)
                btnAdd.isEnabled = flag // Enable btnAdd when flag is false
                btnRemove.isEnabled = !flag //
            }
            tvName.text = "${items[position].name +"  "+ items[position].price}"
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

    fun submitList(newItems: List<ProductListItem>) {
        items = newItems
        notifyDataSetChanged()
    }
}