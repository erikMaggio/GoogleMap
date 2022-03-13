package com.example.goooglemaps.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goooglemaps.R
import com.example.goooglemaps.databinding.GoogleMapActivityMainBinding
import com.example.goooglemaps.model.date.Shop
import com.example.goooglemaps.ui.adapter.ShopAdapter
import com.example.goooglemaps.viewModel.DatesViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions

class GoogleMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private val datesViewModel by viewModels<DatesViewModel>()
    private lateinit var map: GoogleMap
    private lateinit var binding: GoogleMapActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GoogleMapActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createFragment()
        datesViewModel.getList()

        datesViewModel.dateLiveData.observe(this) {
            initRecyclerView(it)
            viewOnMap(it)
        }

    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentMap)
                    as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!

    }

    private fun initRecyclerView(list: List<Shop>) {
        val adapter = ShopAdapter(list)

        adapter.setOnClickListener(object : ShopAdapter.OnClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(Intent(this@GoogleMapActivity, DetailsActivity::class.java))
                intent.putExtra("id", list[position].id)
                startActivity(intent)
            }
        })

        binding.rvList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvList.adapter = adapter
    }

    private fun viewOnMap(list: List<Shop>) {
        for (i in list) {
            val marker = MarkerOptions().position(i.location).title(i.name)
            map.addMarker(marker)

        }
    }
}