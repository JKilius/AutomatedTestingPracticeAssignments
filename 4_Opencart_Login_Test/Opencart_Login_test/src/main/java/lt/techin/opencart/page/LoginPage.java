package lt.techin.opencart.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css="input#input-email")
    WebElement inputEmail;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }
}
