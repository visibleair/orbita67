package com.example.orbita67.data.network

import com.example.orbita67.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/shows")
    suspend fun  getAllMovies() : Response<List<Movies>>
}