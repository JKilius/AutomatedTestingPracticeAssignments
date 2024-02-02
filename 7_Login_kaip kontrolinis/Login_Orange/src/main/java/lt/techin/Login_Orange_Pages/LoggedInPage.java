package lt.techin.Login_Orange_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoggedInPage extends BasePage{

@FindBy(css=".oxd-input")
    WebElement accountAdminTab;
    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfAdmin(){
        return accountAdminTab.isDisplayed();
    }

    public boolean checkIfAdminTabIsActive(){
        return accountAdminTab.isEnabled();
    }



    public void waitUntilFinishLoading(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(accountAdminTab));
    }

}
