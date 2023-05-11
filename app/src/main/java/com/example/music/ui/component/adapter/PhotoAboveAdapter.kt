package com.example.music.ui.component.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.music.R
import com.example.music.data.dto.modelSong.Genres
import com.example.music.data.dto.response.ResponseGenres
import com.example.music.databinding.ItemLayoutGenresBinding
import com.example.music.databinding.ItemLayoutPhotoAboveBinding
import io.reactivex.annotations.NonNull
import kotlinx.coroutines.NonDisposableHandle.parent

    class PhotoAboveAdapter(var context: Context, var listPhotoAbove: MutableList<ResponseGenres>) : PagerAdapter() {

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val binding = ItemLayoutPhotoAboveBinding.inflate(LayoutInflater.from(context), container, false)

            val ads = listPhotoAbove[position]
            if (ads != null) {
                Glide.with(context).load(ads.data).into(binding.imgPhoto)
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