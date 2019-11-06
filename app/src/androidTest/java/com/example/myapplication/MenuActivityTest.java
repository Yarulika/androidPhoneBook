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
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MenuActivityTest {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityRule = new ActivityTestRule<>(MenuActivity.class);

    @Test
    public void isAddButtonClickable() {
        Espresso.onView(withId(R.id.btn_add))
                .check(matches(isClickable()));
    }

    @Test
    public void isDeleteButtonClickable() {
        Espresso.onView(withId(R.id.btn_delete))
                .check(matches(isClickable()));
    }

    @Test
    public void isUpdateButtonClickable() {
        Espresso.onView(withId(R.id.btn_update))
                .check(matches(isClickable()));
    }
}