package com.example.dailyexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.dailyexercise.exercises.ExerciseSharedPreferences;
import com.example.dailyexercise.exercises.ValidatePassword;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.Map;

public class SubmitActivity extends AppCompatActivity {

    private TextInputLayout textInputUsername;
    private TextInputEditText edtUsername;
    private TextInputLayout textInputPassword;
    private TextInputEditText edtPassword;
    private Button submit;
    SharedPreferences sharedPreferences;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String SHARED_PREF = "shared pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        findById();
        StatusBarUtil.setTransparent(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);

        String username = sharedPreferences.getString(USERNAME,null);
        String password = sharedPreferences.getString(PASSWORD,null);
        if (username != null && password != null){
            Intent intent = new Intent(SubmitActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUsername();
                validatePassword();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(USERNAME,edtUsername.getText().toString().trim());
                editor.putString(PASSWORD,edtPassword.getText().toString().trim());
                editor.apply();

                if (validateUsername() && validatePassword()){
                    Intent intent = new Intent(SubmitActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(SubmitActivity.this,"Sign in successfully",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void findById() {
        textInputPassword = findViewById(R.id.txt_input_submit_password);
        textInputUsername = findViewById(R.id.txt_input_submit_username);
        edtUsername = findViewById(R.id.edt_submit_username);
        edtPassword = findViewById(R.id.edt_submit_password);
        submit = findViewById(R.id.btn_submit);

    }

    public boolean validateUsername() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        Map<String, Boolean> validateMap = ValidatePassword.CheckValidate(passwordInput);

        boolean hasLowercase = validateMap.get(ValidatePassword.LOWER);
        boolean hasUppercase = validateMap.get(ValidatePassword.UPPER);
        boolean hasDigit = validateMap.get(ValidatePassword.DIGIT);

        if (passwordInput.isEmpty()) {
            textInputPassword.setError(getString(R.string.empty_err));
            return false;
        } else if (passwordInput.length() < 8) {
            textInputPassword.setError(getString(R.string.length_err));
            return false;
        } else if (!hasUppercase) {
            textInputPassword.setError(getString(R.string.uppercase_err));
            return false;
        } else if (!hasLowercase) {
            textInputPassword.setError(getString(R.string.lowercase_err));
            return false;
        } else if (!hasDigit) {
            textInputPassword.setError(getString(R.string.digit_err));
            return false;
        }else {
            textInputPassword.setError(null);
            return true;
        }

    }

    public boolean validatePassword() {
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();
        if (usernameInput.isEmpty()) {
            textInputUsername.setError(getString(R.string.empty_err));
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }
//    public void removeUserAndPass(){
//        sharedPreferences.edit().remove(USERNAME).apply();
//        sharedPreferences.edit().remove(PASSWORD).apply();
//    }
}