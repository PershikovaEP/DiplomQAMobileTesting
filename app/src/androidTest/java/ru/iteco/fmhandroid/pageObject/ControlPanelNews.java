package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class ControlPanelNews {
    private final ViewInteraction buttonAddNews = onView(
            allOf(withId(R.id.add_news_image_view)));

    public void addNews() {
        buttonAddNews.check(matches(isDisplayed()));
        buttonAddNews.perform(click());
    }
}
