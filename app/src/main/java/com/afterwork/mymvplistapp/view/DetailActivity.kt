package com.afterwork.mymvplistapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afterwork.mymvplistapp.R
import com.afterwork.mymvplistapp.model.data.ImageContent
import com.afterwork.mymvplistapp.model.data.MyImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(){
    companion object{
        val TAG = "DetailActivity"
        val DETAIL = "detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initInfo(intent.getParcelableExtra(DETAIL))
    }

    fun initInfo(content: ImageContent){

        for(img in content.images){
            if(img.type.equals(MyImage.PERVIEW)){
                iv_image.setImageURI(img.url)
                break
            }
        }

        tv_counts.text = "Likes: ${content.likes_count}, Downloads: ${content.downloads_count}, Views: ${content.views_count}"
        tv_title.text = content.title
        tv_desc.text = content.description
    }
}