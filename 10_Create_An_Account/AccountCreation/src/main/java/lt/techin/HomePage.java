package lt.techin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "[class='btn btn-outline-secondary btn-lg px-4']")
    WebElement buttonLCreateAnAccount;

    @FindBy(css = "h1")
    WebElement textIdentifier;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonCreateAnAccount() {
        buttonLCreateAnAccount.click();
    }

    public String getPageName() {
        return textIdentifier.getText();
    }
}
