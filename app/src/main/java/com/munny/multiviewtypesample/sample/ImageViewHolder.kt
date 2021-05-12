package com.munny.multiviewtypesample.sample

import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.databinding.ItemNumberBinding

class ImageViewHolder(
    private val binding: ItemNumberBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ImageItem) {
        binding.imageRes = item.imageRes
    }
}
