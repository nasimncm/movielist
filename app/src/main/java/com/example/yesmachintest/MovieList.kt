package com.example.yesmachintest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yesmachintest.adapter.RecyclerAdapter
import com.example.yesmachintest.model.DataModel
import com.example.yesmachintest.network.APIClient
import com.example.yesmachintest.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieList : AppCompatActivity() {
    var quotesList = ArrayList<DataModel>()
    lateinit var rv: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        rv = findViewById(R.id.recyclerView)

        getQuote()
    }
    private fun getQuote() {
        val client = APIClient().getRetrofitClient().create(ApiInterface::class.java)
        client.getQuotes().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            )
            {
                // Used for inserting data in arraylist of type DataModel
                quotesList = response.body() as ArrayList<DataModel>
                val adapter = RecyclerAdapter(quotesList, this@MovieList)
                // For showing data list vertically
                rv.layoutManager = LinearLayoutManager(this@MovieList)
                rv.adapter = adapter

            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                // Write a code for failure
            }

        })
    }
}