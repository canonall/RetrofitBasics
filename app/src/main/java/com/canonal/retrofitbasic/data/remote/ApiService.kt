package com.canonal.retrofitbasic.data.remote

import com.canonal.retrofitbasic.data.remote.response.PopularMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//don't give ApiService name normally
interface ApiService {

    //@GET's {placeholder} and @Path's value must be the same
    //For @Query's retrofit will put ? and add parameters
    //.../popular?api_key=4cf8d3500cdac0b2d68de5135e36bd72&language=en-US&page=1
    @GET("{v}/movie/popular")
    fun getPopularMovie(
        @Path("v") version: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: Int
        //if return type were array [] then, we would
        //use List<ResponseClass> but it is {} object
    ): Call<PopularMovieResponse>


}