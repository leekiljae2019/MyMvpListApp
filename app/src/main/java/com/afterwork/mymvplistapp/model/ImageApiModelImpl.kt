package com.afterwork.mymvplistapp.model

import com.afterwork.mymvplistapp.model.data.ImageContents
import io.reactivex.Single

class ImageApiModelImpl(private val service: ImageApi): ImageApiModel {
    override fun getRecent(): Single<ImageContents> {
        return service.getRecent()
    }

    override fun getRecentMore(last_pos: String): Single<ImageContents> {
        return service.getRecentMore(last_pos)
    }

    override fun getMonthly(): Single<ImageContents> {
        return service.getMonthly()
    }

    override fun getMonthlyMore(last_pos: String): Single<ImageContents> {
        return service.getMonthlyMore(last_pos)
    }

    override fun getDaily(): Single<ImageContents> {
        return service.getDaily()
    }

    override fun getDailyMore(last_pos: String): Single<ImageContents> {
        return service.getDailyMore(last_pos)
    }
}