package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Utils.HideKeyBoard;
import com.example.database.AppDatabase;
import com.example.database.User;

public class RegisterActivity extends Activity {
    private EditText username;
    private EditText password;
    private EditText password2;
    private Button registerButton;

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
        registerButton = findViewById(R.id.loginButton);
    }

    public void onRegisterClick(View view) {

        HideKeyBoard.hide(this);

        String username = String.valueOf(this.username.getText());
        String password = String.valueOf(this.password.getText());
        String password2 = String.valueOf(this.password2.getText());

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        User user = appDatabase.userDAO().findUserByName(username);

        if (!username.trim().isEmpty() && !password.trim().isEmpty() && !password.trim().isEmpty()) {
            if (user == null) {
                if (password.equals(password2)) {
                    appDatabase.userDAO().insertUser(new User(username, password));

                    toastMessage("Successfully registered!");

                    goToLoginPage();
                } else {
                    toastMessage("Passwords mismatched!");
                }
            } else {
                toastMessage("Username already taken!");
            }
        } else {
            toastMessage("The fields cannot be empty!");
        }

    }

    public void goToLoginPage() {
        HideKeyBoard.hide(this);
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
