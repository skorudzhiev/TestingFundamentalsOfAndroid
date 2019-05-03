package com.example.testingfundamentals;

import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.AllOf.allOf;

public class InstrumentationTest {

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     *
     * <p>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void openDetailsActivity_MatchingTypedTextOnScreen() throws Exception {
        String testNote = "Espresso";

        onView(withId(R.id.fab)).perform(click());

        onView(withId(R.id.add_text)).check(matches(isDisplayed()));

        // Add a text for the note
        onView(withId(R.id.add_text)).perform(typeText(testNote), closeSoftKeyboard());

        // Save the note
        onView(withId(R.id.save_text)).perform(click());

        // Should be used to validate that the typed above note is present on the Screen
        onData(allOf(is(instanceOf(Map.class)), hasEntry(equalTo("Espresso"), is("item: 1"))));

        // Verify note is displayed on Screen
        onView(withText(testNote)).check(matches(isDisplayed()));


    }

}
