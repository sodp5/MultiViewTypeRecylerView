package com.munny.multiviewtypesample.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.R
import java.lang.Exception

class SampleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val itemList = ArrayList<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NAME_VIEW_TYPE -> NameViewHolder(viewBind(parent, R.layout.item_text))
            IMAGE_VIEW_TYPE -> ImageViewHolder(viewBind(parent, R.layout.item_number))
            else -> throw Exception("unknown type!!")
        }
    }

    private fun <T : ViewDataBinding> viewBind(parent: ViewGroup, layoutRes: Int): T {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> holder.bind(itemList[position] as ImageItem)
            is NameViewHolder -> holder.bind(itemList[position] as NameItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position]) {
            is NameItem -> NAME_VIEW_TYPE
            is ImageItem -> IMAGE_VIEW_TYPE
            else -> throw Exception("unknown type!!")
        }
    }

    companion object {
        const val NAME_VIEW_TYPE = 0
        const val IMAGE_VIEW_TYPE = 1
    }
}