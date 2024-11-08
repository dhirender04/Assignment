package com.example.assigment.feature.product.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.assigment.R
import com.example.assigment.databinding.FragmentProductBinding
import com.example.assigment.feature.product.domain.model.Product
import com.example.assigment.feature.product.domain.model.ProductListItem
import com.example.assigment.feature.product.ui.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProductFragment : Fragment() {
    var productList: ArrayList<Product> = ArrayList<Product>()
    private val binding: FragmentProductBinding by lazy {
        DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_product,
            null,
            false
        )
    }
    private val viewModel by viewModels<ProductViewModel>()
    var selectedProduct: ArrayList<ProductListItem> = ArrayList<ProductListItem>()

    val productClick: (id: String) -> Unit = { id ->
        // Your action here based on the product ID
        productList.forEach {
            it.arraydata.forEach {
                if (it.val_id == id) {
                    selectedProduct.add(it)
                    ProductUpdate()
                    Log.e("GetProductClick", "Product clicked: $it")
                }
            }
        }
        Log.e("GetProductClick", "Product clicked: $id") // Example: Print the product ID
    }
    val productRemoveClick: (id: String) -> Unit = { id ->
        // Your action here based on the product ID
        productList.forEach {
            it.arraydata.forEach {
                if (it.val_id == id) {
                    selectedProduct.remove(it)
                    Log.e("GetProductClick", "Product clicked: $it")
                    ProductUpdate()
                }
            }
        }
        Log.e("GetProductClick", "Product clicked: $id") // Example: Print the product ID
    }
    private val productAdapter by lazy { ProductAdapter(productClick, productRemoveClick) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.updateProductData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvProductList.adapter = productAdapter
            btnCheckout.setOnClickListener {
                ProductUpdate()

            }
            btnCheckoutPay.setOnClickListener {
                btnCheckout.isVisible = true
                clContainer.isVisible = false
                Toast.makeText(
                    requireContext(),
                    selectedProduct.map { it.name }.toString(),
                    Toast.LENGTH_LONG
                ).show()

            }
        }
        viewModel.getProductData().observe(viewLifecycleOwner) {
            Log.e(
                "onViewCreated:ProductData ", it.toString()
            )
            productList.clear()
            productList.addAll(it)
            productAdapter.submitList(it)

        }

    }
    private fun ProductUpdate(){
        var sum =0f
        if (selectedProduct.size > 0) {
           binding.btnCheckout.isVisible = false
            selectedProduct.map {
                val priceValue =  it.price.replace("$","")
                sum +=priceValue.toFloat()
            }
            binding.clContainer.isVisible = true
            binding.tvItemCount.text = "Item Selected :${selectedProduct.size.toString()} : Total : $${sum}"

        } else {
            Toast.makeText(
                requireContext(),
                "Select Atleast one product",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}