package com.example.music.data.dto.response

import android.os.Parcelable
import com.example.music.data.dto.modelSong.Song
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseSong(
    @Json(name = "code")
    var code: Int = 0,
    @Json(name = "result")
    var data: List<Song> = listOf()
) : Parcelable