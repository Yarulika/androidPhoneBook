package com.example.myapplication;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class DeleteContactActivityTest {
    @Rule
    public ActivityTestRule<DeleteContactActivity> mActivityRule = new ActivityTestRule<>(DeleteContactActivity.class);

    @Test
    public void isDeleteButtonClickable(){
        Espresso.onView(withId(R.id.deleteButton))
                .check(matches(isClickable()));
    }

    @Test
    public void isUserInputFieldEnabled(){
        Espresso.onView(withId(R.id.etxt_userToDelete))
                .check(matches(isEnabled()));
    }

}
