package com.example.picturealbum

import android.content.Context
import android.content.Intent
import android.graphics.Picture
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PicturesRVAdapter(var context: Context, var pictureList: List<Picture>): RecyclerView.Adapter<PictureViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_picture_view,parent,false)
        return PictureViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val currentPosts=pictureList.get(position)
        holder.age.text=currentPosts.Age.toString()
        holder.name.text=currentPosts.Name
        holder.pictureDescription.text=currentPosts.pictureDescription
        holder.cvDisplayPictures.setOnClickListener {
            val intent= Intent(context,picture_view_activity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return pictureList.size

    }
}
class PictureViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var age=itemView.findViewById<TextView>(R.id.tvAge)
    var name=itemView.findViewById<TextView>(R.id.tvName)
    var pictureDescription=itemView.findViewById<TextView>(R.id.tvpictureDescription)

}

