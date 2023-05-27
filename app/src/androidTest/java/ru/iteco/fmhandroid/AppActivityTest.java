package ru.iteco.fmhandroid;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.WaitDisplayed.waitDisplayed;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.cert.CertPathChecker;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.pageObject.Main;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.pageObject.Authorization;

;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AppActivityTest {

    Authorization authorization = new Authorization();
    Main main = new Main();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);


    @Epic("Авторизация")
    @Feature("Успешная авторизация в приложении")
    @Description("После авторизации с валидными данными должен показаться главный экран")
    @Test
    public void shouldLogInAndShowTheMainScreen() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("login2");
        authorization.inputPassword("password2");
        authorization.pressButton();

        main.getTextViewMainNews().check(matches(isDisplayed()));
        main.getTextViewMainNews().check(matches(withText("Новости")));
    }


    @Epic("Авторизация")
    @Feature("Авторизация невалидного пользователя при использовании регистра")
    @Description("После авторизации с использованием регистра должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringDataUsingCase() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("LOGIN2");
        authorization.inputPassword("PASSWORD2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature("Авторизация при введении в поле логин символов на кириллице")
    @Description("После авторизации с введением в поле логин символов на кириллице должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInTheLoginFieldCharactersInCyrillic() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("логин2");
        authorization.inputPassword("password2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature("Авторизация при введении в поле логин спецсимволов")
    @Description("После авторизации с введением в поле логин спецсимволов должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInTheLoginFieldSpecialCharacters() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("lOGin #%@`<|&?>*");
        authorization.inputPassword("password2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature("Авторизация при введении в поле логин 1 символ")
    @Description("После авторизации с введением в поле логин 1 символа должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInTheLoginFieldOneCharacter() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("l");
        authorization.inputPassword("password2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature("Авторизация при введении в поле логин 50 символов")
    @Description("После авторизации с введением в поле логин 50 символов должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInTheLoginField50Characters() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("loginloginloginloginloginloginloginloginloginlogin");
        authorization.inputPassword("password2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature(" Авторизация при введении в поле пароль символов на кириллице")
    @Description("После авторизации с введением в поле пароль символов на кириллице должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInThePasswordFieldCharactersInCyrillic() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("login2");
        authorization.inputPassword("пассворд2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature(" Авторизация при введении в поле пароль спецсимволов")
    @Description("После авторизации с введением в поле пароль спецсимволов должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInThePasswordFieldSpecialCharacters() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("login2");
        authorization.inputPassword("p# @%`<|&?>*");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature(" Авторизация при введении в поле пароль 1 символа")
    @Description("После авторизации с введением в поле пароль  1 символа должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInThePasswordField1Character() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("login2");
        authorization.inputPassword("p");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature(" Авторизация при введении в поле пароль 50 символов")
    @Description("После авторизации с введением в поле пароль  50 символов должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringInThePasswordField50Characters() {

        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("login2");
        authorization.inputPassword("p");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature(" Авторизация с пустым логином")
    @Description("После авторизации с пустым логином должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEmptyLogin() {
        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputPassword("password2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature(" Авторизация с пустым паролем")
    @Description("После авторизации с пустым паролем должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEmptyPassword() {
        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.inputLogin("login2");
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Авторизация")
    @Feature(" Авторизация с пустым логином и паролем")
    @Description("После авторизации с пустым логином и паролем должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEmptyLoginAndPassword() {
        onView(isRoot()).perform(waitDisplayed(authorization.getLogin(), 5000));
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }
}

