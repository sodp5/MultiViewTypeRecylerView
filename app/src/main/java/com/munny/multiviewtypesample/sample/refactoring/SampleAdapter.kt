package com.munny.multiviewtypesample.sample.refactoring

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SampleAdapter : RecyclerView.Adapter<SampleViewHolder<SampleItem>>() {
    private val itemList = ArrayList<SampleItem>()
    private val sampleViewHolderFactory = SampleViewHolderFactory()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder<SampleItem> {
        return sampleViewHolderFactory.getViewHolder(parent, SampleViewType.values()[viewType])
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: SampleViewHolder<SampleItem>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return itemList[position].getViewType().ordinal
    }
}