package com.example.goooglemaps.model.repository

import com.example.goooglemaps.model.dataSource.DatesDataSource
import com.example.goooglemaps.model.date.Shop

class DateRepository {
    private val dataSource = DatesDataSource()

    fun getList(): List<Shop> {
        return dataSource.getList()
    }

    fun getShopForId(id: Int): Shop? {
        return dataSource.getShopForId(id)
    }
}