package ru.iteco.fmhandroid.ui.test;


import static androidx.test.espresso.action.ViewActions.click;

import android.os.SystemClock;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.screen.AboutScreen;
import ru.iteco.fmhandroid.ui.steps.AboutScreenSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;

@RunWith(AllureAndroidJUnit4.class)
public class AboutScreenTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void login() {
        SystemClock.sleep(7000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (NoMatchingViewException e) {
            return;
        }
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
    }

    @Test
    @DisplayName("Отображение элементов экрана О приложении")
    public void showAllElementsAndGoBackOfAboutScreen(){
        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.goToScreen("About");
        AboutScreenSteps.displayedAllElementsOfAboutScreen();
        AboutScreenSteps.backToPreviousFromAboutScreen();
        MainScreenSteps.isMainScreen();
    }
}
