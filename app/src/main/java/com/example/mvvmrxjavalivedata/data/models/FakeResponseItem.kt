package com.example.mvvmrxjavalivedata.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FakeResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
): Parcelable