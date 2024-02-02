package PagesTest;

import Pages.AccountPage;
import Pages.EditAccountInformationPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    HomePage homePage;

    LoginPage loginPage;

    AccountPage accountPage;

    EditAccountInformationPage editAccountInformationPage;

    @Test
    void correctDetailsLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        editAccountInformationPage = new EditAccountInformationPage(driver);
        homePage.clickDropDown();
        homePage.clickLogin();
        loginPage.enterEmail("johnsmith@something.com");
        loginPage.enterPassword("john");
        loginPage.clickLogin();
        accountPage.clickOnEditAccountinformation();


        String expectedName = "John";
        String actualName = editAccountInformationPage.getFirstName();

        String expectedLastName = "Smith";
        String actualLastName = editAccountInformationPage.getLastName();

        String expectedEmail = "johnsmith@something.com";
        String actualEmail = editAccountInformationPage.getEmail();

        assertEquals("My Account Information", driver.getTitle());
        assertEquals(expectedName, actualName, "Wrong UserName. Expected: " + expectedName + ", actual: " + actualName);
        assertEquals(expectedLastName, actualLastName, "Wrong LastName. Expected: " + expectedLastName + " ,actual: " + actualLastName);
        assertEquals(expectedEmail, actualEmail, "Wrong Email. Expected: " + expectedEmail + " , actual: " + actualEmail);


    }

    @Test
    void incorrectDetailsLogin(){

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        editAccountInformationPage = new EditAccountInformationPage(driver);
        homePage.clickDropDown();
        homePage.clickLogin();
        loginPage.enterEmail("johnsmith@something.com");
        loginPage.enterPassword("john");
        loginPage.clickLogin();

        Assertions.assertNotEquals("My Account", driver.getTitle());
        Assertions.assertTrue(driver.findElement(By.cssSelector(".alert-dismissible")).isDisplayed());

        tearDown();
    }



}
