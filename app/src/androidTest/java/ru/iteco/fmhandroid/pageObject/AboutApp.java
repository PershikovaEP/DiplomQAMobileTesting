package ru.iteco.fmhandroid.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutApp {

    private final ViewInteraction privacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
    private final ViewInteraction termsOfUse = onView(withId(R.id.about_terms_of_use_value_text_view));

    private final ViewInteraction buttonBack = onView(withId(R.id.about_back_image_button));

    public ViewInteraction getPrivacyPolicy() {
        return privacyPolicy;
    }

    public ViewInteraction getTermsOfUse() {
        return termsOfUse;
    }

    public ViewInteraction getButtonBack() {
        return buttonBack;
    }

}


