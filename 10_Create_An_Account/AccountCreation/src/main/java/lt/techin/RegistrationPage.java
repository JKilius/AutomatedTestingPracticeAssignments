package lt.techin;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RegistrationPage extends BasePage {

    @FindBy(css = "#email")
    WebElement inputEmailAddress;

    @FindBy(css = "#password")
    WebElement inputPassword;

    @FindBy(css = "#name")
    WebElement inputName;

    @FindBy(css = "#confirmPassword")
    WebElement inputConfirmPassword;

    @FindBy(css = "[class='btn btn-lg btn-primary d-block w-100']")
    WebElement buttonRegister;

    @FindBy(css = ".alert-success b")
    WebElement alertMessageSuccess;

    @FindBy(xpath = "//div/a[@class='text-decoration-none me-3']")
    WebElement linkClickHereToLogIn;

    @FindBy(xpath = "//div[contains(@class,'invalid-feedback') and text() = 'Email address is invalid']")
    WebElement errorEmailInputMessage;

    @FindBy(xpath = "//div[contains(@class,'invalid-feedback') and text() = 'Password should be between 6 and 30 characters']")
    WebElement errorPasswordInputMessage;

    @FindBy(xpath = "//div[contains(@class,'invalid-feedback') and text() = 'User name should be between 4 and 30 characters']")
    WebElement errorNameInputMessage;

    @FindBy(xpath = "//div[contains(@class,'invalid-feedback') and text() = 'Passwords don't match!']")
    WebElement errorConfirmPasswordInputMessage;

    @FindBy(xpath = "//div[contains(@class,'invalid-feedback')]")
    List<WebElement> errorMessages;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        inputEmailAddress.sendKeys(email);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void enterConfirmPassword(String confirmPassword) {
        inputConfirmPassword.sendKeys(confirmPassword);
    }

    public void clickButtonRegister() {
        buttonRegister.click();
    }

    public String getAlertMessage() {
        return alertMessageSuccess.getText();
    }

    public void clickLoginLink() {
        linkClickHereToLogIn.click();
    }

    public String getErrorEmailInputMessage() {
        return errorEmailInputMessage.getText();
    }

    public String getErrorPasswordInputMessage() {
        return errorPasswordInputMessage.getText();
    }

    public String getErrorNameInputMessage() {
        return errorNameInputMessage.getText();
    }

    public String getErrorConfirmPasswordInputMessage() {
        return errorConfirmPasswordInputMessage.getText();
    }

    public List<WebElement> getAllErrorMessages() {
        return errorMessages;
    }

    public boolean isErrorMessageCorrect(String errorMessage) {
        return errorMessages.stream().map(WebElement::getText).toList().contains(errorMessage);
    }

//    public boolean isErrorMessageVisible(String errorMessage){
//        return errorMessages.stream().map(WebElement::isDisplayed).toList().isEmpty();
//    }
}


