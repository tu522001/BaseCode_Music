package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponseSound
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by TruyenDev
 */

interface SoundService {
    @GET("pranksound/search")
    suspend fun fetchSound(@Query("filter") filter: String, @Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int, @Query("sort") sort: String): Response<ResponseSound>
}
