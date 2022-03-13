package com.example.goooglemaps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getInt
import androidx.activity.viewModels
import com.example.goooglemaps.databinding.ActivityDetailsBinding
import com.example.goooglemaps.viewModel.DatesViewModel

class DetailsActivity : AppCompatActivity() {

    private val datesViewModel by viewModels<DatesViewModel>()
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}