package com.example.dailyexercise.makeList;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailyexercise.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView day;
    TextView name;
    TextView duration;
    ImageView picture;
    CheckBox chDoing;


    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        this.day = itemView.findViewById(R.id.txt_day);
        this.name = itemView.findViewById(R.id.txt_name);
        this.duration = itemView.findViewById(R.id.txt_duration);
        this.picture = itemView.findViewById(R.id.im_view_picture);
        this.chDoing = itemView.findViewById(R.id.ch_doing);
    }

}
