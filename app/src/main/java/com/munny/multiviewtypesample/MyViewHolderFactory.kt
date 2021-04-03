package com.munny.multiviewtypesample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

class MyViewHolderFactory {
    @Suppress("UNCHECKED_CAST")
    fun getViewHolder(parent: ViewGroup, viewType: MyViewType): MyViewHolder<MyItem> {
        return when (viewType) {
            MyViewType.TEXT -> MyViewHolder.TextViewHolder(viewBind(parent, R.layout.item_text))
            MyViewType.NUMBER -> MyViewHolder.NumberViewHolder(
                viewBind(
                    parent,
                    R.layout.item_number
                )
            )
            MyViewType.ANDROID_IMAGE ->
                MyViewHolder.AndroidImageViewHolder(viewBind(parent, R.layout.item_image))
        } as MyViewHolder<MyItem>
    }

    private fun <T : ViewDataBinding> viewBind(parent: ViewGroup, layoutRes: Int): T {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    }
}