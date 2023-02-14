package com.example.girls4girls.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoBlog(
    val id: Long,
    val title: String,
    val speaker: String,
    val views: Int,
    val link: String,
    val duration: Int,
    val category: String,
    val watched: Boolean,
    val liked: Boolean
): Parcelable
