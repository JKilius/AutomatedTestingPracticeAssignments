package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css="input#input-email")
    WebElement inputEmail;

    @FindBy(css="input#input-password")
    WebElement inputPassword;

    @FindBy(css="[action] .btn-primary")
    WebElement buttonLogin;



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickLogin(){
        buttonLogin.click();
    }


}
