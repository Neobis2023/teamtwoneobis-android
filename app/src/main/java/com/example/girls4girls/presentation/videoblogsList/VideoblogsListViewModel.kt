package com.example.girls4girls.presentation.videoblogsList

import androidx.lifecycle.ViewModel
import com.example.girls4girls.data.VideoBlog

class VideoblogsListViewModel : ViewModel() {
    val videos = mutableListOf<VideoBlog>()

    val videoList = listOf<VideoBlog>(
        VideoBlog(0, "Video 1","Мария Борбона",123, "W4hTJybfU7s",60, "Sex", false, false),
        VideoBlog(1, "Video 2", "Jenna Ortega",923, "cTPaDbt_USA",60, "Future", true, false),
        VideoBlog(2, "Video 3", "Акылай Бещбармак",13, "H2AyDA8lnqo",60, "Food", true, true),
        VideoBlog(3, "Video 4", "Джордж Фем",1200, "B6DGB0oESzQ",60, "Education", false, true),
        VideoBlog(4, "Video 5", "Чучу Чарльз",113, "tKvEnZSoqas",60, "Periods", false, true),
    )
}