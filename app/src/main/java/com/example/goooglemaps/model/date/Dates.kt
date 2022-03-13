package com.example.goooglemaps.model.date

import com.google.android.gms.maps.model.LatLng

class Dates {
    private val listDates = listOf(
        Shop(
            "McDonald's",
            LatLng(-34.8183791, -58.4664684),
            1,
            "Clásica cadena de comida rápida",
            "Blvd. Buenos Aires 136, B1842 Monte Grande, Provincia de Buenos Aires"
        ),
        Shop(
            "Banco de la Nación Argentina",
            LatLng(-34.7602958, -58.40166),
            2,
            "Leandro N. Alem 15, B1832 Lomas de Zamora, Provincia de Buenos Aires",
            "texto"
        ),
        Shop(
            "La Primavera",
            LatLng(-34.7849937, -58.4656506),
            3,
            "casa de comida",
            "Luis Guillon, Provincia de Buenos Aires"
        ),
        Shop(
            "Movistar",
            LatLng(-34.8186077, -58.4692393),
            4,
            "Proveedor de servicios de telecomunicaciones en Monte Grande",
            ": Dr. Ángel C. Rotta 26, B1842AEB Monte Grande, Provincia de Buenos Aires"
        ),
        Shop(
            "Hospital Donación Francisco Santojanni",
            LatLng(-34.6488717, -58.517365),
            5,
            "Hospital general en Buenos Aires",
            "Pilar 950, Buenos Aires CABA"
        )
    )

    fun getList(): List<Shop> {
        return listDates
    }

    fun getShopForId(id: Int): Shop? {
        return listDates.find { it.id == id }
    }

}

data class Shop(
    val name: String,
    val location: LatLng,
    val id: Int,
    val description: String,
    val direction: String
)





