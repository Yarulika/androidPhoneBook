package com.example.myapplication;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

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

    @Rule
    public ActivityTestRule<UpdateActivity> mActivityRule = new ActivityTestRule<>(UpdateActivity.class);


    @Test
    public void testUpdateSequence() {

        // check if the input field for contact name is enabled
        isContactInputEnabled();

        // input field for contact number is not displayed
        isNumberInputHidden();

        // checks if the button label is "Find"
        isButtonLabel_Find();

        // types in the name in the field
        Espresso.onView(withId(R.id.etxt_contact_name))
                .perform(typeText(contact_name));

        // clicks the find button
        Espresso.onView(withId(R.id.updateButton))
                .perform(click());

        // if contact exits button label changes to "Update"
        isButtonLabel_Update();

        // And the input field for contact name is disabled
        isContactInputDisabled();

        // input field for contact number is displayed
        isNumberInputDisplayed();
    }


    private void isContactInputEnabled() {
        Espresso.onView(withId(R.id.etxt_contact_name))
                .check(matches(isEnabled()));
    }


    private void isContactInputDisabled() {
        Espresso.onView(withId(R.id.etxt_contact_name))
                .check(matches(not(isEnabled())));
    }


    private void isButtonLabel_Find() {
        Espresso.onView(withId(R.id.updateButton))
                .check(matches(withText("Find")));
    }


    private void isButtonLabel_Update() {
        Espresso.onView(withId(R.id.updateButton))
                .check(matches(withText("Update")));
    }


    private void isNumberInputHidden() {
        Espresso.onView(withId(R.id.etxt_contact_number))
                .check(matches(not(isDisplayed())));
    }


    private void isNumberInputDisplayed() {
        Espresso.onView(withId(R.id.etxt_contact_number))
                .check(matches(isDisplayed()));
    }

}
