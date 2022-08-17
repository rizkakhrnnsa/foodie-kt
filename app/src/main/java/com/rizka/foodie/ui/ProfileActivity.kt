package com.rizka.foodie.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.rizka.foodie.R
import com.rizka.foodie.data.Profile
import com.rizka.foodie.data.ProfileData
import com.rizka.foodie.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityProfileBinding.inflate(layoutInflater)
    }

    private var profileAdapter: ProfileAdapter? = null
    private var profileList: ArrayList<Profile> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initToolbar()
        initData()
        initView()
        showData()
    }

    private fun initToolbar() {
        supportActionBar?.apply {
            elevation = 0f
            title = ""
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun initData() {
        profileList.addAll(ProfileData.generateProfileData())
    }

    private fun initView() = with(binding) {
        profileAdapter = ProfileAdapter()
        rvProfile.apply {
            layoutManager = LinearLayoutManager(this@ProfileActivity)
            setHasFixedSize(true)
            adapter = profileAdapter
        }
    }

    private fun showData() = with(binding){
        imgProfile.setImageDrawable(ContextCompat.getDrawable(this@ProfileActivity, R.drawable.rizka))
        imgProfileBanner.setImageDrawable(ContextCompat.getDrawable(this@ProfileActivity, R.drawable.cat))
        profileAdapter?.submitList(profileList)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        profileAdapter = null
    }
}