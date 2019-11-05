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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterActivityTest {

    @Rule
    public ActivityTestRule<RegisterActivity> mActivityRule = new ActivityTestRule<>(RegisterActivity.class);

    @Test
    public void isRegisterButtonEnabled() {
        Espresso.onView(withId(R.id.registerButton))
                .check(matches(isClickable()));
    }

    @Test
    public void isUserInputFieldEnabled() {
        Espresso.onView(withId(R.id.etxt_username_register))
                .check(matches(isEnabled()));
    }

    @Test
    public void isPasswordInputFieldEnabled() {
        Espresso.onView(withId(R.id.etxt_password_register))
                .check(matches(isEnabled()));
    }

    @Test
    public void isSecondPasswordInputFieldEnabled() {
        Espresso.onView(withId(R.id.etxt_password2_register))
                .check(matches(isEnabled()));
    }

    @Test
    public void isLoginTextDisplayed() {
        Espresso.onView(withId(R.id.txt_login))
                .check(matches(isDisplayed()));
    }

}