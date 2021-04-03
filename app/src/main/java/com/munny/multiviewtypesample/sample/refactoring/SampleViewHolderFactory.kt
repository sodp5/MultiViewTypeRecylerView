package com.munny.multiviewtypesample.sample.refactoring

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.munny.multiviewtypesample.R

class SampleViewHolderFactory {
    @Suppress("UNCHECKED_CAST")
    fun getViewHolder(parent: ViewGroup, viewType: SampleViewType): SampleViewHolder<SampleItem> {
        return when (viewType) {
            SampleViewType.STRING ->
                SampleViewHolder.SampleStringViewHolder(viewBind(parent, R.layout.item_text))
            SampleViewType.INT ->
                SampleViewHolder.SampleIntViewHolder(viewBind(parent, R.layout.item_number))
        } as SampleViewHolder<SampleItem>
    }

    private fun <T : ViewDataBinding> viewBind(parent: ViewGroup, layoutRes: Int): T {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            layoutRes,
            parent,
            false
        )
    }
}