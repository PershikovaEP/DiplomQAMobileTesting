package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OurMission {

    private final ViewInteraction textScreen = onView(withId(R.id.our_mission_title_text_view));

    public ViewInteraction getTextScreen() {
        return textScreen;
    }
}
