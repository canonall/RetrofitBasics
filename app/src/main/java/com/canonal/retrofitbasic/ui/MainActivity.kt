package com.canonal.retrofitbasic.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.canonal.retrofitbasic.R
import com.canonal.retrofitbasic.data.remote.ApiService
import com.canonal.retrofitbasic.data.remote.RetrofitClient
import com.canonal.retrofitbasic.data.remote.response.PopularMovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = RetrofitClient.getRetrofitInstance()
        val apiService = retrofit.create(ApiService::class.java)
        val callPopularMovie = apiService.getPopularMovie(
            3,
            "4cf8d3500cdac0b2d68de5135e36bd72",
            "en-US",
            1
        )

        callPopularMovie.enqueue(object : Callback<PopularMovieResponse> {
            override fun onResponse(
                call: Call<PopularMovieResponse>,
                response: Response<PopularMovieResponse>
            ) {
                val popularMovieResponse = response.body() as PopularMovieResponse
                Log.e(
                    "RETROFIT", "onResponse: {${
                        popularMovieResponse
                            .results[0]
                            .original_title
                    }}"
                )

            }

            override fun onFailure(call: Call<PopularMovieResponse>, t: Throwable) {
                Log.e("RETROFIT", "onFailure: FAIL ")
            }

        }
        )


    }
}