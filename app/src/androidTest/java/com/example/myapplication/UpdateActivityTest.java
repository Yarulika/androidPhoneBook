package com.example.myapplication;


import android.app.Activity;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.example.database.AppDatabase;
import com.example.database.PhoneUser;
import com.example.database.User;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UpdateActivityTest {
    private String contact_name = "user";
    private String number = "012345";

    @Rule
    public ActivityTestRule<UpdateActivity> mActivityRule = new ActivityTestRule<>(UpdateActivity.class);


    @Test
    public void update_sequence_test(){

        // check if the input field for contact name is enabled
        contact_name_field_isEnabled();

        // types in the name in the field
        Espresso.onView(withId(R.id.etxt_contact_name))
                .perform(typeText(contact_name));

        // input field for contact number is not displayed
        number_field_isNotDisplayed();

        // checks if the button label is "Find"
        Espresso.onView(withId(R.id.updateButton))
                .check(matches(withText("Find")));

        // clicks the find button
        Espresso.onView(withId(R.id.updateButton))
                .perform(click());

        // if contact exits button label changes to "Update"
        if_contact_exists_button_label_changes();

        // And the input field for contact name is disabled
        contact_name_field_isDisabled();

        // input field for contact number is displayed
        number_field_isDisplayed();
    }

    @Test
    public void contact_name_field_isEnabled(){
        Espresso.onView(withId(R.id.etxt_contact_name))
                .check(matches(isEnabled()));
    }

    @Test
    public void contact_name_field_isDisabled(){
        Espresso.onView(withId(R.id.etxt_contact_name))
                .check(matches(not(isEnabled())));
    }

    @Test
    public void if_contact_exists_button_label_changes(){
        Espresso.onView(withId(R.id.updateButton))
                .check(matches(withText("Update")));
    }

    @Test
    public void number_field_isNotDisplayed(){
        Espresso.onView(withId(R.id.etxt_contact_number))
                .check(matches(not(isDisplayed())));
    }

    @Test
    public void number_field_isDisplayed(){
        Espresso.onView(withId(R.id.etxt_contact_number))
                .check(matches(isDisplayed()));
    }



}
