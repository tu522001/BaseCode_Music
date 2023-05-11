package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponseSong
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiTopDownloadService {
    @GET("filter")
    suspend fun fetchDataTopDownload(@Query("page") page :Int, @Query("limit") limit : Int, @Query("order") order : String) : Response<ResponseSong>
}