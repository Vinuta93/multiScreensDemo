package com.example.multiscreensdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.multiscreensdemo.adapter.ActivityAdapter;

import java.util.ArrayList;

public class SecondPage extends AppCompatActivity {

    RecyclerView recyclerView;
    ActivityAdapter activityAdapter;
    String data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        recyclerView = findViewById(R.id.activityRv);
        data = getIntent().getStringExtra("md");
        setAdapterData();



    }
    void setAdapterData(){
        if (data.equals("Activities")){
            activityAdapter = new ActivityAdapter(getActivities(), this);
        }else if (data.equals("Data")){
            activityAdapter = new ActivityAdapter(getData(), this);
        }else if (data.equals("Exercise")){
            activityAdapter = new ActivityAdapter(getExcercise(),this);

        }else if (data.equals("Education")){
            activityAdapter = new ActivityAdapter(getEducation(),this);
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(activityAdapter);
    }
    ArrayList<String> getEducation() {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("Videos");
        myList.add("Link to HSE");


        return myList;
    }
    ArrayList<String> getExcercise() {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("GYM Workout");
        myList.add("Aerobics");
        myList.add("Dance Workout");
        myList.add("Meditation");

        return myList;
    }
    ArrayList<String> getActivities() {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("Activity 1");
        myList.add("Activity 2");
        myList.add("Activity 3");
        myList.add("Activity 4");
        myList.add("Activity 5");
        myList.add("Activity 6");

        return myList;
    }
    ArrayList<String> getData() {

        ArrayList<String> myList = new ArrayList<>();
        myList.add("Daily");
        myList.add("Weekly");
        myList.add("Monthly");


        return myList;
    }


}