package com.example.multiscreensdemo.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.multiscreensdemo.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.logging.Handler;

public class ActivityAdapter  extends RecyclerView.Adapter<ActivityAdapter.ViewHolder> {

    ArrayList<String> myList ;
    Context ctx;

    public ActivityAdapter(ArrayList<String> lists, Context c){
        this.myList = lists;
        this.ctx = c ;
    }



    @NonNull
    @NotNull
    @Override
    public ActivityAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ActivityAdapter.ViewHolder holder, int position) {

        holder.init(myList.get(position));
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView activitiesText;
        Button btn;
        int musicList[] = { R.raw.audio1, R.raw.audio2, R.raw.audio3, R.raw.audio4, R.raw.audio5};
        MediaPlayer mediaPlayer;


        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            activitiesText = itemView.findViewById(R.id.txt);
            btn = itemView.findViewById(R.id.play);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("TAG", String.valueOf(getAdapterPosition()));
                    int ran = getRandomNumber(0, musicList.length);
                    mediaPlayer= MediaPlayer.create(ctx, musicList[ran]);
                    mediaPlayer.start();
                    

                }
            });

        }


        public void init(String s){
            activitiesText.setText(s);
        }

        public int getRandomNumber(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }
    }
}
