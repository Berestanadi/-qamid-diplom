package ru.iteco.fmhandroid.ui.test;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

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
import ru.iteco.fmhandroid.ui.screen.ClaimsScreen;
import ru.iteco.fmhandroid.ui.screen.MainScreen;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.ClaimsScreenSteps;
import ru.iteco.fmhandroid.ui.steps.MainScreenSteps;
import ru.iteco.fmhandroid.ui.steps.NewsScreenSteps;

@RunWith(AllureAndroidJUnit4.class)
public class ClaimsScreenTest {

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
    @DisplayName("Фильтрация заявок")
    public void filterClaimsBasedOn(){
        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.clickAllClaimsButton();
        ClaimsScreenSteps.clickFilterClaims();
        ClaimsScreenSteps.validateOpenCheckbox(true);
        ClaimsScreenSteps.clickOpenCheckbox();
        ClaimsScreenSteps.clickOKFilterButton();
        MainScreenSteps.claimList();
    }

    @Test
    @DisplayName("Добавить заявку")
    public void addNewClaim(){
        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.createNewClaim();
        ClaimsScreenSteps.isCreatingClaimWindow();
        ClaimsScreenSteps.enterClaimTitle("Заявка 3");
        ClaimsScreenSteps.enterExecutorOfClaim();
        ClaimsScreenSteps.enterDateOfClaimPublication("30.04.2023");
        ClaimsScreenSteps.enterTimeOfClaimPublication("14:50");
        ClaimsScreenSteps.enterClaimDescription("Проверить 1 палату");
        ClaimsScreen.saveOfClaimButton.perform(click());
        MainScreenSteps.waitForMainScreen();
        MainScreenSteps.isMainScreen();

    }
}
