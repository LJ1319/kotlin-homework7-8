package com.example.reqresin.api.dto

import com.google.gson.annotations.SerializedName

// {
//      "id": 7,
//      "email": "michael.lawson@reqres.in",
//      "first_name": "Michael",
//      "last_name": "Lawson",
//      "avatar": "https://reqres.in/img/faces/7-image.jpg"
// },


data class User(
    val id: Long?,
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    val avatar: String?,
)

