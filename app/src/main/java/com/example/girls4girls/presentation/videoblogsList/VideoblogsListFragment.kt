package com.example.girls4girls.presentation.videoblogsList

import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.navigation.fragment.findNavController
import com.example.girls4girls.R
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.girls4girls.databinding.FragmentVideoblogsListBinding
import com.example.girls4girls.presentation.videoblog.VideoPlayerFragment
import com.example.girls4girls.presentation.videoblog.VideoblogFragment

class VideoblogsListFragment : Fragment(), SearchView.OnQueryTextListener {

    private val viewModel: VideoblogsListViewModel by viewModels()
    private lateinit var binding: FragmentVideoblogsListBinding
    private var watchedSelected = false

    private lateinit var videoAdapter: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoblogsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setSearchView()

        binding.categoryTxt.setOnClickListener {
            toggleDividers()
        }

        binding.watchedTxtBtn.setOnClickListener {
            toggleDividers()
        }

        binding.categoryButton.setOnClickListener { view ->
            showPopUpMenu(view)
        }

        videoAdapter.modifyList(viewModel.videoList)
    }

    private fun toggleDividers() {

        if (watchedSelected){
            videoAdapter.modifyList(viewModel.videoList)

            binding.dividerWatched.setBackgroundColor(ContextCompat.getColor(requireContext(),
                    R.color.mainColor
                )
            )
            binding.dividerAll.setBackgroundColor(ContextCompat.getColor(requireContext(),
                    R.color.black
                )
            )

        } else  {
            videoAdapter.modifyList(viewModel.videoList.filter { videoBlog ->
                videoBlog.watched
            })

            binding.dividerWatched.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.black))
            binding.dividerAll.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.mainColor ))
        }

        watchedSelected = !watchedSelected
    }


    private fun showPopUpMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)

        popupMenu.inflate(R.menu.category_popup_menu)

        popupMenu.setOnMenuItemClickListener { category ->
            when(category.itemId){
                R.id.all -> {
                    videoAdapter.modifyList(viewModel.videoList)
                    binding.categoryTxt.text = category.title
                    true
                }
                R.id.category1 -> {
                    videoAdapter.modifyList(viewModel.videoList.filter { videoBlog ->
                        videoBlog.category == category.title
                    })
                    binding.categoryTxt.text = category.title
                    true
                }
                R.id.category2 -> {
                    videoAdapter.modifyList(viewModel.videoList.filter { videoBlog ->
                        videoBlog.category == category.title
                    })
                    binding.categoryTxt.text = category.title
                    true
                }
                R.id.category3 -> {
                    videoAdapter.modifyList(viewModel.videoList.filter { videoBlog ->
                        videoBlog.category == category.title
                    })
                    binding.categoryTxt.text = category.title
                    true
                }
                R.id.category4 -> {
                    videoAdapter.modifyList(viewModel.videoList.filter { videoBlog ->
                        videoBlog.category == category.title
                    })
                    binding.categoryTxt.text = category.title
                    true
                }
                R.id.category5 -> {
                    videoAdapter.modifyList(viewModel.videoList.filter { videoBlog ->
                        videoBlog.category == category.title
                    })
                    binding.categoryTxt.text = category.title
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }


    private fun setSearchView() {
        binding.searchView.setOnQueryTextListener(this)
    }

    private fun setAdapter() {
        videoAdapter = VideoAdapter()
        binding.listVideoblogs.adapter = videoAdapter

        videoAdapter.onVideoClickListener = {
            val action = VideoblogsListFragmentDirections.actionVideoblogsListFragmentToVideoblogFragment(it)
            findNavController().navigate(action)
        }
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(query: String): Boolean {
        videoAdapter.filter(query)
        return true
    }

    companion object{
        val TAG = "Chura"
    }

}