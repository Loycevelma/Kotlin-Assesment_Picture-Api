package com.example.picturealbum

import android.graphics.Picture
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {

@GET(" http://13.244.243.129/photos")
fun getPicture(): Call<List<Picture>>

@POST("pictures/{id}")
fun getPictureById(@Path("id")postId:Int): Call<Picture>

}

