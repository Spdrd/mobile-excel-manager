package com.example.remotemanager.service

import com.example.remotemanager.dto.ExcelLine
import retrofit2.http.Body
import retrofit2.http.POST


interface ExcelService {
    @POST("register")
    suspend fun sendLine(
        @Body line : ExcelLine
    ): ExcelLine
}