package com.afterwork.mymvplistapp.presenter

import android.util.Log
import com.afterwork.mymvplistapp.MainContracts
import com.afterwork.mymvplistapp.model.ImageApi
import com.afterwork.mymvplistapp.model.ImageApiModelImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainPresenter(val view: MainContracts.View) : MainContracts.Presenter{

    companion object{
        val TAG = "MainPresenter"
    }

    val model = ImageApiModelImpl(
        Retrofit.Builder()
            .baseUrl(ImageApi.API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImageApi::class.java))

    override fun loadItems() {
        model.getRecent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    Log.d(TAG, "Successed")
                    val pos = it.next.indexOf("last_pos=")
                    val nextPos = it.next.substring(pos + "last_pos=".length)
                    view.showItems(data, true, nextPos)
                    view.notifyAdapter()
                }
            }, {
                Log.d(TAG, "Failed: ${it.localizedMessage}")
            })
    }

    override fun moreItems(next: String) {
        model.getRecentMore(next)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.run {
                    Log.d(TAG, "Successed")
                    val pos = it.next.indexOf("last_pos=")
                    val nextPos = it.next.substring(pos + "last_pos=".length)
                    view.showItems(data, false, nextPos)
                    view.notifyAdapter()
                }
            }, {
                Log.d(TAG, "Failed: ${it.localizedMessage}")
            })
    }
}