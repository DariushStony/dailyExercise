package com.example.dailyexercise.makeList;

import com.example.dailyexercise.R;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {


    public static List<Exercise> getExercise(){
        List<Exercise> exercises = new ArrayList<>();


        exercises.add(new Exercise("Day :First day","Name :Jumping squats","Duration :4 sets of 15", R.drawable.jump_squats));
        exercises.add(new Exercise("Day :First day","Name :Jumping Jacks","Duration :5 Minutes",R.drawable.jumping_jack));
        exercises.add(new Exercise("Day :First day","Name :Butt bridge","Duration :1 Minutes",R.drawable.glute_bridge));
        exercises.add(new Exercise("Day :First day","Name :Cobra stretch","Duration :2 Minutes",R.drawable.cobra_stretch));
        exercises.add(new Exercise("Day :First day","Name :Passive hang","Duration :3 Minutes",R.drawable.passive_hang));
        exercises.add(new Exercise("Day :Second day","Name :V_UP","Duration :4 sets of 10",R.drawable.v_up));
        exercises.add(new Exercise("Day :Second day","Name :Forward bend","Duration :2 Minutes",R.drawable.forward_bend));
        exercises.add(new Exercise("Day :Second day","Name :Rope jumping","Duration :10 Minutes",R.drawable.rope_jumping));
        exercises.add(new Exercise("Day :Second day","Name :Plank","Duration :4 Minutes",R.drawable.ic_launcher_foreground));
        exercises.add(new Exercise("Day :Second day","Name :Swimming","Duration :4 sets of 15",R.drawable.ic_launcher_foreground));

        return exercises;
    }

}
