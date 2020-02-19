package com.afterwork.mymvplistapp.model

import com.afterwork.mymvplistapp.model.data.ImageContents
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApi {
    companion object{
        val API_BASE_URL = "http://bgh.ogqcorp.com"
    }

    @GET("/api/v4/backgrounds/recent?format.json")
    fun getRecent(): Single<ImageContents>

    @GET("/api/v4/backgrounds/recent?format.json")
    fun getRecentMore(@Query("last_pos") last_pos: String): Single<ImageContents>

    @GET("/api/v4/backgrounds/popular/monthly?format.json")
    fun getMonthly(): Single<ImageContents>

    @GET("/api/v4/backgrounds/popular/monthly?format.json")
    fun getMonthlyMore(@Query("last_pos") last_pos: String): Single<ImageContents>

    @GET("/api/v4/backgrounds/popular/daily?format.json")
    fun getDaily(): Single<ImageContents>

    @GET("/api/v4/backgrounds/popular/daily?format.json")
    fun getDailyMore(@Query("last_pos") last_pos: String): Single<ImageContents>
}