package com.example.music.data.dto.frames

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * Created by TruyenDev on 29/10/2022.
 */
@JsonClass(generateAdapter = true)
@Parcelize
data class Frames(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "name_vi")
    val name_vi: String = "",
    @Json(name = "folder")
    val folder: String = "",
    @Json(name = "icon")
    val icon: String = "",
    @Json(name = "cover")
    val cover: String = "",
    @Json(name = "totalImage")
    val totalImage: Int = 0,
    @Json(name = "lock")
    val lock: Boolean = false,
    @Json(name = "openPackageName")
    val openPackageName: String = "",
    @Json(name = "defines")
    val defines: List<DefinesFrames> = listOf(),
) : Parcelable

{
    fun toImage() : List<Images> {
        val images = mutableListOf<Images>()

        defines.forEach { defineX ->
            for (i in defineX.start until defineX.end) {
                images.add(
                    Images(
                        url = "https://mystoragetm.s3.ap-southeast-1.amazonaws.com/Frames/ClassicFrames/" + folder + "/" + folder + "_frame_" + i+ ".png",
                        isEnd = i == defines.size - 1, folder = folder, fileName =  folder + "_frame_" + i+ ".png"
                    )
                )
            }
        }


        return images
    }
}