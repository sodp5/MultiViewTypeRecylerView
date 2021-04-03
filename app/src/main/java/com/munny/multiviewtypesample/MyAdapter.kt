package com.munny.multiviewtypesample

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyViewHolder<MyItem>>() {
    private var itemList = listOf<MyItem>()
    private val myViewHolderFactory = MyViewHolderFactory()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder<MyItem> {
        return myViewHolderFactory.getViewHolder(parent, MyViewType.values()[viewType])
    }

    override fun onBindViewHolder(holder: MyViewHolder<MyItem>, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getViewType().ordinal
    }

    override fun getItemCount() = itemList.size

    fun setItemList(itemList: List<MyItem>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}