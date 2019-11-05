package com.example.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class AddActivityTest {
    @Rule
    public ActivityTestRule<AddActivity> mActivityRule = new ActivityTestRule<>(AddActivity.class);

    @Test
    public void isNameInputFieldEnabled() {
        Espresso.onView(withId(R.id.etxt_name_phone_user))
                .check(matches(isEnabled()));
    }

    @Test
    public void isNumberInputFieldEnabled() {
        Espresso.onView(withId(R.id.etxt_number_phone_user))
                .check(matches(isEnabled()));
    }

    @Test
    public void isAddButtonClickable() {
        Espresso.onView(withId(R.id.btn_add_phone_user))
                .check(matches(isClickable()));
    }
}
