package lt.techin.opencart.test;

import lt.techin.opencart.page.HomePage;
import lt.techin.opencart.page.LoginPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;

    @Test
    void userCanLogin(){
        homePage = new HomePage(driver);
        loginPage=new LoginPage(driver);
        homePage.clickDropdown();
        homePage.clickLogin();

        loginPage.enterEmail("user@example.com");
    }

}
