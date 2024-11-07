package com.example.assigment.feature.home.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assigment.R
import com.example.assigment.databinding.FragmentHomeBinding
import com.example.assigment.feature.home.ui.adapter.BrandAdapter
import com.example.assigment.feature.home.ui.adapter.CategoryAdapter
import com.example.assigment.feature.home.ui.adapter.GroceryAdapter
import com.example.assigment.feature.home.ui.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel by viewModels<HomeViewModel>()
    private val binding:FragmentHomeBinding by lazy { DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home,null,false) }

    val categoryAdapter by lazy { CategoryAdapter() }
    val brandAdapter by lazy { BrandAdapter() }
    val groceryAdapter by lazy { GroceryAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel.updateHomeData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter()
        viewModel.getBrandList().observe(viewLifecycleOwner) {
            brandAdapter.submitList(it)
            Log.e("onViewCreated: ", it.toString())
        }
        viewModel.getSlider().observe(viewLifecycleOwner){
           val adapter =  ViewPagerAdapter(imageUrls = it)
           binding.viewPager.adapter = adapter
            Log.e( "onViewCreated:Silder ",it.toString() )
        }
        viewModel.getCategory().observe(viewLifecycleOwner){
            categoryAdapter.submitList(it)
            Log.e( "onViewCreated:Category ",it.toString() )
        }
        viewModel.getGrocery().observe(viewLifecycleOwner){
            groceryAdapter.submitList(it)
            Log.e( "onViewCreated:Grocery ",it.toString() )
        }
    }

    fun adapter(){
        binding .apply {
            rvCategory.adapter = categoryAdapter
            rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            rvBrand.adapter = brandAdapter
            rvBrand.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            rvGrocery.adapter = groceryAdapter
            rvGrocery.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

    }
}