package com.munny.multiviewtypesample.sample

import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.databinding.ItemTextBinding

class SampleStringViewHolder(
    private val binding: ItemTextBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: SampleStringItem) {
        binding.text = item.str
    }
}