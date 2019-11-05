package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Utils.HideKeyBoard;
import com.example.database.AppDatabase;
import com.example.database.PhoneUser;

public class UpdateActivity extends Activity {
    private EditText contactName;
    private EditText number;
    private Button findButton;

    private PhoneUser retrivedPhoneUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        findViews();
    }

    private void findViews() {
        contactName = findViewById(R.id.etxt_contact_name);
        number = findViewById(R.id.etxt_contact_number);
        findButton = findViewById(R.id.loginButton);
    }

    public void onFindClick(View view) {
        if (String.valueOf(findButton.getText()).equals("Update")) {
            System.out.println("True");
            updateContact();
        } else {
            findContact(view);
        }
    }

    private void findContact(View view) {
        HideKeyBoard.hide(this);

        AppDatabase appDatabase = AppDatabase.getInstance(this);
        retrivedPhoneUser = appDatabase.phoneUserDAO().getUserByNameOrPhone(String.valueOf(contactName.getText()), "");

        if (retrivedPhoneUser == null) {
            toastMessage("No such contact");
        } else {
            contactName.setEnabled(false);
            number.setText(retrivedPhoneUser.number);
            number.setVisibility(View.VISIBLE);
            findButton.setText(R.string.update);
        }
    }

    private void updateContact() {

        HideKeyBoard.hide(this);

        PhoneUser phoneUser = new PhoneUser(String.valueOf(contactName.getText()), String.valueOf(number.getText()));
        phoneUser.id = retrivedPhoneUser.id;
        AppDatabase.getInstance(this).phoneUserDAO().updatePhoneUser(phoneUser);

        toastMessage("Contact updated!");

        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }


}
