package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.database.AppDatabase;
import com.example.database.User;

import java.util.List;

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
        if (isValidUser()) {
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {

            errorText.setText("Invalid credentials!");
        }
    }

    public void goToRegisterPage(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }


    private boolean isValidUser() {
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        User user = appDatabase.userDAO().findUserByName(String.valueOf(this.username.getText()));
        List<User> users = appDatabase.userDAO().getAllUsers();

        for (User us : users) {
            System.out.println("User : " + us.name + " , Password : " + us.password);
        }

        boolean result = false;

        if (user != null && user.password.equals(String.valueOf(this.password.getText()))) {
            result = true;
        }

        return result;
    }

}
