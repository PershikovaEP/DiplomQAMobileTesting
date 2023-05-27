package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.utils.Utils.waitDisplayed;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;


public class Authorization {
    Main main = new Main();
    AppBar appBar = new AppBar();

    private final int inputLogin = R.id.login_text_input_layout;
    private final int inputPassword = R.id.password_text_input_layout;
    private final ViewInteraction materialButton = onView(withId(R.id.enter_button));

    private final ViewInteraction textViewAuth = onView(withText("Авторизация"));

    public ViewInteraction getTextViewAuth() {
        return textViewAuth;
    }

    public int getInputLogin() {
        return inputLogin;
    }

    public void inputLogin(String login) {
        ViewInteraction textInputEditText = onView(allOf(
                isDescendantOfA(withId(inputLogin)),
                isAssignableFrom(EditText.class)));
        textInputEditText.check(matches(isDisplayed()));
        textInputEditText.perform(replaceText(login), closeSoftKeyboard());

    }

    public void inputPassword(String password) {
        ViewInteraction textInputEditText3 = onView(allOf(
                isDescendantOfA(withId(inputPassword)),
                isAssignableFrom(EditText.class)));;
        textInputEditText3.check(matches(isDisplayed()));
        textInputEditText3.perform(replaceText(password), closeSoftKeyboard());
    }

    public void pressButton() {
        materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());
    }

    public void loginSuccessful() {
        inputLogin("login2");
        inputPassword("password2");
        pressButton();
        onView(isRoot()).perform(waitDisplayed(appBar.getPressProfile(), 6000));
        main.getTextViewMainNews().check(matches(isDisplayed()));
        main.getTextViewMainNews().check(matches(withText("Новости")));
    }

}
