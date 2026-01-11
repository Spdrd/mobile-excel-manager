package com.example.remotemanager.singleton

import com.example.remotemanager.service.ExcelService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://nonblunderingly-micropaleontological-mabelle.ngrok-free.dev"

    val api: ExcelService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExcelService::class.java)
    }
}