package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class CreateClaims {
    private final ViewInteraction title = onView(withId(R.id.title_edit_text));
    private final ViewInteraction executor = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    private final ViewInteraction date = onView(withId(R.id.date_in_plan_text_input_edit_text));
    private final ViewInteraction time = onView(withId(R.id.time_in_plan_text_input_edit_text));
    private final ViewInteraction description = onView(withId(R.id.description_edit_text));
    private final ViewInteraction save = onView(withId(R.id.save_button));
    private final ViewInteraction cancel = onView(withId(R.id.cancel_button));

    private final ViewInteraction textToScreen = onView(withId(R.id.custom_app_bar_title_text_view));
    private final ViewInteraction buttonOk = onView(withId(android.R.id.button1));

    public ViewInteraction getTextToScreen() {
        return textToScreen;
    }

    public void addTitle(String text) {
        title.check(matches(isDisplayed()));
        title.perform(replaceText(text), closeSoftKeyboard());
    }

    public void addExecutor(String text) {
        executor.check(matches(isDisplayed()));
        executor.perform(replaceText(text), closeSoftKeyboard());
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
        scrollTo();
        save.check(matches(isDisplayed()));
        save.perform(scrollTo()).perform(click());
    }

    public void pressOk() {
        buttonOk.check(matches(isDisplayed()));
        buttonOk.perform(click());
    }

    public void pressCancel() {
        closeSoftKeyboard();
        cancel.check(matches(isDisplayed()));
        cancel.perform(scrollTo(), click());
        pressOk();
    }

    public void createClaims(String title, String executor, String date, String time, String description) {
        addTitle(title);
        addExecutor(executor);
        addDate(date);
        addTime(time);
        addDescription(description);
        pressSave();
    }
}
