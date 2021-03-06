package com.example.multiscreensdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.multiscreensdemo.R
import com.example.multiscreensdemo.`interface`.OnItemClick
import com.example.multiscreensdemo.model.HomeItems

class HomeItemAdapter(var items : ArrayList<HomeItems>, var i : OnItemClick)  : RecyclerView.Adapter<HomeItemAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_card_layout,null))

    }


    override fun onBindViewHolder(holder: HomeItemAdapter.ViewHolder, position: Int) {
        holder.init(items[position], i)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name : TextView = itemView.findViewById(R.id.name)
        private val image : ImageView = itemView.findViewById(R.id.img)

        fun init(homeItems: HomeItems, i: OnItemClick) {

            name.text = homeItems.name
            image.setImageResource(homeItems.resourceID)
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, homeItems.name, Toast.LENGTH_SHORT).show()
                i.onCardItemClick( homeItems.name)


            }
        }

    }
}