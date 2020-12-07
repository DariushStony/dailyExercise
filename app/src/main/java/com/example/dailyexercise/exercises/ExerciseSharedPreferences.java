package com.example.dailyexercise.exercises;

import android.content.Context;
import android.content.SharedPreferences;

public class ExerciseSharedPreferences {
    private static SharedPreferences sharedPreferences;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String REMEMBER_ME = "remember me";
    public static final String REMEMBER_DOING = "remember_doing";


    public ExerciseSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE);
    }

    public void setUsernameAndPassword(String username, String password){
        sharedPreferences.edit().putString(USERNAME,username).apply();
        sharedPreferences.edit().putString(PASSWORD,password).apply();
    }

    public String getUsername(){
        return sharedPreferences.getString(USERNAME,"");
    }
    public String getPassword(){
        return sharedPreferences.getString(PASSWORD,"");
    }
    public static void setRememberMe(boolean rememberMe){
        sharedPreferences.edit().putBoolean(REMEMBER_ME,rememberMe).apply();
    }
    public static boolean getRememberMe(){
        return sharedPreferences.getBoolean(REMEMBER_ME,false);
    }
    public void removeUserAndPass(){
        sharedPreferences.edit().remove(USERNAME).apply();
        sharedPreferences.edit().remove(PASSWORD).apply();
    }
    public static boolean getRememberDoing(){
        return sharedPreferences.getBoolean(REMEMBER_ME,false);
    }
}
