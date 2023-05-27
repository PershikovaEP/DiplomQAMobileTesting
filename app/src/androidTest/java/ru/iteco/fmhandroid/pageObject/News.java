package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class News {
    private final ViewInteraction buttonControlPanelNews = onView(withId(R.id.edit_news_material_button));


    public void switchControlPanelNews() {
        buttonControlPanelNews.check(matches(isDisplayed()));
        buttonControlPanelNews.perform(click());
    }


}
