package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class Claims {

    private final int buttonAddClaims = R.id.add_new_claim_material_button;

    public int getButtonAddClaims() {
        return buttonAddClaims;
    }


    @Step("Нажатие на кнопку Добавить новость")
    public void pressAddClaim() {
        onView(withId(buttonAddClaims)).check(matches(isDisplayed()));
        onView(withId(buttonAddClaims)).perform(click());
    }

    @Step("Поиск заявки с темой {text} и переход в нее")
    public void searchClaimsAndSwitch(String text) {
        ViewInteraction textTitle = onView(withText(text));
        textTitle.check(matches(isDisplayed()));
        textTitle.perform(click());
    }

    @Step("Поиск заявки с темой {text} и проверка ее видимости")
    public void searchClaimsAndCheckIsDisplayed(String text) {
        ViewInteraction textTitle = onView(withText(text));
        textTitle.check(matches(isDisplayed()));
    }






}
