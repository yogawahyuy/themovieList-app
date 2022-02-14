package com.snystudio.themovielist.model

data class DiscoverMovie(
    val adult:Boolean,
    val backdrop_path:String,
    val genre_ids:ArrayList<Int>,
    val id:Long,
    val original_language:String,
    val original_title:String,
    val overview:String,
    val popularity:Float,
    val poster_path:String,
    val release_date:String,
    val title:String,
    val video:Boolean,
    val vote_average:Float,
    val vote_count:Long
)
