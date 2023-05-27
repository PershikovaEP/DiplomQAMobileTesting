package ru.iteco.fmhandroid;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.utils.Utils.waitDisplayed;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import ru.iteco.fmhandroid.pageObject.AppBar;
import ru.iteco.fmhandroid.pageObject.Claims;
import ru.iteco.fmhandroid.pageObject.ControlPanelNews;
import ru.iteco.fmhandroid.pageObject.CreateNews;
import ru.iteco.fmhandroid.pageObject.EditNews;
import ru.iteco.fmhandroid.pageObject.Main;
import ru.iteco.fmhandroid.pageObject.News;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.pageObject.Authorization;
import ru.iteco.fmhandroid.ui.utils.Utils;

;
@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AppTest {

    Authorization authorization = new Authorization();
    Main main = new Main();
    News news = new News();
    ControlPanelNews controlPanelNews = new ControlPanelNews();
    Claims claims = new Claims();
    AppBar appBar = new AppBar();
    CreateNews createNews = new CreateNews();
    Utils utils = new Utils();
    EditNews editNews = new EditNews();



    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        onView(isRoot()).perform(waitDisplayed(authorization.getInputLogin(), 5000));
    }

    @Epic("Авторизация")
    @Feature("Успешная авторизация в приложении и выход из профиля")
    @Description("После авторизации с валидными данными должен показаться главный экран, после выхода из профиля - экран авторизации")
    @Test
    public void shouldLogInAndShowTheMainScreenAndLogOut() {
        authorization.inputLogin("login2");
        authorization.inputPassword("password2");
        authorization.pressButton();

        onView(isRoot()).perform(waitDisplayed(appBar.getPressProfile(), 6000));
        main.getTextViewMainNews().check(matches(isDisplayed()));
        main.getTextViewMainNews().check(matches(withText("Новости")));

        appBar.pressOut();
    }


    @Epic("Авторизация")
    @Feature("Авторизация невалидного пользователя при использовании регистра")
    @Description("После авторизации с использованием регистра должен остаться на экране авторизации")
    @Test
    public void shouldRemainOnTheMainScreenWhenEnteringDataUsingCase() {
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
        authorization.pressButton();

        authorization.getTextViewAuth().check(matches(isDisplayed()));
        authorization.getTextViewAuth().check(matches(withText("Авторизация")));
    }

    @Epic("Новости")
    @Feature("Успешное создание новости")
    @Description("Должна создаться новость на в панели управления новостей")
    @Test
    public void shouldLog1InAndShowTheMainScreenAndLogOut() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        createNews.addCategory("День рождения");
        String text = "День Рождения Маши";
        createNews.addTitle(text);
        createNews.addDate(utils.currentDate());
        createNews.addTime("12.00");
        createNews.addDescription("тест");
        createNews.pressSave();

        ViewInteraction textTitle = onView(withText(text));
        textTitle.check(matches(isDisplayed()));

        appBar.pressOut();
    }

    @Epic("Новости")
    @Feature("Создание новости с датой публикации в прошлом")
    @Description("При создании новости в прошлом должен остаться на экране создания новости")
    @Test
    public void shouldStayOnNewsCreationScreenWhenCreatingNewsInPast() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        createNews.addCategory("День рождения");
        String text = "Прошлое";
        createNews.addTitle(text);
        createNews.addDate("01.01.2020");
        createNews.addTime("12.00");
        createNews.addDescription("тест");
        createNews.pressSave();

        createNews.getTextToScreen().check(matches(isDisplayed()));
        createNews.getTextToScreen().check(matches(withText("Создание")));

        createNews.pressCancel();
        appBar.pressOut();
    }

    @Epic("Новости")
    @Feature("Создание новости с датой публикации спустя 5 лет")
    @Description("При создании новости спустя 5 лет должен остаться на экране создания новости")
    @Test
    public void shouldStayOnNewsCreationScreenWhenCreatingANewsStoryAfter5Years() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        createNews.addCategory("День рождения");
        String text = "Будущее";
        createNews.addTitle(text);
        createNews.addDate(utils.dateMore5Year());
        createNews.addTime("12.00");
        createNews.addDescription("тест");
        createNews.pressSave();

        createNews.getTextToScreen().check(matches(isDisplayed()));
        createNews.getTextToScreen().check(matches(withText("Создание")));

        createNews.pressCancel();
        appBar.pressOut();
    }

    @Epic("Новости")
    @Feature("Создание новости с пустыми полями")
    @Description("При создании новости c пустыми полями должен остаться на экране создания новости")
    @Test
    public void shouldStayOnNewsCreationScreenWhenCreatingNewsWithEmptyFields() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        createNews.pressSave();

        createNews.getTextToScreen().check(matches(isDisplayed()));
        createNews.getTextToScreen().check(matches(withText("Создание")));

        createNews.pressCancel();
        appBar.pressOut();
    }

    @Epic("Новости")
    @Feature("Редактирование новости")
    @Description("После редактирования новость должна отредактироваться")
    @Test
    public void shouldEditTheNewsAfterEditing() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        String title = "Создание";
        createNews.createNews("День рождения", title, utils.currentDate(), "12.00", "тест" );
        ViewInteraction textTitle = onView(withText(title));
        textTitle.check(matches(isDisplayed()));

        editNews.editCategory("Объявление");
        String editTitle = "Редактирование";
        editNews.editTitle(editTitle);
        editNews.editDate(utils.dateMore1Month());
        editNews.editTime("16.00");
        editNews.editDescription("тест редактирование");

        ViewInteraction editTextTitle = onView(withText(editTitle));
        textTitle.check(matches(isDisplayed()));

        appBar.pressOut();
    }

    @Epic("Новости")
    @Feature("Удаление новости")
    @Description("После удаления новости не должно быть в панели управления новостей")
    @Test
    public void shouldNewsBeDeletedAfterDeletion() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        String title = "Удаление";
        createNews.createNews("День рождения", title, utils.currentDate(), "12.00", "тест" );
        ViewInteraction textTitle = onView(withText(title));
        textTitle.check(matches(isDisplayed()));

        controlPanelNews.deleteNews();
        textTitle.check(doesNotExist());

        appBar.pressOut();
    }


}

