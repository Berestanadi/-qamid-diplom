package ru.iteco.fmhandroid.ui.test;


import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static ru.iteco.fmhandroid.ui.steps.MainScreenSteps.waitForMainScreen;

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
import ru.iteco.fmhandroid.ui.screen.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;

@RunWith(AllureAndroidJUnit4.class)

public class AuthorizationTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

    @Before
    public void logout() {
        SystemClock.sleep(5000);
        try {
            AuthorizationSteps.isAuthorizationScreen();
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            AuthorizationSteps.logOut();
        }
    }

    @Test
    @DisplayName("Вход с невалидным логином")
    public void signInWithWrongLogin(){

        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("log");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorWrongLoginOrPassword();
    }

    @Test
    @DisplayName("Вход с пустым полем пароля")
    public void signInWithEmptyPasswordField(){

        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("");
        AuthorizationSteps.clickSignIn();
        AuthorizationSteps.popUpErrorEmptyField();
    }

    @Test
    @DisplayName("Вход с валидными данными")
    public void signInSucces() {

        AuthorizationSteps.isAuthorizationScreen();
        AuthorizationSteps.clickLoginField("login2");
        AuthorizationSteps.clickPasswordField("password2");
        AuthorizationSteps.clickSignIn();

        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.isMainScreen();

        AuthorizationSteps.logOut();
    }

}
