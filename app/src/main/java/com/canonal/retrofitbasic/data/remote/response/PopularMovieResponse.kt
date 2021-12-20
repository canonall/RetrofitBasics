package com.canonal.retrofitbasic.data.remote.response

import com.canonal.retrofitbasic.model.ResultModel

data class PopularMovieResponse(
    val page: Int,
    val results: List<ResultModel>,
    val total_results: Int,
    val total_pages: Int
) {
}