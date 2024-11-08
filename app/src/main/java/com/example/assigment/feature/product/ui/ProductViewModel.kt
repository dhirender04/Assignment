package com.example.assigment.feature.product.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assigment.feature.product.data.model.dto.ProductDto
import com.example.assigment.feature.product.data.repository_impl.ProductRepositoryImpl
import com.example.assigment.feature.product.domain.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepository: ProductRepositoryImpl) : ViewModel() {
    fun updateProductData() {
        viewModelScope.launch {
            productRepository.updateProductData()
        }
    }
    fun getProductData(): LiveData<List<Product>> {
      return  productRepository.getProductData()
    }

}