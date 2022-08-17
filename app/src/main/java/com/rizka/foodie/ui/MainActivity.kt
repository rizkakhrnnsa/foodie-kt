package com.rizka.foodie.ui

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizka.foodie.R
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
        foodieListAdapter?.setData(foodieList)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search).actionView as SearchView
        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            queryHint = resources.getString(R.string.search)
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    when {
                        query.isNotEmpty() -> {
                            foodieListAdapter?.filter?.filter(query)
                            clearFocus()
                        }
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean = false
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_profile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        foodieListAdapter = null
    }
}