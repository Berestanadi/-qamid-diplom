package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.activity.MainHelper.waitId;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screen.MainScreen;
import ru.iteco.fmhandroid.ui.screen.NewsScreen;
import ru.iteco.fmhandroid.ui.screen.QoutesScreen;

public class MainScreenSteps {

    public static void isMainScreen() {
        Allure.step("Проверка, что это экран Главная");
        MainScreen.allNewsButton.check(matches(isDisplayed()));
    }

    public static void waitForMainScreen() {
        onView(isRoot()).perform(waitId(R.id.all_news_text_view, 7000));
    }

    public static void claimList(){
        MainScreen.listClaims.check(matches(isDisplayed()));
    }

    public static void displayedElementsOfApp() {
        Allure.step("Проверка видимости элементов общей панели приложения");
        MainScreen.mainMenu.check(matches(isDisplayed()));
        MainScreen.tradeMark.check(matches(isDisplayed()));
        MainScreen.quotesButton.check(matches(isDisplayed()));
    }

    public static void rollUpAllNews() {
        Allure.step("свернуть блок новости");
        MainScreen.expandAllNews.check(matches(isDisplayed()));
        MainScreen.expandAllNews.perform(click());
        MainScreen.allNewsButton.check(matches(not(isDisplayed())));
    }

    public static void expandAllNews() {
        Allure.step("Развернуть блок новости");
        MainScreen.expandAllNews.check(matches(isDisplayed()));
        MainScreen.expandAllNews.perform(click());
        MainScreen.allNewsButton.check(matches(isDisplayed()));
    }

    public static void rollUpAllClaims() {
        Allure.step("Свернуть блок заявки");
        MainScreen.expandAllClaims.check(matches(isDisplayed()));
        MainScreen.expandAllClaims.perform(click());
        MainScreen.allClaimsButton.check(matches(not(isDisplayed())));
    }

    public static void expandAllClaims() {
        Allure.step("Развернуть блок заявки");
        MainScreen.expandAllClaims.check(matches(isDisplayed()));
        MainScreen.expandAllClaims.perform(click());
        MainScreen.allClaimsButton.check(matches(isDisplayed()));
    }

    public static void expandFirstNews() {
        Allure.step("Развернуть первую новость");
        MainScreen.titleOfFirstNews.perform(click());
        MainScreen.descriptionOfFirstNews.check(matches(isDisplayed()));
    }

    public static void rollUpFirstNews() {
        Allure.step("Свернуть первую новость");
        MainScreen.titleOfFirstNews.perform(click());
        MainScreen.descriptionOfFirstNews.check(matches(not(isDisplayed())));
    }

    public static void expandFirstClaim() {
        Allure.step("Развернуть первую заявку");
        MainScreen.expandFirstClaim.perform(actionOnItemAtPosition(4, click()));
        MainScreen.statusOfClaim.check(matches(isDisplayed()));
    }

    public static void backFromClaim(){
        Allure.step("Выйти из заявки");
        MainScreen.backFromClaim.perform(click());
        MainScreen.allClaimsButton.check(matches(isDisplayed()));
    }

    public static void clickAllNewsButton() {
        Allure.step("Нажать кнопку Все новости");
        MainScreen.allNewsButton.check(matches(isDisplayed()));
        MainScreen.allNewsButton.perform(click());
    }

    public static void clickAllClaimsButton() {
        Allure.step("Нажать кнопку Все заявки");
        MainScreen.allClaimsButton.check(matches(isDisplayed()));
        MainScreen.allClaimsButton.perform(click());
    }

    public static void createNewClaim() {
        Allure.step("Создать новую заявку");
        MainScreen.addNewClaimButton.check(matches(isClickable()));
        MainScreen.addNewClaimButton.perform(click());
    }

    public static void goToScreen(String screen) {
        MainScreen.menuButton.perform(click());
        switch (screen) {
            case ("Main"):
                MainScreen.mainMenu.perform(click());
                break;
            case ("Claims"):
                MainScreen.claimsMenu.perform(click());
                break;
            case ("News"):
                MainScreen.newsMenu.perform(click());
                break;
            case ("About"):
                MainScreen.aboutMenu.perform(click());
                break;
        }
    }
}
