package lt.techin.Tests;

import lt.techin.BasePage;
import lt.techin.HomePage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    @Test
    void assertIfRoutedToRegistrationPage(){
        homePage = new HomePage(driver);
        homePage.clickButtonCreateAnAccount();

        assertEquals("Register", homePage.getPageName());
    }
}
