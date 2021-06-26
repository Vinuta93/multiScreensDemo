package com.example.multiscreensdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multiscreensdemo.adapter.HomeItemAdapter
import com.example.multiscreensdemo.model.HomeItems

class MainActivity : AppCompatActivity() {

    lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = HomeItemAdapter(getData())


    }

    private fun getData(): ArrayList<HomeItems> {
        val list = ArrayList<HomeItems>()

        list.add(HomeItems("Activities", R.drawable.img1))

        list.add(HomeItems("Data",R.drawable.img2))

        list.add(HomeItems("Exercise",R.drawable.img3))
        list.add(HomeItems("Education",R.drawable.img4))
        return list
    }
}