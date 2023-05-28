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

public class EditClaims {

    private final ViewInteraction editTitle = onView(withId(R.id.title_edit_text));
    private final ViewInteraction editExecutor = onView(withId(R.id.executor_drop_menu_auto_complete_text_view));
    private final ViewInteraction editDate = onView(withId(R.id.date_in_plan_text_input_edit_text));
    private final ViewInteraction editTime = onView(withId(R.id.time_in_plan_text_input_edit_text));
    private final ViewInteraction editDescription = onView(withId(R.id.description_edit_text));
    private final ViewInteraction save = onView(withId(R.id.save_button));

    public void editTitle(String text) {
        editTitle.check(matches(isDisplayed()));
        editTitle.perform(replaceText(text), closeSoftKeyboard());
    }

    public void editExecutor(String text) {
        editExecutor.check(matches(isDisplayed()));
        editExecutor.perform(replaceText(text), closeSoftKeyboard());
    }

    public void editDate(String text) {
        editDate.check(matches(isDisplayed()));
        editDate.perform(replaceText(text), closeSoftKeyboard());
    }

    public void editTime(String text) {
        editTime.check(matches(isDisplayed()));
        editTime.perform(replaceText(text), closeSoftKeyboard());

    }

    public void editDescription(String text) {
        editDescription.check(matches(isDisplayed()));
        editDescription.perform(replaceText(text), closeSoftKeyboard());
    }

    public void pressSave() {
        closeSoftKeyboard();
        save.check(matches(isDisplayed()));
        save.perform(scrollTo(), click());
    }

}
