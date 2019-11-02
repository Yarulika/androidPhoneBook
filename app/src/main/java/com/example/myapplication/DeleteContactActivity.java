package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Delete;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.database.AppDatabase;
import com.example.database.PhoneUser;

public class DeleteContactActivity extends AppCompatActivity {

    private EditText userToDelete;
    private AppDatabase appDatabase = AppDatabase.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);
    }

    public void onDeleteUserClick(View view) {

        PhoneUser phoneUser =getUser();
        String toastText;

        if (phoneUser != null){//if the user exist delete it...
            appDatabase.phoneUserDAO().deletePhoneUser(phoneUser);
            toastText = "The user is deleted";

            //Redirect to the menu activity
            Intent intent = new Intent(DeleteContactActivity.this, MenuActivity.class);
            startActivity(intent);

        }else {
            toastText = "The user does not exist";
        }

        Toast toast = Toast.makeText(this,toastText,Toast.LENGTH_LONG);
        toast.show();
    }

    private PhoneUser getUser(){

        userToDelete = findViewById(R.id.userToDelete);//get the field and the name we wrote
        String user = userToDelete.getText().toString();
        PhoneUser phoneUser = appDatabase.phoneUserDAO().getUserByNameOrPhone(user,user);//get the user
        return phoneUser;
    }
}
