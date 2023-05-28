package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AppBar {

    private final int pressProfile = R.id.authorization_image_button;

    public int getPressProfile() {
        return pressProfile;
    }
    private final ViewInteraction mainMenuNews = onView(
            allOf(withId(android.R.id.title), withText("Новости")));

    private final ViewInteraction mainMenuClaims = onView(
            allOf(withId(android.R.id.title), withText("Заявки")));

    private final ViewInteraction mainMenuAboutApp = onView(
            allOf(withId(android.R.id.title), withText("О приложении")));

    private final ViewInteraction mainMenuMain = onView(
            allOf(withId(android.R.id.title), withText("Главная")));

    private final ViewInteraction out = onView(withText("Выйти"));
    private final ViewInteraction buttonMainMenu = onView(withId(R.id.main_menu_image_button));

    private final ViewInteraction buttonOurMission = onView(withId(R.id.our_mission_image_button));
    public void pressOut() {
        ViewInteraction buttonProfile = onView(withId(pressProfile));
        buttonProfile.check(matches(isDisplayed()));
        buttonProfile.perform(click());

        out.check(matches(isDisplayed()));
        out.perform(click());
    }

    public void switchToNews() {
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());

        mainMenuNews.check(matches(isDisplayed()));
        mainMenuNews.perform(click());
    }

    public void switchToClaims() {
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());

        mainMenuClaims.check(matches(isDisplayed()));
        mainMenuClaims.perform(click());
    }

    public void switchToAboutApp() {
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());

        mainMenuAboutApp.check(matches(isDisplayed()));
        mainMenuAboutApp.perform(click());
    }

    public void switchToMain() {
        buttonMainMenu.check(matches(isDisplayed()));
        buttonMainMenu.perform(click());

        mainMenuMain.check(matches(isDisplayed()));
        mainMenuMain.perform(click());
    }

    public void switchToOurMission() {
        buttonOurMission.check(matches(isDisplayed()));
        buttonOurMission.perform(click());
    }
}
