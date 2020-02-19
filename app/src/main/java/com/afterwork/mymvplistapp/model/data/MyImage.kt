package com.afterwork.mymvplistapp.model.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class MyImage(@SerializedName("url") val url: String,
                   @SerializedName("type") val  type: String): Parcelable{

    constructor(parcelIn: Parcel): this(
        parcelIn.readString()!!,
        parcelIn.readString()!!
    )

    override fun writeToParcel(parcelOut: Parcel, flags: Int) {
        parcelOut.writeString(url)
        parcelOut.writeString(type)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<MyImage> {
        override fun createFromParcel(parcel: Parcel): MyImage {
            return MyImage(parcel)
        }

        override fun newArray(size: Int): Array<MyImage?> {
            return arrayOfNulls(size)
        }

        val THUMBNAIL = "thumbnail"
        val PERVIEW = "preview"
        val IMAGE = "image"
    }
}