package PagesTest;

import Pages.BasePage;
import Pages.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {



    @Test
    void goToLoginPage(){
        HomePage homePage =new HomePage(driver);
        homePage.clickDropDown();
        homePage.clickLogin();
    }
}
