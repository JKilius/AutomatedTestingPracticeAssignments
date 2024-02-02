package lt.techin.Login_Orange_Tests;

import lt.techin.Login_Orange_Pages.LoggedInPage;
import lt.techin.Login_Orange_Pages.HomePage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeTest extends BaseTest {
    //Patikrinti prisijungimą. Vartotoją vardą ir prisijungimą paimti iš puslapio. Naudoti Page Object Model.

    HomePage homePage;

    LoggedInPage loggedInPage;


    @Test
    void successfulLoginToAdmin() {
        homePage = new HomePage(driver);
        loggedInPage = new LoggedInPage(driver);

        String userName = homePage.getUserNameFromPage();
        homePage.enterUserName(userName);

        String password = homePage.getPasswordFromPage();
        homePage.enterPassword(password);

        homePage.clickLogin();
        assertFalse(homePage.isAlertMessageVisible());
        loggedInPage.waitUntilFinishLoading();

        assertTrue(loggedInPage.checkIfAdmin());
        assertTrue(loggedInPage.checkIfAdminTabIsActive());


    }

    @Test
    void incorrectUserNameLogin() {
        homePage = new HomePage(driver);

        String incorrectUserName = "blabla";

        homePage.enterUserName(incorrectUserName);

        String password = homePage.getPasswordFromPage();
        homePage.enterPassword(password);

        homePage.clickLogin();

        assertTrue(homePage.isAlertMessageVisible());
    }

    @Test
    void incorrectPasswordLogin() {
        homePage = new HomePage(driver);

        String userName = homePage.getUserNameFromPage();
        homePage.enterUserName(userName);

        String incorrectPassword = "something123";
        homePage.enterPassword(incorrectPassword);

        homePage.clickLogin();

        assertTrue(homePage.isAlertMessageVisible());

    }

    @Test
    void attemptToLoginWithoutAnyCredentials() {
        homePage = new HomePage(driver);

        homePage.clickLogin();

        assertTrue(homePage.isInputRequiredError());
    }

    @Test
    void attemptToLoginWithoutUserName() {
        homePage = new HomePage(driver);

        String password = homePage.getPasswordFromPage();
        homePage.enterPassword(password);

        homePage.clickLogin();

        assertTrue(homePage.isInputRequiredError());
    }

    @Test
    void attemptToLoginWithoutPassword() {
        homePage = new HomePage(driver);

        String userName = homePage.getUserNameFromPage();
        homePage.enterUserName(userName);

        homePage.clickLogin();

        assertTrue(homePage.isInputRequiredError());
    }

    @Test
    void attemptToLogOut(){
        homePage = new HomePage(driver);

        successfulLoginToAdmin();

        homePage.clickLogOut();

        assertTrue(homePage.checkIfLoggedOut());
    }

    //@ParameterizedTest



}
