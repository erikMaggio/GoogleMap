package com.example.goooglemaps.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.goooglemaps.databinding.ActivityDetailsBinding
import com.example.goooglemaps.viewModel.DatesViewModel

class DetailsActivity : AppCompatActivity() {

    private val datesViewModel by viewModels<DatesViewModel>()
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datesViewModel.getShopForId(getExtraId())

        datesViewModel.detailsLiveData.observe(this) {
            binding.tvName.text = it?.name
            binding.tvDescription.text = it?.description
            binding.tvDirection.text = it?.direction
        }

    }

    private fun getExtraId(): Int {
        val intent = getIntent()
        val date = intent.getIntExtra("id", 0)
        return date
    }
}