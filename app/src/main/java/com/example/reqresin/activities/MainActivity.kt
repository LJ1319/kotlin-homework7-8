package com.example.reqresin.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.reqresin.R
import com.example.reqresin.adapters.UserRecyclerAdapter
import com.example.reqresin.api.RestClient
import com.example.reqresin.api.dto.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        RestClient.initClient()
        RestClient.reqResApi.getUsers(2).enqueue(object : Callback<ReqResData<List<User>>> {

            override fun onResponse(
                call: Call<ReqResData<List<User>>>,
                response: Response<ReqResData<List<User>>>
            ) {
                if (response.isSuccessful) {
//                    response.body()?.data?.forEach { user -> Log.d("users", user.toString()) }

                    response.body()?.data?.let {
                        recyclerView.adapter = UserRecyclerAdapter(it)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<User>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        RestClient.reqResApi.getUser(2).enqueue(object : Callback<ReqResData<User>> {

            override fun onResponse(
                call: Call<ReqResData<User>>,
                response: Response<ReqResData<User>>
            ) {
                if (response.isSuccessful) {

                    val userId: Long? = response.body()?.data?.id
                    val userEmail: String? = response.body()?.data?.email
                    val userFirstName: String? = response.body()?.data?.firstName
                    val userLastName: String? = response.body()?.data?.lastName
                    val userAvatar: String? = response.body()?.data?.avatar

                    val userInfo = "$userId $userEmail $userFirstName $userLastName $userAvatar"

                    Log.d("userInfo", userInfo)

                }
            }

            override fun onFailure(call: Call<ReqResData<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


        RestClient.reqResApi.getResources().enqueue(object : Callback<ReqResData<List<Resource>>> {

            override fun onResponse(
                call: Call<ReqResData<List<Resource>>>,
                response: Response<ReqResData<List<Resource>>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.data?.forEach { user -> Log.d("resources", user.toString()) }
                }
            }

            override fun onFailure(call: Call<ReqResData<List<Resource>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


        RestClient.reqResApi.getResource(2).enqueue(object : Callback<ReqResData<Resource>> {

            override fun onResponse(
                call: Call<ReqResData<Resource>>,
                response: Response<ReqResData<Resource>>
            ) {
                if (response.isSuccessful) {

                    val resourceId: Long? = response.body()?.data?.id
                    val resourceName: String? = response.body()?.data?.name
                    val resourceYear: Int? = response.body()?.data?.year
                    val resourceColor: String? = response.body()?.data?.color
                    val resourcePantoneValue: String? = response.body()?.data?.pantoneValue

                    val resource =
                        "$resourceId $resourceName $resourceYear $resourceColor $resourcePantoneValue"

                    Log.d("resource", resource)

                }
            }

            override fun onFailure(call: Call<ReqResData<Resource>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


        val userInfo = Post(
            name = "Alex",
            job = "alex@gmail.com",
            id = null,
            createdAt = null
        )


        RestClient.reqResApi.createUser(userInfo).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    val name: String? = response.body()?.name
                    val job: String? = response.body()?.job
                    val id: String? = response.body()?.id
                    val createdAt: String? = response.body()?.createdAt

                    val createdUser = "$name $job $id $createdAt"

                    Log.d("CREATED", createdUser)
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


        val patch = Patch(
            name = "morpheus",
            job = "zion resident",
            updatedAt = null
        )

        RestClient.reqResApi.patchUser(2, patch).enqueue(object : Callback<Patch> {
            override fun onResponse(call: Call<Patch>, response: Response<Patch>) {
                val name: String? = response.body()?.name
                val job: String? = response.body()?.job
                val updatedAt: String? = response.body()?.updatedAt

                val updatedUser = "$name $job $updatedAt"

                Log.d("UPDATED", updatedUser)
            }

            override fun onFailure(call: Call<Patch>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        RestClient.reqResApi.deleteUser(2).enqueue(object : Callback<User> {

            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                Log.d("DELETED", "DELETED")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })


    }
}