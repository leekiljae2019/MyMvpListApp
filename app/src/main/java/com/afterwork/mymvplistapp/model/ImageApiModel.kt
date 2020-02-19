package com.afterwork.mymvplistapp.model

import com.afterwork.mymvplistapp.model.data.ImageContents
import io.reactivex.Single

interface ImageApiModel {
    fun getRecent(): Single<ImageContents>
    fun getRecentMore(last_pos: String): Single<ImageContents>
    fun getMonthly(): Single<ImageContents>
    fun getMonthlyMore(last_pos: String): Single<ImageContents>
    fun getDaily(): Single<ImageContents>
    fun getDailyMore(last_pos: String): Single<ImageContents>
}