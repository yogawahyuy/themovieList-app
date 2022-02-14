package com.snystudio.themovielist.config

import com.snystudio.themovielist.model.DiscoverMovie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("discover/movie")
    fun getDiscoverMovie(@Query("api_key") api_key:String) : Call<List<DiscoverMovie>>
}