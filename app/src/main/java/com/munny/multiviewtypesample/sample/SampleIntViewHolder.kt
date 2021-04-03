package com.munny.multiviewtypesample.sample

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.databinding.ItemNumberBinding

class SampleIntViewHolder(
    private val binding: ItemNumberBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SampleIntItem) {
        binding.number = item.i
    }
}
