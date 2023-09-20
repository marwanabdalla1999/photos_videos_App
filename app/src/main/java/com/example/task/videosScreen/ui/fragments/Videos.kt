package com.example.task.videosScreen.ui.fragments

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.task.databinding.FragmentVideosBinding
import com.example.task.permissions.CheckForMediaPermissions
import com.example.task.permissions.IPermissions
import com.example.task.videosScreen.adapters.VideosAdapter
import com.example.task.videosScreen.viewModels.VideosViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Videos : Fragment() {
    @Inject
    lateinit var adapter: VideosAdapter
    private val videosViewModel: VideosViewModel by viewModels()
    private lateinit var binding: FragmentVideosBinding
    private lateinit var permission: IPermissions

    private val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->

            if (permissions[Manifest.permission.READ_EXTERNAL_STORAGE] == true || permissions[Manifest.permission.READ_MEDIA_VIDEO] == true) {
                getVideos()
            } else {

                Toast.makeText(requireActivity(), "No Permissions", Toast.LENGTH_SHORT).show()

            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = FragmentVideosBinding.inflate(layoutInflater)

        return binding.root
    }


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        checkPermission()

        observeChanges()

    }

    private fun observeChanges() {
        videosViewModel.observeVideos().observe(viewLifecycleOwner) { data ->
            if (data != null) {

                adapter.setData(data)

            }
        }

    }


    private fun init() {

        permission = CheckForMediaPermissions(requireActivity())
        binding.videosData = adapter
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun checkPermission() {
        requestMultiplePermissions.launch(
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_MEDIA_VIDEO
            )
        )
        if (permission.checkForPermission()) {
            getVideos()
        }

    }

    private fun getVideos() {
        lifecycleScope.launch {
            videosViewModel.getVideos()

        }


    }
}