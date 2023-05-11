package com.example.music.ui.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.music.data.dto.modelSong.Genres
import com.example.music.data.dto.response.ResponseGenres
import com.example.music.databinding.ItemLayoutPhotoAboveBinding

class PhotoAboveAdapter(var context: Context, var listPhotoAbove: MutableList<String>) : PagerAdapter() {

        fun updateData(data: List<String>) {
            listPhotoAbove.clear()
            listPhotoAbove.addAll(data)
            notifyDataSetChanged()
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val binding = ItemLayoutPhotoAboveBinding.inflate(LayoutInflater.from(context), container, false)

            val image = listPhotoAbove[position]
            if (image != null) {
                Glide.with(context).load(image).into(binding.imgPhoto)
            }

            container.addView(binding.root)

            return binding.root
        }

        override fun getCount(): Int {
            return listPhotoAbove.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }