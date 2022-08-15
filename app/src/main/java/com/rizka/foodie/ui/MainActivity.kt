package com.rizka.foodie.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizka.foodie.data.Foodie
import com.rizka.foodie.data.FoodieData
import com.rizka.foodie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private var foodieListAdapter: FoodieListAdapter? = null
    private var foodieList: ArrayList<Foodie> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initData()
        initView()
        showData()
    }

    private fun initData() {
        foodieList.addAll(FoodieData.foodieList)
    }

    private fun initView() = with(binding){
        foodieListAdapter = FoodieListAdapter()
        rvFoodList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = foodieListAdapter
        }
    }

    private fun showData() {
        foodieListAdapter?.submitList(foodieList)
    }

    override fun onDestroy() {
        super.onDestroy()
        foodieListAdapter = null
    }
}