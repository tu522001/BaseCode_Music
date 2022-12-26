package com.example.music.data.remote.service

import com.example.music.data.dto.response.ResponsePrankRecordItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by TruyenDev
 */

interface PrankItemGifService {
    @GET("prankrecordgif/search")
    suspend fun fetchItemGif(@Query("filter") filter: String, @Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int, @Query("sort") sort: String): Response<ResponsePrankRecordItem>
}
