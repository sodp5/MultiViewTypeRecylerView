package com.munny.multiviewtypesample.sample.refactoring

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.munny.multiviewtypesample.databinding.ItemNumberBinding
import com.munny.multiviewtypesample.databinding.ItemTextBinding

sealed class SampleViewHolder<E: SampleItem>(
    binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {
    data class SampleIntViewHolder(
        private val binding: ItemNumberBinding
    ) : SampleViewHolder<SampleItem.SampleIntItem>(binding) {
        override fun bind(item: SampleItem.SampleIntItem) {
            binding.number = item.i
        }
    }

    data class SampleStringViewHolder(
        private val binding: ItemTextBinding
    ) : SampleViewHolder<SampleItem.SampleStringItem>(binding) {
        override fun bind(item: SampleItem.SampleStringItem) {
            binding.text = item.str
        }
    }

    abstract fun bind(item: E)
}