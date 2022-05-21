package com.example.reqresin.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.reqresin.R
import com.example.reqresin.adapters.ResourceRecyclerAdapter.Companion.RESOURCE_ID
import com.example.reqresin.api.RestClient
import com.example.reqresin.api.dto.ReqResData
import com.example.reqresin.api.dto.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResourceActivity : AppCompatActivity() {
    private lateinit var nameView: TextView
    private lateinit var yearView: TextView
    private lateinit var colorView: TextView
    private lateinit var pantoneView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        nameView = findViewById(R.id.textView7)
        yearView = findViewById(R.id.textView8)
        colorView = findViewById(R.id.textView9)
        pantoneView = findViewById(R.id.textView10)


        val resourceId = intent.extras?.getLong(RESOURCE_ID, -1)

        if (resourceId != -1L) {
            RestClient.reqResApi.getResource(resourceId!!)
                .enqueue(object : Callback<ReqResData<Resource>> {
                    override fun onResponse(
                        call: Call<ReqResData<Resource>>,
                        response: Response<ReqResData<Resource>>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.data?.let {
                                nameView.text = it.name?.uppercase()
                                nameView.setTextColor(Color.parseColor(it.color))
                                yearView.text = it.year.toString()
                                colorView.text = it.color
                                colorView.setTextColor(Color.parseColor(it.color))
                                pantoneView.text = it.pantoneValue
                            }
                        }
                    }

                    override fun onFailure(call: Call<ReqResData<Resource>>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
        }

    }
}