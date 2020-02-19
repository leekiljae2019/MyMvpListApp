package com.afterwork.mymvplistapp.model.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class ImageContent(@SerializedName("id") val id: Int,
                        @SerializedName("title") val title: String,
                        @SerializedName("description") val description: String,
                        @SerializedName("views_count") val views_count: Int,
                        @SerializedName("likes_count") val likes_count: Int,
                        @SerializedName("downloads_count") val downloads_count: Int,
                        @SerializedName("images") val images: List<MyImage>) : Parcelable {

    constructor(parcelIn: Parcel): this(
        parcelIn.readInt()!!,
        parcelIn.readString()!!,
        parcelIn.readString()!!,
        parcelIn.readInt()!!,
        parcelIn.readInt()!!,
        parcelIn.readInt()!!,
        arrayListOf<MyImage>().apply {
            parcelIn.readTypedList(this, MyImage.CREATOR)
        }
    )

    override fun writeToParcel(parcelOut: Parcel, flags: Int) {
        parcelOut.writeInt(id)
        parcelOut.writeString(title?:"untitle")
        parcelOut.writeString(description?:"none")
        parcelOut.writeInt(views_count)
        parcelOut.writeInt(likes_count)
        parcelOut.writeInt(downloads_count)
        parcelOut.writeTypedList(images)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ImageContent> {
        override fun createFromParcel(parcel: Parcel): ImageContent {
            return ImageContent(parcel)
        }

        override fun newArray(size: Int): Array<ImageContent?> {
            return arrayOfNulls(size)
        }
    }
}