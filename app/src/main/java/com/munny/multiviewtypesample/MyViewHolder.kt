package com.munny.multiviewtypesample

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.databinding.ItemImageBinding
import com.munny.multiviewtypesample.databinding.ItemNumberBinding
import com.munny.multiviewtypesample.databinding.ItemTextBinding

sealed class MyViewHolder<E : MyItem>(
    binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    data class TextViewHolder(
        val binding: ItemTextBinding
    ) : MyViewHolder<MyItem.TextItem>(binding) {
        override fun onBind(myItem: MyItem.TextItem) {
            binding.text = myItem.str
        }
    }

    data class NumberViewHolder(
        val binding: ItemNumberBinding
    ) : MyViewHolder<MyItem.NumberItem>(binding) {
        override fun onBind(myItem: MyItem.NumberItem) {
            binding.number = myItem.number
        }
    }

    data class AndroidImageViewHolder(
        val binding: ItemImageBinding
    ) : MyViewHolder<MyItem.AndroidImageItem>(binding) {
        override fun onBind(myItem: MyItem.AndroidImageItem) = Unit
    }


    abstract fun onBind(myItem: E)
}