package com.canonal.retrofitbasic.model

data class ResultModel(
    val adult: Boolean,
    val backdrop_path:String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val popularity: Double,

)