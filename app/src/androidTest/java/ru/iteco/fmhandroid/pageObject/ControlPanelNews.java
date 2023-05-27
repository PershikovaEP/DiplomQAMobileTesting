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
    private final ViewInteraction buttonAddNews = onView(withId(R.id.add_news_image_view));

    private final ViewInteraction buttonEditNews = onView(withId(R.id.edit_news_item_image_view));

    private final ViewInteraction buttonDeleteNews = onView(withId(R.id.delete_news_item_image_view));
    private final ViewInteraction buttonOk = onView(withId(android.R.id.button1));


    public void addNews() {
        buttonAddNews.check(matches(isDisplayed()));
        buttonAddNews.perform(click());
    }

    public void pressEditPanelNews() {
        buttonEditNews.check(matches(isDisplayed()));
        buttonEditNews.perform(click());
    }

    public void deleteNews() {
        buttonDeleteNews.check(matches(isDisplayed()));
        buttonDeleteNews.perform(click());
        buttonOk.check(matches(isDisplayed()));
        buttonOk.perform(click());
    }
}
