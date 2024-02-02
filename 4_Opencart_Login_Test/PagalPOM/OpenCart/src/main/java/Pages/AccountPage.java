package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(linkText = "Edit your account information")
    WebElement goToEditAccountInformation;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

     public void clickOnEditAccountinformation(){
        goToEditAccountInformation.click();
    }
}
