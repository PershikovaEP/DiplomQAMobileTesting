package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;


public class Authorization {

    private final int login = R.id.login_text_input_layout;
    private final int password = R.id.password_text_input_layout;

    private final ViewInteraction textViewAuth = onView(withText("Авторизация"));
    public int getLogin() {
        return login;
    }
    public int getPassword() {
        return password;
    }


    public ViewInteraction getTextViewAuth() {
        return textViewAuth;
    }
    public void inputLogin(String login) {

        ViewInteraction textInputEditText = onView(withId(getLogin()));
        textInputEditText.check(matches(isDisplayed()));
        textInputEditText.perform(typeText(login));
    }

    public void inputPassword(String password) {
        ViewInteraction textInputEditText3 = onView(withId(getPassword()));
        textInputEditText3.check(matches(isDisplayed()));
        textInputEditText3.perform(typeText(password));
    }

    public void pressButton() {
        ViewInteraction materialButton = onView(withId(R.id.enter_button));
        materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());
    }

    public void loginSuccessful() {
        inputLogin("login2");
        inputPassword("password2");
        pressButton();
        getTextViewAuth().check(matches(isDisplayed()));
        getTextViewAuth().check(matches(withText("Авторизация")));
    }
}
