package com.example.dailyexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dailyexercise.exercises.ExerciseSharedPreferences;
import com.example.dailyexercise.exercises.ValidatePassword;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.jaeger.library.StatusBarUtil;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputUsername;
    private TextInputEditText edtUsername;
    private TextInputLayout textInputPassword;
    private TextInputEditText edtPassword;
    private Button login;
    private Button signIn;
    private CheckBox chbRemember;
    private String username;
    private String password;
    private ExerciseSharedPreferences exerciseSharedPreferences;
    SharedPreferences sharedPreferences;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String SHARED_PREF = "shared pref";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findById();
        StatusBarUtil.setTransparent(this);

        sharedPreferences = getSharedPreferences(SHARED_PREF,MODE_PRIVATE);
        String myUsername = sharedPreferences.getString(USERNAME,null);
        String myPassword = sharedPreferences.getString(PASSWORD,null);
        if (myUsername != null && myPassword != null){
            edtUsername.setText(myUsername);
            edtPassword.setText(myPassword);
        }


        exerciseSharedPreferences = new ExerciseSharedPreferences(this);
        chbRemember.setChecked(exerciseSharedPreferences.getRememberMe());
        if (chbRemember.isChecked()){
           edtUsername.setText(exerciseSharedPreferences.getUsername());
           edtPassword.setText(exerciseSharedPreferences.getPassword());
        }

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SubmitActivity.class);
                startActivity(intent);
                finish();
//                signIn.setVisibility(View.GONE);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUsername();
                validatePassword();
                username = edtUsername.getText().toString().trim();
                password = edtPassword.getText().toString().trim();
                exerciseSharedPreferences.setRememberMe(chbRemember.isChecked());
                 if (chbRemember.isChecked()){
                     exerciseSharedPreferences.setUsernameAndPassword(username,password);
                 }else {
                     exerciseSharedPreferences.removeUserAndPass();
                 }

                if (validateUsername() && validatePassword()){
                    Intent intent = new Intent(MainActivity.this, ViewListActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        if (!chbRemember.isChecked()){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
        }
    }

    public void findById() {
        textInputPassword = findViewById(R.id.txt_input_password);
        textInputUsername = findViewById(R.id.txt_input_username);
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        login = findViewById(R.id.btn_login);
        signIn = findViewById(R.id.btn_sign_in);
        chbRemember = findViewById(R.id.chb_remember);

    }

    public boolean validateUsername() {
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();
        if (usernameInput.isEmpty()) {
            textInputUsername.setError(getString(R.string.empty_err));
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
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
}
