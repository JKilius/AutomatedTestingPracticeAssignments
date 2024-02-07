package lt.techin.Tests;

import lt.techin.AccountPage;
import lt.techin.HomePage;
import lt.techin.RegistrationPage;
import lt.techin.Tests.Utils.RandomStringGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationPageTest extends BaseTest {

    HomePage homePage;
    RegistrationPage registrationPage;
    AccountPage accountPage;


    @Test
    void successfulRegistrationWithCorrectDetails() {
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);

        homePage.clickButtonCreateAnAccount();

        String email = RandomStringGenerator.generateRandomEmail().toLowerCase() + "@gmail.com";
        String password = RandomStringGenerator.generateRandomPassword();
        String name = RandomStringGenerator.generateRandomName();
        String confirmPassword = password;


        registrationPage.enterName(name);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPassword);
        registrationPage.clickButtonRegister();

        assertTrue(registrationPage.getAlertMessage().contains("User account created successfully"));

        registrationPage.clickLoginLink();

        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.clickButtonRegister();

        accountPage.clickButtonProfile();
        String profileUserName = accountPage.getUserName();
        String profileUserEmail = accountPage.getUserEmail();

        assertEquals(email, profileUserEmail);
        assertEquals(name, profileUserName);


    }
// Situ nereikia nes parametrizuojam ir padarom is to viena testa
//    @Test
//    void unsuccessfulLoginUsingIncorrectEmailAddress() {
//        registrationPage = new RegistrationPage(driver);
//        homePage = new HomePage(driver);
//        accountPage = new AccountPage(driver);
//
//        homePage.clickButtonCreateAnAccount();
//
//        String email = RandomStringGenerator.generateRandomEmail().toLowerCase();
//        String name = RandomStringGenerator.generateRandomName();
//        String password = RandomStringGenerator.generateRandomPassword();
//        String confirmPassword = password;
//
//        registrationPage.enterEmail(email);
//        registrationPage.enterName(name);
//        registrationPage.enterPassword(password);
//        registrationPage.enterConfirmPassword(confirmPassword);
//        registrationPage.clickButtonRegister();
//
//        assertTrue(registrationPage.getErrorEmailInputMessage().contains("Email address is invalid"));
//
//        //fail();
//    }
//
//    @Test
//    void unsuccessfulLoginUsingIncorrectName() {
//        registrationPage = new RegistrationPage(driver);
//        homePage = new HomePage(driver);
//        accountPage = new AccountPage(driver);
//
//        homePage.clickButtonCreateAnAccount();
//
//        String email = RandomStringGenerator.generateRandomEmail().toLowerCase() + "@gmail.com";
//        String name = "*";
//        String password = RandomStringGenerator.generateRandomPassword();
//        String confirmPassword = password;
//
//        registrationPage.enterEmail(email);
//        registrationPage.enterName(name);
//        registrationPage.enterPassword(password);
//        registrationPage.enterConfirmPassword(confirmPassword);
//        registrationPage.clickButtonRegister();
//
//        assertTrue(registrationPage.getErrorNameInputMessage().contains("User name should be between 4 and 30 characters"));
//
//        //fail();
//    }
//
//    @Test
//    void unsuccessfulLoginUsingIncorrectPassword() {
//        registrationPage = new RegistrationPage(driver);
//        homePage = new HomePage(driver);
//        accountPage = new AccountPage(driver);
//
//        homePage.clickButtonCreateAnAccount();
//
//        String email = RandomStringGenerator.generateRandomEmail().toLowerCase() + "@gmail.com";
//        String name = RandomStringGenerator.generateRandomName();
//        String password = "-";
//        String confirmPassword = password;
//
//        registrationPage.enterEmail(email);
//        registrationPage.enterName(name);
//        registrationPage.enterPassword(password);
//        registrationPage.enterConfirmPassword(confirmPassword);
//        registrationPage.clickButtonRegister();
//
//        assertTrue(registrationPage.getErrorPasswordInputMessage().contains("Password should be between 6 and 30 characters"));
//    }
//
//    @Test
//    void unsuccessfulLoginUsingIncorrectConfirmPassword() {
//        registrationPage = new RegistrationPage(driver);
//        homePage = new HomePage(driver);
//        accountPage = new AccountPage(driver);
//
//        homePage.clickButtonCreateAnAccount();
//
//        String email = RandomStringGenerator.generateRandomEmail().toLowerCase() + "@gmail.com";
//        String name = RandomStringGenerator.generateRandomName();
//        String password = RandomStringGenerator.generateRandomPassword();
//        String confirmPassword = "password";
//
//        registrationPage.enterEmail(email);
//        registrationPage.enterName(name);
//        registrationPage.enterPassword(password);
//        registrationPage.enterConfirmPassword(confirmPassword);
//        registrationPage.clickButtonRegister();
//
//        assertTrue(registrationPage.getErrorConfirmPasswordInputMessage().contains("Passwords don't match!"));
//    }

    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/logins.csv", numLinesToSkip = 1)
    void ussuccessfulLoginUsingIncorrectLoginData(String name, String email, String password, String confirmPass, String errorMessage) {
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);

        homePage.clickButtonCreateAnAccount();

        registrationPage.enterEmail(email);
        registrationPage.enterName(name);
        registrationPage.enterPassword(password);
        registrationPage.enterConfirmPassword(confirmPass);
        registrationPage.clickButtonRegister();

        assertTrue(registrationPage.isErrorMessageCorrect(errorMessage), "Expected error message was not found:" + errorMessage);



    }
    @Test
    void successfulAccountDeletion(){
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);
        accountPage =new AccountPage(driver);
        accountPage.deleteAccount();
    }
}