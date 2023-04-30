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
import ru.iteco.fmhandroid.ui.screen.NewsScreen;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NewsScreenSteps;


@RunWith(AllureAndroidJUnit4.class)
public class NewsScreenTest {
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
    @DisplayName("Переход на экран Панель управления Новостей")
    public void goToControlPanel() {
        MainScreenSteps.goToScreen("News");
        NewsScreenSteps.isNewsScreen();
        NewsScreenSteps.openControlPanelOfNews();
        NewsScreenSteps.isControlPanelNews();
    }

    @Test
    @DisplayName("Добавить новость с экрана Панель управления")
    public void addNewsFromControlPanel () {
        MainScreenSteps.clickAllNewsButton();
        NewsScreenSteps.openControlPanelOfNews();
        NewsScreenSteps.clickAddNewsFromControlPanel();
        NewsScreenSteps.chooseCategory();
        NewsScreenSteps.enterNewsTitle("Новостная сводка");
        NewsScreenSteps.enterDateOfNewsPublication("29.04.2023");
        NewsScreenSteps.enterTimeOfNewsPublication("17:07");
        NewsScreenSteps.enterNewsDescription("Все новости на сегодня");
        NewsScreen.saveButton.perform(click());
        NewsScreenSteps.findDisplayedNews("Новостная сводка");
    }
}
