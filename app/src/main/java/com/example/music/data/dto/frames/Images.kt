package com.example.music.data.dto.frames

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 *  Create by TruongIT
 */

@JsonClass(generateAdapter = true)
@Parcelize
data class Images(
    @Json(name = "url")
    var url: String = "",
    @Json(name = "isFirst")
    var isFirst: Boolean = false,
    @Json(name = "isEnd")
    var isEnd: Boolean = false,
    @Json(name = "isSpace")
    var isSpace: Boolean = false,
    @Json(name = "folder")
    var folder: String = "",
    @Json(name = "downloaded")
    var downloaded: Boolean = false,
    @Json(name = "fileName")
    var fileName : String = ""
) : Parcelable