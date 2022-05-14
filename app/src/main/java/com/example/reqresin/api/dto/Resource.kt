package com.example.reqresin.api.dto

import com.google.gson.annotations.SerializedName

// {
//     "id": 1,
//     "name": "cerulean",
//     "year": 2000,
//     "color": "#98B2D1",
//     "pantone_value": "15-4020"
// }

data class Resource(
    val id: Long?,
    val name: String?,
    val year: Int?,
    val color: String?,
    @SerializedName("pantone_value")
    val pantoneValue: String?
)



