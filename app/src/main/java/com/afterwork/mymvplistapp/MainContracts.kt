package com.afterwork.mymvplistapp

import com.afterwork.mymvplistapp.model.data.ImageContent

interface MainContracts {

    interface View{
        fun showItems(contents: List<ImageContent>, cleared: Boolean, next: String)
        fun notifyAdapter()
    }

    interface Presenter{
        fun loadItems()
        fun moreItems(next: String)
    }
}