package com.example.goooglemaps.model.dataSource

import com.example.goooglemaps.model.date.Dates
import com.example.goooglemaps.model.date.Shop

class DatesDataSource {
    private val data = Dates()

    fun getList(): List<Shop> {
        return data.getList()
    }

    fun getShopForId(id: Int): Shop? {
        return data.getShopForId(id)
    }
}