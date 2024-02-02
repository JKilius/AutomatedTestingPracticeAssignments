package lt.techin.opencart.test;

import lt.techin.opencart.page.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest{

    @Test
    void testSomething(){
        HomePage homePage = new HomePage(driver);
        homePage.clickDropdown();
        homePage.clickLogin();
    }


}
