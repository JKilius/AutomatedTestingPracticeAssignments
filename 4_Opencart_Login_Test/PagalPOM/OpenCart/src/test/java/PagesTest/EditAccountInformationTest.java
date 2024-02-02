package PagesTest;

import Pages.EditAccountInformationPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.jupiter.api.Test;

public class EditAccountInformationTest extends BaseTest{

    @Test
    void gotToEditAccountInformation(){
        LoginPage loginPage = new LoginPage(driver);
        EditAccountInformationPage editAccountInformationPage = new EditAccountInformationPage(driver);
        editAccountInformationPage.goToEditAccountInformation();

        //to be completed...
    }
}
