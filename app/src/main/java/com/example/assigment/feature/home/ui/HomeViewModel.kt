package com.example.assigment.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assigment.feature.home.data.repository_impl.HomeRepositoryImpl

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepositoryImpl: HomeRepositoryImpl) :
    ViewModel() {

    fun updateHomeData() {
        viewModelScope.launch {
            homeRepositoryImpl.updateHomeData()
        }
    }

    fun getBrandList() = homeRepositoryImpl.getBrandData()
    fun getSlider() = homeRepositoryImpl.getSliderData()
    fun getCategory() = homeRepositoryImpl.getCategoryData()
    fun getGrocery() = homeRepositoryImpl.getGroceryData()


}
