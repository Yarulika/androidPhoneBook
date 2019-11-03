package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btn_logout_menu_item) {
            System.out.println("loooooog out");
            theUserIsLoggedOut();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onAddClick(View view) {
        System.out.println("onAddClick pressed");
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void onDeleteClick(View view) {
        Intent intent = new Intent(MenuActivity.this, DeleteContactActivity.class);
        startActivity(intent);
    }

    public void onUpdateClick(View view) {
        System.out.println("onUpdateClick pressed");
    }

    void theUserIsLoggedOut() {
        SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        //user is logged in so save a variable to show that is logged in..
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("LoggedIn",false);
        editor.apply();
    }
}
