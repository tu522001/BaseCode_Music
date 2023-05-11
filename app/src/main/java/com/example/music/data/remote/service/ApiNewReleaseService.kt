package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponseSong
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiNewReleaseService {
    @GET("filter")
    suspend fun fetchDataRelease(@Query("page") page :Int, @Query("limit") limit : Int, @Query("order") order : String) : Response<ResponseSong>
}