package com.example.testingfundamentals;

import android.support.test.rule.ActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

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
    public void clickFloatingActionButton_opensDetailsActivity() throws Exception {
        onView(withId(R.id.fab)).perform(click());

        onView(withId(R.id.add_text)).check(matches(isDisplayed()));
    }

}
