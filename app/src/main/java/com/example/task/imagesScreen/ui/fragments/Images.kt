package com.example.task.imagesScreen.ui.fragments

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
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
import com.example.task.databinding.FragmentImagesBinding
import com.example.task.imagesScreen.viewModels.ImagesViewModel
import com.example.task.imagesScreen.adapters.ImagesAdapter
import com.example.task.permissions.CheckForMediaPermissions
import com.example.task.permissions.IPermissions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class Images : Fragment() {

    @Inject
    lateinit var adapter: ImagesAdapter

    private val imagesViewModel: ImagesViewModel by viewModels()

    private lateinit var binding: FragmentImagesBinding

    private lateinit var permission: IPermissions

    private val requestMultiplePermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->

            if (permissions[READ_EXTERNAL_STORAGE] == true || permissions[READ_MEDIA_IMAGES] == true) {

                getImages()

            } else {

                Toast.makeText(requireActivity(), "No Permissions", Toast.LENGTH_SHORT).show()

            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentImagesBinding.inflate(layoutInflater)
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
        imagesViewModel.observeImages().observe(viewLifecycleOwner) { data ->
            if (data != null) {

                adapter.setData(data)
            }
        }
    }


    private fun init() {

        permission = CheckForMediaPermissions(requireActivity())
        binding.imagesData=adapter
    }


    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun checkPermission() {

        requestMultiplePermissions.launch(arrayOf(READ_EXTERNAL_STORAGE, READ_MEDIA_IMAGES))

        if (permission.checkForPermission()) {
            getImages()
        }
    }


    private fun getImages() {

            imagesViewModel.getImages()



    }


}

