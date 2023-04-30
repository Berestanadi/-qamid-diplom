package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import java.util.concurrent.Callable;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.screen.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screen.NewsScreen;

public class ClaimsScreenSteps {

    public static void isClaimsScreen(){
        Allure.step("Проверка, что это экран блока Заявки");
        ClaimsScreen.titleOfBlockClaims.check(matches(allOf(withText("Claims"), isDisplayed())));
        ClaimsScreen.addNewClaim.check(matches(isDisplayed()));
    }
    public static void isCreatingClaimWindow(){
        ClaimsScreen.titleOfCreationClaimWindow.check(matches(isDisplayed()));
        ClaimsScreen.subTitleOfCreationClaimWindow.check(matches(isDisplayed()));
    }

    public static void clickFilterClaims(){
        Allure.step("Нажать кнопку фильтрации блока Заявки");
        ClaimsScreen.filterClaimsButton.perform(click());
        ClaimsScreen.titleOfFilterWindow.check(matches(isDisplayed()));
    }

    public static void clickInProgressCheckbox() {
        Allure.step("Нажать чекбокс в процессе");
        ClaimsScreen.inProgressStatus.perform(click());
    }

    public static void clickOpenCheckbox() {
        Allure.step("Нажать чекбокс открыт");
        ClaimsScreen.openStatus.perform(click());
    }

    public static void clickExecutedCheckbox() {
        Allure.step("Нажать чекбокс выполнен");
        ClaimsScreen.executedStatus.perform(click());
    }

    public static void clickCancelledCheckbox() {
        Allure.step("Нажать чекбокс отменен");
        ClaimsScreen.cancelledStatus.perform(click());
    }

    public static void clickCancelFilterButton() {
        Allure.step("Нажать отмена");
        ClaimsScreen.cancelFilterButton.perform(click());
    }

    public static void clickOKFilterButton() {
        Allure.step("Нажать ОК");
        ClaimsScreen.okFilterButton.perform(click());
    }

    public static void validateInProgressCheckbox(boolean checked) {
        Allure.step("Проверка состояния чекбокса в процессе");
        if (checked) {
            ClaimsScreen.inProgressStatus.check(matches(isChecked()));
        } else {
            ClaimsScreen.inProgressStatus.check(matches(isNotChecked()));
        }
    }

    public static void validateOpenCheckbox(boolean checked) {
        Allure.step("Проверка состояния чекбокса открыт");
        if (checked) {
            ClaimsScreen.openStatus.check(matches(isChecked()));
        } else {
            ClaimsScreen.openStatus.check(matches(isNotChecked()));
        }
    }

    public static void validateExecutedCheckbox(boolean checked) {
        Allure.step("Проверить состояние чекбокса выполнен");
        if (checked) {
            ClaimsScreen.executedStatus.check(matches(isChecked()));
        } else {
            ClaimsScreen.executedStatus.check(matches(isNotChecked()));
        }
    }

    public static void validateCancelledCheckbox(boolean checked) {
        Allure.step("Проверить состояние чекбокса отменен");
        if (checked) {
            ClaimsScreen.cancelledStatus.check(matches(isChecked()));
        } else {
            ClaimsScreen.cancelledStatus.check(matches(isNotChecked()));
        }
    }

    public static void enterClaimTitle(String text) {
        Allure.step("Ввести заголовок");
        ClaimsScreen.titleOfNewClaim.perform(replaceText(text), closeSoftKeyboard());
    }

    public static void enterExecutorOfClaim(){
        Allure.step("Выбрать исполнителя");
        ClaimsScreen.executorDropDownMenu.perform(click());
        ClaimsScreen.titleOfNewClaim.perform(click());
    }

    public static void enterDateOfClaimPublication(String text) {
        Allure.step("Ввести дату публикации");
        ClaimsScreen.dateCreationClaim.perform(replaceText(text));
    }

    public static void enterTimeOfClaimPublication(String text) {
        Allure.step("Ввести время");
        ClaimsScreen.timeCreationClaim.perform(replaceText(text));
    }

    public static void enterClaimDescription(String text) {
        Allure.step("Ввести описание");
        ClaimsScreen.descriptionCreationClaim.perform(replaceText(text), closeSoftKeyboard());
    }
}
