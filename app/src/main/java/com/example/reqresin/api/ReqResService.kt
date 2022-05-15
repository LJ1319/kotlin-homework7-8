package com.example.reqresin.api

import com.example.reqresin.api.dto.*
import retrofit2.Call
import retrofit2.http.*

interface ReqResService {

    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<ReqResData<List<User>>>

    @GET("users/{userId}")
    fun getUser(@Path("userId") id: Long): Call<ReqResData<User>>

    @GET("unknown")
    fun getResources(): Call<ReqResData<List<Resource>>>

    @GET("unknown/{resourceId}")
    fun getResource(@Path("resourceId") id: Long): Call<ReqResData<Resource>>

    @POST("users")
    fun createUser(@Body post: Post): Call<Post>

    @PATCH("users/{userId}")
    fun patchUser(@Path("userId") id: Long, @Body patch: Patch): Call<Patch>

    @DELETE("users/{userId}")
    fun deleteUser(@Path("userId") id: Long): Call<User>



}