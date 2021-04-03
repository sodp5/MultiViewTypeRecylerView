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
            STRING_VIEW_TYPE -> SampleStringViewHolder(viewBind(parent, R.layout.item_text))
            INT_VIEW_TYPE -> SampleIntViewHolder(viewBind(parent, R.layout.item_number))
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
            is SampleIntViewHolder -> holder.bind(itemList[position] as SampleIntItem)
            is SampleStringViewHolder -> holder.bind(itemList[position] as SampleStringItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position]) {
            is SampleStringItem -> STRING_VIEW_TYPE
            is SampleIntItem -> INT_VIEW_TYPE
            else -> throw Exception("unknown type!!")
        }
    }

    companion object {
        const val STRING_VIEW_TYPE = 0
        const val INT_VIEW_TYPE = 1
    }
}