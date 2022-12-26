package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponsePrankCall
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by TruyenDev
 */

interface CallContactService {
    @GET("prankcall/search")
    suspend fun fetchCallContact(@Query("filter") filter: String, @Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Response<ResponsePrankCall>
}
