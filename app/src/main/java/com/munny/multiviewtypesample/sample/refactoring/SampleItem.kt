package com.munny.multiviewtypesample.sample.refactoring

sealed class SampleItem(private val sampleViewType: SampleViewType) {
    data class SampleStringItem(val str: String) : SampleItem(SampleViewType.STRING)
    data class SampleIntItem(val i: Int) : SampleItem(SampleViewType.INT)

    fun getViewType() = sampleViewType
}