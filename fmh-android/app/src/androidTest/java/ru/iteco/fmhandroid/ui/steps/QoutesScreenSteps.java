package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import ru.iteco.fmhandroid.ui.screen.QoutesScreen;

public class QoutesScreenSteps {
    public static void displayedElementsOfQoutesScreen() {
        QoutesScreen.missionTitle.check(matches(isDisplayed()));
        QoutesScreen.titleOfQouteItem.check(matches(isDisplayed()));
        QoutesScreen.listQoute.check(matches(isDisplayed()));
    }

    public static void expandFirstQoute(){
        QoutesScreen.titleOfQouteItem.perform(click());
        QoutesScreen.descriptionOfQouteItem.check(matches(isDisplayed()));
    }

    public static void rollUpFirstQoute(){
        QoutesScreen.titleOfQouteItem.perform(click());
        QoutesScreen.descriptionOfQouteItem.check(matches(not(isDisplayed())));
    }
}
