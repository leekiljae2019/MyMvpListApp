package com.afterwork.mymvplistapp.view.listAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afterwork.mymvplistapp.R
import com.afterwork.mymvplistapp.model.data.ImageContent
import com.afterwork.mymvplistapp.model.data.MyImage

class ImageAdapter(val context: Context, val listener: (ImageContent)->Unit) : RecyclerView.Adapter<ImageViewHolder>() {
    var imageList: ArrayList<ImageContent> = ArrayList()

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = imageList.get(position)

        var url = ""
        for(img in item?.images!!){
            if(img.type == MyImage.THUMBNAIL){
                url = img.url
            }
        }

        holder.imageView.setImageURI(url)
        holder.itemView.setOnClickListener {
            listener.invoke(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ImageViewHolder(
        LayoutInflater.from(context).inflate(
            R.layout.item_image,
            parent,
            false
        )
    )

    override fun getItemCount() = imageList.size

}