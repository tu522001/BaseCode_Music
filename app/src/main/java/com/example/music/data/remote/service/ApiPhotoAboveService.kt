package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponseGenres
import retrofit2.Response
import retrofit2.http.GET

interface ApiPhotoAboveService {
    @GET("genres")
    suspend fun fetchDataPhotoAbove() : Response<ResponseGenres>
}