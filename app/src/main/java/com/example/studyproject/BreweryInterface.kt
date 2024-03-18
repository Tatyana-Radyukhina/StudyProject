package com.example.studyproject

import BreweriesDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweryInterface {
    @GET("breweries")
    fun getBreweries(
        @Query("by_city") city: String,
        @Query("by_country") country: String,
        @Query("by_state") state: String

    ): Call<BreweriesDTO>
}