package com.example.dailyexercise.makeList;

public class Exercise {
    private String exerciseDay;
    private String exerciseName;
    private String exerciseDuration;
    private int image;



    public Exercise(String exerciseDay, String exerciseName, String exerciseDuration, int image) {
        this.exerciseDay = exerciseDay;
        this.exerciseName = exerciseName;
        this.exerciseDuration = exerciseDuration;
        this.image = image;
    }

    public String getExerciseDay() {
        return exerciseDay;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getExerciseDuration() {
        return exerciseDuration;
    }

    public int getImage() {
        return image;
    }

}
