package com.example.reqresin.api.dto

// {
//      "name": "morpheus",
//      "job": "leader",
// }

// {
//     "name": "morpheus",
//     "job": "leader",
//     "id": "260",
//     "createdAt": "2022-05-14T22:20:24.195Z"
// }


data class Post(
    val name: String?,
    val job: String?,
    val id: String?,
    val createdAt: String?
)