package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//div[@id='navbarSupportedContent']/ul//a[@href='/notes/app/profile']")
    WebElement buttonProfile;

    @FindBy(css = "#user-email")
    WebElement inputUserEmail;

    @FindBy(css="input[name='name']")
    WebElement inputUserName;

    @FindBy(xpath = "//div[@class='col-md-4']/button")
    WebElement buttonDeleteAccount;

    @FindBy(xpath = "//div[@class='modal-footer']/button[1]")
    WebElement buttonConfirmDeletionOfAccount;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonProfile(){
        buttonProfile.click();
    }

    public String getUserEmail(){
       return inputUserEmail.getAttribute("value");
    }

    public String getUserName(){
        return inputUserName.getAttribute("value");
    }

    public void deleteAccount(){
        buttonDeleteAccount.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(buttonConfirmDeletionOfAccount));
        buttonConfirmDeletionOfAccount.click();
    }



}
