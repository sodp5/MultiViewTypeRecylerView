package com.munny.multiviewtypesample.sample.refactoring

import androidx.annotation.DrawableRes

sealed class SampleItem(private val sampleViewType: SampleViewType) {
    data class NameItem(val name: String) : SampleItem(SampleViewType.NAME)
    data class ImageItem(@DrawableRes val imageRes: Int) : SampleItem(SampleViewType.IMAGE)

    fun getViewType() = sampleViewType
}