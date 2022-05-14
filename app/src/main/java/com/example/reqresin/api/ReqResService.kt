package com.example.reqresin.api
import com.example.reqresin.api.dto.CRUD
import com.example.reqresin.api.dto.ReqResData
import com.example.reqresin.api.dto.Resource
import com.example.reqresin.api.dto.User
import retrofit2.Call
import retrofit2.http.*

interface ReqResService {

    @GET("users")
    fun getUsers(@Query("page")page: Int) : Call<ReqResData<List<User>>>

    @GET("users/{userId}")
    fun getUser(@Path("userId")id: Long) : Call<ReqResData<User>>

    @GET("unknown")
    fun getResources() : Call<ReqResData<List<Resource>>>

    @GET("unknown/{resourceId}")
    fun getResource(@Path("resourceId")id: Long) : Call<ReqResData<Resource>>

    @DELETE("users/{userId}")
    fun deleteUser(@Path("userId")id: Long) : Call<ReqResData<User>>

    @POST("users")
    fun createUser(@Field("name")name: String, @Field("job")job: String) : Call<CRUD>

}