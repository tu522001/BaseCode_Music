package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponseVideo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by TruyenDev
 */

interface PrankCallService {
    @GET("prankcall/search")
    suspend fun fetchCallPrank(@Query("filter") filter: String, @Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Response<ResponseVideo>
}
