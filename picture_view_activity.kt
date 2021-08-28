package com.example.picturealbum

import android.graphics.Picture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.jar.Attributes

class picture_view_activity : AppCompatActivity() {
    lateinit var binding:ActivityViewBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root )
        getPost()


        fun castViews(){

        }

    }

    fun getPost(){
        var retrofit=ApiClient.buildService(ApiInterface::class.java)
        var request=retrofit.getPostById(postId)
        request.enqueue(object : Callback<Picture> {
            override fun onResponse(call: Call<Picture>, response: Response<Picture>) {
                binding.tvName.text=response.body()?.title
                binding.tvAge.text=response.body()?.age


            }

            override fun onFailure(call: Call<Picture>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()


            }
        })

    }}