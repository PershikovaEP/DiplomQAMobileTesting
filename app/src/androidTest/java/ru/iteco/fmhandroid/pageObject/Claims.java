package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class Claims {

    private final ViewInteraction buttonAddClaims = onView(withId(R.id.add_new_claim_material_button));


    public void pressAddClaim() {
        buttonAddClaims.check(matches(isDisplayed()));
        buttonAddClaims.perform(click());
    }






}
