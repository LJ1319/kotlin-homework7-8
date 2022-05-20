package com.example.reqresin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.reqresin.R
import com.example.reqresin.adapters.UserRecyclerAdapter.Companion.USER_ID
import com.example.reqresin.api.RestClient
import com.example.reqresin.api.dto.ReqResData
import com.example.reqresin.api.dto.User
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var nameView: TextView
    private lateinit var mailView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        imageView = findViewById(R.id.imageView2)
        nameView = findViewById(R.id.textView3)
        mailView = findViewById(R.id.textView4)
        val userId = intent.extras?.getLong(USER_ID, -1)

        if (userId != -1L) {
            RestClient.reqResApi.getUser(userId!!).enqueue(object : Callback<ReqResData<User>> {
                override fun onResponse(
                    call: Call<ReqResData<User>>,
                    response: Response<ReqResData<User>>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.data?.let {
                            Picasso.get().load(it.avatar).into(imageView);
                            nameView.text = "${it.firstName} ${it.lastName}"
                            mailView.text = it.email
                        }
                    }
                }

                override fun onFailure(call: Call<ReqResData<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }
}