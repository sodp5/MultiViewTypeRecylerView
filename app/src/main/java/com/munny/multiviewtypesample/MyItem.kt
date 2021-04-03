package com.munny.multiviewtypesample

sealed class MyItem(private val viewType: MyViewType) {
    data class TextItem(val str: String) : MyItem(MyViewType.TEXT)
    data class NumberItem(val number: Int) : MyItem(MyViewType.NUMBER)
    object AndroidImageItem : MyItem(MyViewType.ANDROID_IMAGE)

    fun getViewType() = viewType
}