package com.example.task.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.task.R
import com.example.task.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Home : AppCompatActivity() {

   private lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navGraph()


    }

    private fun navGraph() {
        val navController =findNavController(R.id.container)
        val navView: BottomNavigationView = binding.bottomNavigationView
        navView.setupWithNavController(navController)


    }


}