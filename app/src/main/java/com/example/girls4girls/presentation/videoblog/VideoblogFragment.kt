package com.example.girls4girls.presentation.videoblog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.girls4girls.R
import com.example.girls4girls.databinding.FragmentVideoblogBinding
import com.example.girls4girls.presentation.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.youtube.player.*

class VideoblogFragment : Fragment() {

    private lateinit var viewModel: VideoblogViewModel
    private lateinit var binding: FragmentVideoblogBinding
    private lateinit var initializer: YouTubePlayer.OnInitializedListener
    private lateinit var player: YouTubePlayerView

    private lateinit var youtubePlayerFragment: YouTubePlayerSupportFragment

//    val bundle = this.arguments

    private val args by navArgs<VideoblogFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoblogBinding.inflate(inflater, container, false)

        youtubePlayerFragment = YouTubePlayerSupportFragment.newInstance()

        childFragmentManager.beginTransaction()
            .replace(R.id.youtube_player, youtubePlayerFragment)
            .commit()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




//            binding.videoTitleTxt.text = bundle.getString("LINK")
//        binding.videoSpeakerTxt.text = args.currentVideoBlog.speaker
//        binding.videoViewsTxt.text = args.currentVideoBlog.views.toString()

    }



}