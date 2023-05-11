package com.example.music.data.remote

import com.example.music.data.Resource
import com.example.music.data.dto.frames.DataFrames
import com.example.music.data.dto.modelSong.Genres
import com.example.music.data.dto.recipes.Recipes
import com.example.music.data.dto.response.*

/**
 * Created by TruyenIT
 */

internal interface RemoteDataSource {
    suspend fun requestRecipes(): Resource<Recipes>

    suspend fun requestSoundCategory(filter: String): Resource<ResponseCategorySound>
    suspend fun requestSound(filter: String): Resource<ResponseSound>
    suspend fun requestVideo(filter: String): Resource<ResponseVideo>
    suspend fun requestCall(filter: String): Resource<ResponsePrankCall>
    suspend fun requestCategoryGif(filter: String): Resource<ResponsePrankRecordFolder>
    suspend fun requestCategoryVideo(filter: String): Resource<ResponsePrankRecordFolder>
    suspend fun requestItemGif(filter: String): Resource<ResponsePrankRecordItem>
    suspend fun requestItemVideo(filter: String): Resource<ResponsePrankRecordItem>
    suspend fun requestFrames(): Resource<DataFrames>
    suspend fun requestDataFramesImage(): Resource<DataFrames>

    suspend fun requestDataNewReleaseSong(page: Int, limit: Int, order: String): Resource<ResponseSong>
    suspend fun requestDataTopTrendingSong(page: Int, limit: Int, order: String): Resource<ResponseSong>
    suspend fun requestDataTopDownLoadSong(page: Int, limit: Int, order: String): Resource<ResponseSong>
    suspend fun requestDataGenres(): Resource<ResponseGenres>
    suspend fun requestDataPhotoAbove(): Resource<ResponseGenres>

}
