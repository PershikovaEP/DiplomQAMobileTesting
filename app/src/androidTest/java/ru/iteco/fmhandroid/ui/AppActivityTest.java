//package ru.iteco.fmhandroid.ui;
//
//
//import static androidx.test.espresso.Espresso.onData;
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
//import static androidx.test.espresso.action.ViewActions.replaceText;
//import static androidx.test.espresso.action.ViewActions.scrollTo;
//import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
//import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
//import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
//import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
//import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withParent;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//import static org.hamcrest.Matchers.allOf;
//import static org.hamcrest.Matchers.anything;
//import static org.hamcrest.Matchers.is;
//
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.ViewParent;
//
//import androidx.test.espresso.DataInteraction;
//import androidx.test.espresso.ViewInteraction;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.filters.LargeTest;
//
//import org.hamcrest.Description;
//import org.hamcrest.Matcher;
//import org.hamcrest.TypeSafeMatcher;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import ru.iteco.fmhandroid.R;
//
//@LargeTest
//@RunWith(AndroidJUnit4.class)
//public class AppActivityTest {
//
//    @Rule
//    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
//            new ActivityScenarioRule<>(AppActivity.class);
//
////    @Test
//    public void appActivityTest() {
//        ViewInteraction textInputEditText = onView(
//                allOf(childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.login_text_input_layout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());
//
//        ViewInteraction textInputEditText2 = onView(
//                allOf(childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.password_text_input_layout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());
//
//        ViewInteraction materialButton = onView(
//                allOf(withId(R.id.enter_button), withText("�����"), withContentDescription("���������"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.RelativeLayout")),
//                                        1),
//                                2),
//                        isDisplayed()));
//        materialButton.perform(click());
//
//        ViewInteraction appCompatImageButton = onView(
//                allOf(withId(R.id.main_menu_image_button), withContentDescription("������� ����"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                0),
//                        isDisplayed()));
//        appCompatImageButton.perform(click());
//
//        ViewInteraction materialTextView = onView(
//                allOf(withId(android.R.id.title), withText("�������"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        materialTextView.perform(click());
//
//        ViewInteraction recyclerView = onView(
//                allOf(withId(R.id.news_list_recycler_view),
//                        childAtPosition(
//                                withId(R.id.all_news_cards_block_constraint_layout),
//                                0)));
//        recyclerView.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction recyclerView2 = onView(
//                allOf(withId(R.id.news_list_recycler_view),
//                        childAtPosition(
//                                withId(R.id.all_news_cards_block_constraint_layout),
//                                0)));
//        recyclerView2.perform(actionOnItemAtPosition(0, click()));
//
//        ViewInteraction materialButton2 = onView(
//                allOf(withId(R.id.edit_news_material_button),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.container_list_news_include),
//                                        0),
//                                3),
//                        isDisplayed()));
//        materialButton2.perform(click());
//
//        ViewInteraction appCompatImageView = onView(
//                allOf(withId(R.id.edit_news_item_image_view), withContentDescription("������ �������������� �������"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.news_item_material_card_view),
//                                        0),
//                                15),
//                        isDisplayed()));
//        appCompatImageView.perform(click());
//
//        ViewInteraction materialAutoCompleteTextView = onView(
//                allOf(withId(R.id.news_item_category_text_auto_complete_text_view), withText("����� ������"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.news_item_category_text_input_layout),
//                                        0),
//                                1),
//                        isDisplayed()));
//        materialAutoCompleteTextView.perform(click());
//
//        DataInteraction materialTextView2 = onData(anything())
//                .inAdapterView(childAtPosition(
//                        withClassName(is("android.widget.PopupWindow$PopupBackgroundView")),
//                        0))
//                .atPosition(1);
//        materialTextView2.perform(click());
//
//        ViewInteraction materialButton3 = onView(
//                allOf(withId(R.id.save_button), withText("���������"), withContentDescription("���������"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("com.google.android.material.card.MaterialCardView")),
//                                        0),
//                                6)));
//        materialButton3.perform(scrollTo(), click());
//
//        ViewInteraction appCompatImageView2 = onView(
//                allOf(withId(R.id.delete_news_item_image_view), withContentDescription("������ �������� �������"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.news_item_material_card_view),
//                                        0),
//                                14),
//                        isDisplayed()));
//        appCompatImageView2.perform(click());
//
//        ViewInteraction materialButton4 = onView(
//                allOf(withId(android.R.id.button1), withText("OK"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.ScrollView")),
//                                        0),
//                                3)));
//        materialButton4.perform(scrollTo(), click());
//
//        ViewInteraction textView = onView(
//                allOf(withId(R.id.news_item_title_text_view), withText("����������"),
//                        withParent(withParent(withId(R.id.news_item_material_card_view))),
//                        isDisplayed()));
//        textView.check(doesNotExist());
//    }
//
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };
//    }

