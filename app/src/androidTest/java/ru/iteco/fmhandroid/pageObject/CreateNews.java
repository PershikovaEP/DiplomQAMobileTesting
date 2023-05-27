package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class CreateNews {

    private final ViewInteraction category = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
    private final ViewInteraction title = onView(withId(R.id.news_item_title_text_input_edit_text));
    private final ViewInteraction time = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
    private final ViewInteraction date = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
    private final ViewInteraction description = onView(withId(R.id.news_item_description_text_input_edit_text));
    private final ViewInteraction save = onView(withId(R.id.save_button));

    private final ViewInteraction cancel = onView(withId(R.id.cancel_button));
    private final ViewInteraction textToScreen = onView(withId(R.id.custom_app_bar_title_text_view));
    private final ViewInteraction buttonOkAfterCancel = onView(withId(android.R.id.button1));


    public ViewInteraction getTextToScreen() {
        return textToScreen;
    }

    public void addCategory(String text) {
        category.check(matches(isDisplayed()));
        category.perform(replaceText(text), closeSoftKeyboard());
    }

    public void addTitle(String text) {
        title.check(matches(isDisplayed()));
        title.perform(replaceText(text), closeSoftKeyboard());
    }

    public void addDate(String text) {
        date.check(matches(isDisplayed()));
        date.perform(replaceText(text), closeSoftKeyboard());
    }

    public void addTime(String text) {
        time.check(matches(isDisplayed()));
        time.perform(replaceText(text), closeSoftKeyboard());

    }

    public void addDescription(String text) {
        description.check(matches(isDisplayed()));
        description.perform(replaceText(text), closeSoftKeyboard());
    }

    public void pressSave() {
        closeSoftKeyboard();
        save.check(matches(isDisplayed()));
        save.perform(scrollTo(), click());
    }

    public void pressCancel() {
        closeSoftKeyboard();
        cancel.check(matches(isDisplayed()));
        cancel.perform(scrollTo(), click());
        buttonOkAfterCancel.check(matches(isDisplayed()));
        buttonOkAfterCancel.perform(click());
    }

    public void createNews(String category, String title, String date, String time, String description) {
        addCategory(category);
        addTitle(title);
        addDate(date);
        addTime(time);
        addDescription(description);
        pressSave();
    }


}
