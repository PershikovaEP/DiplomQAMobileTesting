package ru.iteco.fmhandroid;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.Utils.Utils.waitDisplayed;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Severity;
import io.qameta.allure.kotlin.SeverityLevel;
import ru.iteco.fmhandroid.Utils.Utils;

import ru.iteco.fmhandroid.pageObject.AppBar;
import ru.iteco.fmhandroid.pageObject.Authorization;

import ru.iteco.fmhandroid.pageObject.ControlPanelNews;

import ru.iteco.fmhandroid.pageObject.CreateNews;

import ru.iteco.fmhandroid.pageObject.EditNews;

import ru.iteco.fmhandroid.pageObject.Main;
import ru.iteco.fmhandroid.pageObject.News;

import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsTest {
    Authorization authorization = new Authorization();

    News news = new News();
    ControlPanelNews controlPanelNews = new ControlPanelNews();

    AppBar appBar = new AppBar();
    CreateNews createNews = new CreateNews();
    Utils utils = new Utils();
    EditNews editNews = new EditNews();
    Main main = new Main();

    String category = "День рождения";
    String lastDate = "01.01.2020";
    String description = "тест";
    String time = "12.00";
    String editTime = "16.00";
    String editDescription = "тест редактирование";
    String editCategory = "Объявление";


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        onView(isRoot()).perform(waitDisplayed(appBar.getAppBarFragmentMain(), 5000));
        if (main.isDisplayedButtonProfile()) {
            appBar.pressOut();
        }
    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Epic("Новости")
    @Feature("Успешное создание новости")
    @Description("Должна создаться новость c указанной темой в панели управления новостей")
    @Test
    public void shouldLog1InAndShowTheMainScreenAndLogOut() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        createNews.addCategory(category);
        String text = "Создание новости";
        createNews.addTitle(text);
        createNews.addDate(utils.currentDate());
        createNews.addTime(time);
        createNews.addDescription(description);

        onView(isRoot()).perform(waitDisplayed(createNews.getButtonSave(), 5000));
        createNews.pressSave();

        controlPanelNews.searchNewsAndCheckIsDisplayed(text);

    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Epic("Новости")
    @Feature("Создание новости с датой публикации в прошлом")
    @Description("При создании новости в прошлом должен остаться на экране создания новости")
    @Test
    public void shouldStayOnNewsCreationScreenWhenCreatingNewsInPast() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        createNews.addCategory(category);
        String text = "Создание новости в прошлом";
        createNews.addTitle(text);
        createNews.addDate(lastDate);
        createNews.addTime(time);
        createNews.addDescription(description);
        onView(isRoot()).perform(waitDisplayed(createNews.getButtonSave(), 5000));
        createNews.pressSave();

        createNews.getTextToScreen().check(matches(isDisplayed()));
        createNews.getTextToScreen().check(matches(withText("Создание")));

        createNews.pressCancel();

    }

    @Severity(value = SeverityLevel.NORMAL)
    @Epic("Новости")
    @Feature("Создание новости с датой публикации спустя 5 лет")
    @Description("При создании новости спустя 5 лет должен остаться на экране создания новости")
    @Test
    public void shouldStayOnNewsCreationScreenWhenCreatingANewsStoryAfter5Years() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        createNews.addCategory(category);
        String text = "Создание новости в будущем";
        createNews.addTitle(text);
        createNews.addDate(utils.dateMore5Year());
        createNews.addTime(time);
        createNews.addDescription(description);
        onView(isRoot()).perform(waitDisplayed(createNews.getButtonSave(), 5000));
        createNews.pressSave();

        createNews.getTextToScreen().check(matches(isDisplayed()));
        createNews.getTextToScreen().check(matches(withText("Создание")));

        createNews.pressCancel();

    }

    @Severity(value = SeverityLevel.CRITICAL)
    @Epic("Новости")
    @Feature("Создание новости с пустыми полями")
    @Description("При создании новости c пустыми полями должен остаться на экране создания новости")
    @Test
    public void shouldStayOnNewsCreationScreenWhenCreatingNewsWithEmptyFields() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        onView(isRoot()).perform(waitDisplayed(createNews.getButtonSave(), 5000));
        createNews.pressSave();

        createNews.getTextToScreen().check(matches(isDisplayed()));
        createNews.getTextToScreen().check(matches(withText("Создание")));

        createNews.pressCancel();

    }

    @Severity(value = SeverityLevel.NORMAL)
    @Epic("Новости")
    @Feature("Редактирование новости")
    @Description("После редактирования новость должна отредактироваться, проверяем изменение темы")
    @Test
    public void shouldEditTheNewsAfterEditing() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        String title = "Создание";
        createNews.createNews(category, title, utils.currentDate(), time, description );
        ViewInteraction textTitle = onView(withText(title));
        textTitle.check(matches(isDisplayed()));

        controlPanelNews.pressEditPanelNews();
        editNews.editCategory(editCategory);
        String editTitle = "Редактирование";
        editNews.editTitle(editTitle);
        editNews.editDate(utils.dateMore1Month());
        editNews.editTime(editTime);
        editNews.editDescription(editDescription);
        onView(isRoot()).perform(waitDisplayed(createNews.getButtonSave(), 5000));
        editNews.pressSave();

        ViewInteraction editTextTitle = onView(withText(editTitle));
        editTextTitle.check(matches(isDisplayed()));

    }

    @Severity(value = SeverityLevel.NORMAL)
    @Epic("Новости")
    @Feature("Удаление новости")
    @Description("После удаления новости c указанной темой не должно быть в панели управления новостей")
    @Test
    public void shouldNewsBeDeletedAfterDeletion() {
        authorization.loginSuccessful();
        appBar.switchToNews();
        news.switchControlPanelNews();
        controlPanelNews.addNews();
        String title = "Удаление новости";
        createNews.createNews(category, title, utils.currentDate(), time, description);
        ViewInteraction textTitle = onView(withText(title));
        textTitle.check(matches(isDisplayed()));

        controlPanelNews.deleteNews();
        textTitle.check(doesNotExist());

    }
}
