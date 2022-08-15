package com.rizka.foodie.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.rizka.foodie.R
import com.rizka.foodie.data.Foodie
import com.rizka.foodie.databinding.ActivityDetailBinding
import java.lang.StringBuilder

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
        Glide.with(this@DetailActivity)
            .load(foodie.imageFoodie)
            .error(R.color.purple_700)
            .placeholder(R.color.purple_700)
            .into(imgFoodie)

        tvFoodieName.text = StringBuilder(foodie.nameFoodie).append(", ").append(foodie.countryOriginFoodie)
        tvFoodieDescription.text = foodie.descriptionFoodie
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