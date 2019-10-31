package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.database.AppDatabase;
import com.example.database.User;

public class RegisterActivity extends Activity {
    private EditText username;
    private EditText password;
    private EditText password2;
    private Button loginButton;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        findViews();
    }

    private void findViews() {
        username = findViewById(R.id.etxt_username);
        password = findViewById(R.id.etxt_password);
        password2 = findViewById(R.id.etxt_password2);
        loginButton = findViewById(R.id.loginButton);
        errorText = findViewById(R.id.txt_error);
    }

    public void onRegisterClick(View view) {
        String username = String.valueOf(this.username.getText());
        String password = String.valueOf(this.password.getText());
        String password2 = String.valueOf(this.password2.getText());

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        User user = appDatabase.userDAO().findUserByName(username);

        if(user == null){
            if(password.equals(password2)){
                appDatabase.userDAO().insertUser(new User(username,password));

                Toast.makeText(this, "Successfully registered!", Toast.LENGTH_LONG).show();

                goToLoginPage();

            } else{
                errorText.setText("Passwords mismatched!");
            }
        }else {
            errorText.setText("Username already taken!");
        }

    }

    public void goToLoginPage() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
