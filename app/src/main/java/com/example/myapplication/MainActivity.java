package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private TextView loginErr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findVIews();
    }

    private void findVIews(){
        username = findViewById(R.id.etxt_username);
        password = findViewById(R.id.etxt_password);
        loginErr = findViewById(R.id.lblStatus);
    }

    public void onLoginClick(View view) {

        System.out.println(username.getText().toString() + " " + password);
        if (username.getText().toString().equals("Admin") && password.getText().toString().equals("123")){
            Intent intent = new Intent(this,SecondActivity.class);
            startActivity(intent);
            finish();
        }else {

            loginErr.setText("Incorrect password");
        }
    }
}
