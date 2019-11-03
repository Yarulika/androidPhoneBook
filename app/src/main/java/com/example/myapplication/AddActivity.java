package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.database.AppDatabase;
import com.example.database.PhoneUser;

public class AddActivity extends AppCompatActivity {
    private EditText name;
    private EditText number;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_phone_user);
        findViews();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast; //Maybe snackbar is more visible
                if (name.getText().toString().trim().isEmpty() || number.getText().toString().trim().isEmpty()){
                    toast = Toast.makeText(getApplicationContext(), "Fill in both name and number", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    AppDatabase appDatabase = AppDatabase.getInstance(AddActivity.this);
                    PhoneUser phoneUser = appDatabase.phoneUserDAO().getUserByNameOrPhone(name.getText().toString(), number.getText().toString());
                    if (phoneUser == null){
                        appDatabase.phoneUserDAO().insertPhoneUser(new PhoneUser(name.getText().toString(), number.getText().toString()));
                        toast = Toast.makeText(getApplicationContext(), "Contact was added!", Toast.LENGTH_LONG);
                        toast.show();
                    } else {
                        toast = Toast.makeText(getApplicationContext(), "Name or phone number are already added!", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });
    }

    private void findViews() {
        name = findViewById(R.id.etxt_name_phone_user);
        number = findViewById(R.id.etxt_number_phone_user);
        add = findViewById(R.id.btn_add_phone_user);
    }
}
