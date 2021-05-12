package com.munny.multiviewtypesample.sample.refactoring

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.databinding.ItemNumberBinding
import com.munny.multiviewtypesample.databinding.ItemTextBinding

sealed class SampleViewHolder<E: SampleItem>(
    binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {
    data class ImageViewHolder(
        private val binding: ItemNumberBinding
    ) : SampleViewHolder<SampleItem.ImageItem>(binding) {
        override fun bind(item: SampleItem.ImageItem) {
            binding.imageRes = item.imageRes
        }
    }

    data class NameViewHolder(
        private val binding: ItemTextBinding
    ) : SampleViewHolder<SampleItem.NameItem>(binding) {
        override fun bind(item: SampleItem.NameItem) {
            binding.text = item.name
        }
    }

    abstract fun bind(item: E)
}