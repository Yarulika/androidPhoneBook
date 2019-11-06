package com.example.myapplication;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void isDeleteButton(){
        Espresso.onView(withId(R.id.loginButton))
                .check(matches(isClickable()));
    }

    @Test
    public void isUserInputFieldEnabled(){
        Espresso.onView(withId(R.id.etxt_username))
                .check(matches(isEnabled()));
    }

    @Test
    public void isPasswordInputFieldEnabled(){
        Espresso.onView(withId(R.id.etxt_password))
                .check(matches(isEnabled()));
    }

}