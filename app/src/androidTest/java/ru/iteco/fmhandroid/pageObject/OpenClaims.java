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

import io.qameta.allure.kotlin.Step;
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



    @Step("Нажатие на кнопку Редактировать Заявку")
    public void pressEditClaims() {
        buttonEdit.check(matches(isDisplayed()));
        buttonEdit.perform(click());
    }

    @Step("Нажатие на кнопку Статус заявки")
    public void pressStatusClaims() {
        buttonStatus.check(matches(isDisplayed()));
        buttonStatus.perform(click());
    }



    @Step("Ввод в поле комментарий {text}")
    public void addComment(String text) {
        addComment.check(matches(isDisplayed()));
        addComment.perform(replaceText(text), closeSoftKeyboard());
    }

    @Step("Нажатие на кнопку ОК")
    public void pressOk() {
        buttonOk.check(matches(isDisplayed()));
        buttonOk.perform(click());
    }

    @Step("Поиск элемента, содержащего {text}, и проверка его видимости")
    public void searchElementAndCheckIsDisplayed(String text) {
        ViewInteraction textClaims = onView(withText(text));
        textClaims.check(matches(isDisplayed()));
    }

    @Step("Проверка статуса заявки")
    public void statusClaims(String text) {
        textTitle.check(matches(isDisplayed()));
        textTitle.check(matches(withText(text)));
    }


}
