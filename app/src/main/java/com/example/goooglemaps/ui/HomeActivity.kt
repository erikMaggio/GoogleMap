package com.example.goooglemaps.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goooglemaps.databinding.ActivityHomeBinding
import com.example.goooglemaps.model.date.Shop
import com.example.goooglemaps.ui.adapter.ShopAdapter
import com.example.goooglemaps.viewModel.DatesViewModel
import com.google.android.gms.maps.model.MarkerOptions

class HomeActivity : AppCompatActivity() {

    private val datesViewModel by viewModels<DatesViewModel>()
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datesViewModel.getList()

        datesViewModel.dateLiveData.observe(this) {
            initRecyclerView(it)
            viewOnMap(it)

        }
        binding.tvViewOnMap.setOnClickListener {
            startActivity(Intent(this, GoogleMapActivity::class.java))
        }
    }

    private fun initRecyclerView(list: List<Shop>) {
        val adapter = ShopAdapter(list)

        adapter.setOnClickListener(object : ShopAdapter.OnClickListener {
            override fun onItemClick(position: Int) {

                val bundle = Bundle()
                bundle.putInt("id", list[position].id)
                startActivity(Intent(this@HomeActivity,DetailsActivity::class.java
                ),bundle)
            }
        })

        binding.rvList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvList.adapter = adapter
    }

    private fun viewOnMap(list:List<Shop>){
        for (i in list){
            val marker = MarkerOptions().position(i.location).title(i.name)


        }
    }

    //fun pintar mapa(lista de shop){
   // for(i in lista de shop){
     //   val marker = MarkerOptions().position(i.location).title("i.name")
//        map.addMarker(marker)
//        map.animateCamera(
//            CameraUpdateFactory.newLatLngZoom(i.location, 18f),
//            4000,
//            null
    //}
    //buscar con que metodo de google maps cargo los locales nuevos
// }
}