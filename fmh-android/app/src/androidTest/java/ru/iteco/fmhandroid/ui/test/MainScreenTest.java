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
import ru.iteco.fmhandroid.ui.screen.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AboutScreenSteps;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NewsScreenSteps;
import ru.iteco.fmhandroid.ui.steps.QoutesScreenSteps;


@RunWith(AllureAndroidJUnit4.class)
public class MainScreenTest {
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
    @DisplayName("Разворачивание/сворачивание блока новости")
    public void expandAndRollUpNewsBlock() {
        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.rollUpAllNews();
        MainScreenSteps.expandAllNews();
    }

    @Test
    @DisplayName("Переход в блок Новости с главного экрана")
    public void goToNewsScreenFromMain(){
        MainScreenSteps.goToScreen("News");
        NewsScreenSteps.isNewsScreen();
    }

    @Test
    @DisplayName("Свернуть/Развернуть блок Заявки")
    public void expandAndRollUpClaimsBlock(){
        MainScreenSteps.rollUpAllClaims();
        MainScreenSteps.expandAllClaims();
    }

    @Test
    @DisplayName("Переход в блок Заявки через Все заявки")
    public void clickAllClaimsButton(){
        MainScreenSteps.clickAllClaimsButton();
        ClaimsScreenSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("Переход в блок Заявки через бургерное меню")
    public void goToClaimsScreenFromMenu(){
        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.goToScreen("Claims");
        ClaimsScreenSteps.isClaimsScreen();
    }

    @Test
    @DisplayName("Переход в блок О приложении через бургерное меню")
    public void goToAboutScreenFromMenu(){
        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.goToScreen("About");
        AboutScreenSteps.displayedAllElementsOfAboutScreen();
    }

    @Test
    @DisplayName("Переход в блок Цитаты")
    public void goToQoutesScreen(){
        MainScreenSteps.waitForMainScreen();
        MainScreen.quotesButton.perform(click());
        QoutesScreenSteps.displayedElementsOfQoutesScreen();
    }

    @Test
    @DisplayName("Выход из приложения")
    public void logOut(){
        MainScreenSteps.waitForMainScreen();
        AuthorizationSteps.logOut();
    }
}
