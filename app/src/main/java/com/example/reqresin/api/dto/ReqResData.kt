package com.example.reqresin.api.dto

import com.google.gson.annotations.SerializedName

//  "page": 2,
//  "per_page": 6,
//  "total": 12,
//  "total_pages": 2,

data class ReqResData<T>(
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val data: T?
)