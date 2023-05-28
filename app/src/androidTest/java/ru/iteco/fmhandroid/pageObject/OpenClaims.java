package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OpenClaims {

    private final ViewInteraction buttonEdit = onView(withId(R.id.edit_processing_image_button));
    private final ViewInteraction buttonStatus = onView(withId(R.id.status_processing_image_button));
    private final ViewInteraction textStatus = onView(withId(R.id.status_label_text_view));
    private final ViewInteraction addComment = onView(withId(R.id.editText));
    private final ViewInteraction buttonOk = onView(withId(android.R.id.button1));
    private final ViewInteraction textComment = onView(withId(R.id.comment_description_text_view));
    private final ViewInteraction statusCompleted = onView(withText("Исполнить"));
    private final ViewInteraction statusCanceled = onView(withText("Отменить"));

    private final ViewInteraction textTitle = onView(withId(R.id.title_text_view));
    public ViewInteraction getTextStatus() {
        return textStatus;
    }

    public ViewInteraction getTextComment() {
        return textComment;
    }

    public ViewInteraction getStatusCompleted() {
        return statusCompleted;
    }

    public ViewInteraction getStatusCanceled() {
        return statusCanceled;
    }

    public ViewInteraction getTextTitle() {
        return textTitle;
    }

    public void pressEditClaims() {
        buttonEdit.check(matches(isDisplayed()));
        buttonEdit.perform(click());
    }

    public void pressStatusClaims() {
        buttonStatus.check(matches(isDisplayed()));
        buttonStatus.perform(click());
    }



    public void addComment(String text) {
        addComment.check(matches(isDisplayed()));
        addComment.perform(replaceText(text), closeSoftKeyboard());
    }

    public void pressOk() {
        buttonOk.check(matches(isDisplayed()));
        buttonOk.perform(click());
    }


}
