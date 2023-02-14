package com.example.girls4girls.presentation.videoblog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.girls4girls.R
import com.example.girls4girls.databinding.FragmentVideoPlayerBinding
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment

class VideoPlayerFragment : YouTubePlayerFragment() {

    private lateinit var binding: FragmentVideoPlayerBinding
    var videoLink: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoPlayerBinding.inflate(inflater, container, false)

        val initializer = object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider?,
                youTubePlayer: YouTubePlayer?,
                wasRestored: Boolean
            ) {
                if (!wasRestored){
                    youTubePlayer?.loadVideo("02rqQyMKGiU")
                }
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider?,
                youTubePlayer: YouTubeInitializationResult?
            ) {
                TODO("Not yet implemented")
            }

        }

        binding.youtubePlayer.initialize(VideoblogFragment.YOUTUBE_API_KEY, initializer)
        return binding.root
    }




}