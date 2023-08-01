package com.example.yesmachintest.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yesmachintest.MovieDetails
import com.example.yesmachintest.R
import com.example.yesmachintest.model.DataModel

class RecyclerAdapter(val dataList: List<DataModel>, val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recyclerModel = dataList[position]

        // Text set to the TextView widget
        holder.quoteText.text = recyclerModel.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, MovieDetails::class.java)
            intent.putExtra("imageurl", recyclerModel.imageurl.toString())
            intent.putExtra("name", recyclerModel.name.toString())
            intent.putExtra("realname", recyclerModel.realname.toString())
            intent.putExtra("team", recyclerModel.team.toString())
            intent.putExtra("firstappearance", recyclerModel.firstappearance.toString())
            intent.putExtra("createdby", recyclerModel.createdby.toString())
            intent.putExtra("publisher", recyclerModel.publisher.toString())
            intent.putExtra("bio", recyclerModel.bio.toString())
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val quoteText: TextView = itemView.findViewById(R.id.quoteText)

    }

}