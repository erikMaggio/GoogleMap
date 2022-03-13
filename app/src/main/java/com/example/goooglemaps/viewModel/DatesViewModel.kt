package com.example.goooglemaps.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.goooglemaps.model.date.Shop
import com.example.goooglemaps.model.repository.DateRepository

class DatesViewModel : ViewModel() {

    private val dateRepository = DateRepository()
    val dateLiveData = MutableLiveData<List<Shop>>()
    val detailsLiveData = MutableLiveData<Shop?>()

    fun getList() {
        val call = dateRepository.getList()
        dateLiveData.postValue(call)
    }

    fun getShopForId(id: Int) {
        val call = dateRepository.getShopForId(id)
        detailsLiveData.postValue(call)
    }
}
