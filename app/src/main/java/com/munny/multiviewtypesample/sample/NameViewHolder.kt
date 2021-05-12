package com.munny.multiviewtypesample.sample

import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.databinding.ItemTextBinding

class NameViewHolder(
    private val binding: ItemTextBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: NameItem) {
        binding.text = item.name
    }
}