package com.example.music.data.dto.response

import android.os.Parcelable
import com.example.music.data.dto.modelSong.Genres
import com.example.music.data.dto.modelSong.Song
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ResponseGenres(
    @Json(name = "code")
    var code: Int = 0,
    @Json(name = "ads")
    var ads : List<String> = listOf(),
    @Json(name = "genres")
    var data: List<Genres> = listOf()
) : Parcelable