package com.example.girls4girls.data

import android.os.Parcelable
import androidx.lifecycle.LiveData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class VideoBlog(
    val id: Long,
    val title: String,
    @SerializedName("createdAt")
    val date: String,
//    val category: String,
//    val speaker: Mentor,
    val description: String,
    @SerializedName("postViewCount")
    var views: Long = 0,
    var isWatched: Boolean = false,
    var isLiked: Boolean = false,
    @SerializedName("videoUrl")
    val link: String,
    val lecturerName: String,
    val lecturerInfo: String,
//    val lecturerImage: Lecturer = Lecturer("https://i.kym-cdn.com/photos/images/newsfeed/002/299/255/29d.jpeg"),
    val category: Category
): Parcelable
