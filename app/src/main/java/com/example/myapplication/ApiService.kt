package com.example.myapplication

import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<product>
}