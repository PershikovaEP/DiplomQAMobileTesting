package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class News {

    private final int buttonControlPanelNews = R.id.edit_news_material_button;

    public int getButtonControlPanelNews() {
        return buttonControlPanelNews;
    }


    @Step("Нажатие на кнопку Панель управления новостями")
    public void switchControlPanelNews() {
        onView(withId(buttonControlPanelNews)).check(matches(isDisplayed()));
        onView(withId(buttonControlPanelNews)).perform(click());
    }


}
