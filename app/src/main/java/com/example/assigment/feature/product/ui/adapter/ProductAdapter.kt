package com.example.assigment.feature.product.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assigment.databinding.ProductItemBinding
import com.example.assigment.feature.product.domain.model.Product

class ProductAdapter(val productClick: (id:String) -> Unit,val productRemove: (id:String) -> Unit) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private var items:List<Product> = emptyList()

    class ViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productInnerAdapter by lazy { ProductInnerAdapter(productClick,productRemove) }
        productInnerAdapter.submitList(items[position].arraydata)
        holder.binding.apply {
            tvName.text = items[position].name
            rvProductInner.adapter = productInnerAdapter
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(newItems: List<Product>) {
        items = newItems
        notifyDataSetChanged()
    }
}