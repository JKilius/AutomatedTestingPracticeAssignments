package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@id=\"email\"]")
    WebElement inputLoginEmail;

    @FindBy(xpath = "//input[@id=\"password\"]")
    WebElement inputLoginPassword;

    @FindBy(xpath = "//div[@class=\"form-group\"]/button[contains(@type, \"submit\")]")
    WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
