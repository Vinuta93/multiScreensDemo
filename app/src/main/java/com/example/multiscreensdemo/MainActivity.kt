package com.example.multiscreensdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multiscreensdemo.`interface`.OnItemClick
import com.example.multiscreensdemo.adapter.HomeItemAdapter
import com.example.multiscreensdemo.model.HomeItems

class MainActivity : AppCompatActivity(), OnItemClick {

    lateinit var rv : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = HomeItemAdapter(getData(), this)


    }

    private fun getData(): ArrayList<HomeItems> {
        val list = ArrayList<HomeItems>()

        list.add(HomeItems("Activities", R.drawable.img1))

        list.add(HomeItems("Data",R.drawable.img2))

        list.add(HomeItems("Exercise",R.drawable.img3))
        list.add(HomeItems("Education",R.drawable.img4))
        return list
    }

    override fun onCardItemClick(name: String) {
        val intent = Intent(this, SecondPage::class.java)

        when(name){
            "Activities"->{
                intent.putExtra("md","Activities" )

            }
            "Data" ->{
                intent.putExtra("md","Data" )

            }
            "Exercise" ->{
                intent.putExtra("md","Exercise" )

            }
            "Education" ->{
                intent.putExtra("md","Education" )

            }
        }



        startActivity(intent)



    }




}