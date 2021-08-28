package com.example.picturealbum

import android.graphics.Picture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvPicture: RecyclerView
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    fetchPosts()
}
fun fetchPosts(){
    var retrofit=ApiClient.buildServices(ApiInterface::class.java)
    var request=retrofit.getPosts()
    request.enqueue(object : Callback<List<Picture>> {
        override fun onResponse(call: Call<List<Picture>>, response: Response<List<Picture>>) {
            if (response.isSuccessful){
                var pictureList=response.body()!!

                rvPicture=findViewById(R.id.rvPicture)
                var myAdapter=PicturesRVAdapter(baseContext, pictureList  )
                rvPicture.adapter=myAdapter
                rvPicture.layoutManager= LinearLayoutManager(baseContext)
                rvPicture.adapter=myAdapter
                Toast.makeText(baseContext,"${pictureList.size}posts", Toast.LENGTH_LONG).show()
                var pictureDate= mutableListOf<Picture>()
                for (x in 1..pictureList.size){
                    pictureDate.add(Picture())
                }
            }
        }

        override fun onFailure(call: Call<List<Picture>>, t: Throwable) {
            Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
        }
    })

}
}