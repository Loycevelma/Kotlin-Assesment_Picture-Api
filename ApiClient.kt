package com.example.picturealbum

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    object ApiClient {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun <T> buildService(apiInterface: Class<T>): T {
            return retrofit.create(apiInterface)
        }

    }
}