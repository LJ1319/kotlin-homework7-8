package com.example.reqresin.api.dto

// {
//     "name": "morpheus",
//     "job": "zion resident"
// }

// {
//     "name": "morpheus",
//     "job": "zion resident",
//     "updatedAt": "2022-05-15T11:28:29.693Z"
// }


data class Patch(
    val name: String?,
    val job: String?,
    val updatedAt: String?
)