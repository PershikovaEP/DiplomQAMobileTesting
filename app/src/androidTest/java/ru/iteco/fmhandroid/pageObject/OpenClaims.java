package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OpenClaims {

    private final ViewInteraction buttonEdit = onView(withId(R.id.edit_processing_image_button));
    private final ViewInteraction buttonStatus = onView(withId(R.id.status_processing_image_button));

    public void pressEditClaims() {
        buttonEdit.check(matches(isDisplayed()));
        buttonEdit.perform(click());
    }

    public void pressStatusClaims() {
        buttonStatus.check(matches(isDisplayed()));
        buttonStatus.perform(click());
    }


}
