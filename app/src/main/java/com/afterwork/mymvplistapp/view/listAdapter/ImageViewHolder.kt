package com.afterwork.mymvplistapp.view.listAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.afterwork.mymvplistapp.R
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.item_image.view.*

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageView by lazy {
        itemView.findViewById(R.id.iv_image) as SimpleDraweeView
    }


}