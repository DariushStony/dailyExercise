package com.example.dailyexercise.makeList;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dailyexercise.R;
import com.example.dailyexercise.ViewListActivity;
import com.example.dailyexercise.exercises.ExerciseSharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class ExerciseAdaptor extends RecyclerView.Adapter<ItemViewHolder> {
    private List<Exercise> exercises = new ArrayList<>();
    private SharedPreferences sharedPreferences;
    public static final String REMEMBER_ME = "remember me";
    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_exercise,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        holder.day.setText(exercise.getExerciseDay());
        holder.name.setText(exercise.getExerciseName());
        holder.duration.setText(exercise.getExerciseDuration());
        holder.picture.setImageResource(exercise.getImage());
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }
}
