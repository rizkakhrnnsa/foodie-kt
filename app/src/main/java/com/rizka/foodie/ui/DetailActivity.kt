package com.rizka.foodie.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.rizka.foodie.data.Foodie
import com.rizka.foodie.databinding.ActivityDetailBinding
import com.rizka.foodie.utils.Utils.loadImage

class DetailActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    private lateinit var foodie: Foodie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getParcelData()
        initActionBar()
        showDetail()
    }

    private fun getParcelData() {
        foodie = intent.getParcelableExtra<Foodie>(EXTRA_DATA) as Foodie
    }

    private fun initActionBar() {
        supportActionBar?.apply {
            title = ""
            elevation = 0f
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun showDetail() = with(binding) {
        imgFoodieBanner.loadImage(foodie.imageFoodieBanner)
        imgFoodie.loadImage(foodie.imageFoodie)
        tvFoodieName.text = foodie.nameFoodie
        tvFoodieDescription.text = foodie.descriptionFoodie
        tvFoodieIngredientsDesc.text = foodie.ingredientsFoodie
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}