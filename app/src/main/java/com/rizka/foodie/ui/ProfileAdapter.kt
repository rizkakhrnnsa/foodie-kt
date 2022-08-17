package com.rizka.foodie.ui

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rizka.foodie.R
import com.rizka.foodie.data.Profile
import com.rizka.foodie.databinding.ItemProfileBinding
import java.lang.Exception

class ProfileAdapter : ListAdapter<Profile, ProfileAdapter.ViewHolder>(profileDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemProfileBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemProfileBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Profile) = with(binding) {
            imgIcon.apply {
                setBackgroundResource(R.drawable.bg_rounded_purple)
                setImageResource(data.profileImgIcon)
                setPadding(36)
            }
            tvTitle.text = data.profileTitle
            tvText.text = data.profileText

            when(adapterPosition) {
                0 -> {
                    tvText.apply {
                        setTextColor(ContextCompat.getColor(itemView.context, R.color.purple_700))
                        val email = "rizkakhrnnisa28@gmail.com"
                        setOnClickListener {
                            try {
                                val intentEmail = Intent(
                                    Intent.ACTION_SENDTO,
                                    Uri.fromParts("mailto", email, null)
                                ).apply {
                                    putExtra(Intent.EXTRA_EMAIL, email)
                                    putExtra(Intent.EXTRA_SUBJECT, "")
                                    putExtra(Intent.EXTRA_TEXT, "")
                                }
                                it.context.startActivity(Intent.createChooser(intentEmail, "Send email"))
                            } catch (e: Exception) {
                                Toast.makeText(it.context, "Silakan install aplikasi email terlebih dulu", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

                1 -> {
                    tvText.apply {
                        setTextColor(ContextCompat.getColor(itemView.context, R.color.purple_700))
                        val githubUrl = "https://github.com/rizkakhrnnsa"
                        setOnClickListener {
                            try {
                               val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
                                it.context.startActivity(Intent.createChooser(intent, "Open with"))
                            } catch (e: Exception) {
                                Toast.makeText(it.context, "Silakan install aplikasi peramban terlebih dulu", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }

                else -> tvText.setTextColor(ContextCompat.getColor(itemView.context, R.color.black))
            }
        }
    }

    companion object {
        val profileDiffCallback = object : DiffUtil.ItemCallback<Profile>() {
            override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean = oldItem.profileImgIcon == newItem.profileImgIcon
        }
    }
}