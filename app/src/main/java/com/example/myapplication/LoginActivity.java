package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.Utils.HideKeyBoard;
import com.example.database.AppDatabase;
import com.example.database.User;

public class LoginActivity extends Activity {
    private EditText username;
    private EditText password;
    private Button loginButton;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        findViews();
    }

    private void findViews() {
        username = findViewById(R.id.etxt_username);
        password = findViewById(R.id.etxt_password);
        loginButton = findViewById(R.id.loginButton);
        errorText = findViewById(R.id.txt_error);
    }

    public void onLoginClick(View view) {
        HideKeyBoard.hide(this);

        if (isNotEmpty(username) && isNotEmpty(password)) {
            if (isValidUser()) {
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();//dont show on back press
                saveLoggedInUser(true, this);//the user is logged in so we are saving the state..
            } else {
                errorText.setText("Invalid credentials!");
            }
        } else {
            errorText.setText("The fields cannot be empty!");
        }
    }

    public void goToRegisterPage(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


    private boolean isValidUser() {
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        User user = appDatabase.userDAO().findUserByName(String.valueOf(this.username.getText()));

        boolean result = false;

        if (user != null && user.password.equals(String.valueOf(this.password.getText()))) {
            result = true;
        }

        return result;
    }


    private boolean isNotEmpty(TextView textView) {
        return !String.valueOf(textView.getText()).trim().isEmpty();
    }

    public void saveLoggedInUser(boolean value, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        //user is logged in so save a variable to show that is logged in..
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("LoggedIn", value);
        editor.apply();
    }
}
