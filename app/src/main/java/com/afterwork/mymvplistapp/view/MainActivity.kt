package com.afterwork.mymvplistapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.afterwork.mymvplistapp.MainContracts
import com.afterwork.mymvplistapp.R
import com.afterwork.mymvplistapp.model.data.ImageContent
import com.afterwork.mymvplistapp.presenter.MainPresenter
import com.afterwork.mymvplistapp.view.listAdapter.ImageAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContracts.View {

    companion object{
        val TAG = "MainActivity"
    }

    val presenter : MainContracts.Presenter by lazy {
        MainPresenter(this)
    }

    var nextPos = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate() - loadItems()")
        list.adapter = ImageAdapter(this, {
            Log.d(TAG, "onItemClick(${it.title})")
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DETAIL, it)
            startActivity(intent)
        })

        list.setOnScrollChangeListener { view, i, i2, i3, i4 ->
            if (!view.canScrollVertically(1)) {
                Log.i(TAG, "End of list")
                presenter.moreItems(nextPos)
            }
        }

        swipe_refresh.isRefreshing = true
        presenter.loadItems()

        swipe_refresh.setOnRefreshListener {
            if(nextPos.isNullOrEmpty() == false) {
                Log.d(TAG, "setOnRefreshListener() - loadItems()")
                presenter.loadItems()
            }
        }
    }



    override fun showItems(contents: List<ImageContent>, cleared: Boolean, next: String) {
        Log.d(TAG, "showItems(itemCount: ${contents.size}, cleared: $cleared, next: $next)")

        (list.adapter as ImageAdapter).apply {
            if(cleared == true){
                imageList?.clear()

                swipe_refresh.isRefreshing = false
            }

            imageList?.addAll(contents)
            nextPos = next
        }
    }

    override fun notifyAdapter() {
        (list.adapter as ImageAdapter).apply {
            notifyDataSetChanged()
        }
    }
}
