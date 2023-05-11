package com.example.music.data.dto.modelSong

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
class Genres(
    val name : String,
    val thumbnail : String
) : Parcelable