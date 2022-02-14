package com.snystudio.themovielist.config

class MovieRepo(private val apiInterface: ApiInterface) {
    private val api_key="419b81ff6596ca606be669657bc644b3"
    fun getMovie()=apiInterface.getDiscoverMovie(api_key)
}