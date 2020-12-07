package com.example.dailyexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;

import com.example.dailyexercise.exercises.ExerciseSharedPreferences;
import com.example.dailyexercise.makeList.DataProvider;
import com.example.dailyexercise.makeList.ExerciseAdaptor;
import com.jaeger.library.StatusBarUtil;

public class ViewListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);
        StatusBarUtil.setTransparent(this);


        ExerciseAdaptor exerciseAdaptor = new ExerciseAdaptor();
        exerciseAdaptor.setExercises(DataProvider.getExercise());
        recyclerView = findViewById(R.id.rc_view_exercise);
        recyclerView.setAdapter(exerciseAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

    }

}