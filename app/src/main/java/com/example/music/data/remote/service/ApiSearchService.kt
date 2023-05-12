package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponseGenres
import com.example.music.data.dto.response.ResponseSong
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSearchService {
    @GET("filter")
    suspend fun fetchDataSearch(@Query("page") page :Int, @Query("limit") limit : Int, @Query("order") order : String, @Query("name") name : String) : Response<ResponseSong>
}