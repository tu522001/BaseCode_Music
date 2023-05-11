package com.example.music.data.remote.service

import com.example.music.data.dto.recipes.RecipesItem
import com.example.music.data.dto.response.ResponseGenres
import com.example.music.data.dto.response.ResponseSong
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGenresService {
    @GET("genres")
    suspend fun fetchDataGenres() : Response<ResponseGenres>
}