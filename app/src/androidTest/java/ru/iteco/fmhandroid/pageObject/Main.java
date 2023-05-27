package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

public class Main {
    private final ViewInteraction textViewMainNews = onView(withText("Новости"));

    public ViewInteraction getTextViewMainNews() {
        return textViewMainNews;
    }
}
