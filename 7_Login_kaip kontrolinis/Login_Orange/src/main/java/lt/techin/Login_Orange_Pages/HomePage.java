package lt.techin.Login_Orange_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = "input[name='username']")
    WebElement inputUserName;

    @FindBy(css = "input[name='password']")
    WebElement inputPassword;

    @FindBy(css = ".orangehrm-login-button")
    WebElement buttonLogin;

    @FindBy(css = ".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(1)")
    WebElement credentialsUserName;

    @FindBy(css = ".orangehrm-demo-credentials.oxd-sheet.oxd-sheet--gray-lighten-2.oxd-sheet--gutters.oxd-sheet--rounded > p:nth-of-type(2)")
    WebElement credentialsPassword;


    @FindBy(css = "[role='alert']")
    WebElement alert;

    @FindBy(css = ".oxd-input-field-error-message")
    WebElement inputRequired;

    @FindBy(css = ".oxd-userdropdown-tab")
    WebElement dropdownSelect;

    @FindBy(css = "li:nth-of-type(4) > a[role='menuitem']")
    WebElement buttonLogOut;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String userName) {
        inputUserName.sendKeys(userName);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void clickLogin() {
        buttonLogin.click();
    }

    public String getUserNameFromPage() {
        return credentialsUserName.getText().split(":")[1].trim();

       // irgi variantas! return credentialsUserName.getText().replaceAll("Password :", "");


//        return credentialsUserName.stream()
//                .map(WebElement::getText)
//                .map(u -> u.split(":"))
//                .filter(p -> p.length == 2)
//                .map(p -> p[1].trim())
//                .findFirst()
//                .orElse(null);
//    }
//        for(WebElement el: credentialsUserName){
//            String userNameText = el.getText().trim();
//            String[] parts = userNameText.split(":");
//            if(parts.length==2){
//                String userName = parts[1].trim();
//                return userName;
//            }
//
//        }
//
//      return null;
    }

    public String getPasswordFromPage() {
        return credentialsPassword.getText().split(":")[1].trim();


//        return credentialsPassword.stream()
//                .map(WebElement::getText)
//                .map(p -> p.split(":"))
//                .filter(p-> p.length==2)
//                .map(p->p[1].trim())
//                .findFirst()
//                .orElse(null);
    }

    public void paramsToDoEasy() {

    }

    public boolean isAlertMessageVisible() {
        try {
            return alert != null && alert.isEnabled();
        } catch (Exception ignored) {
        }
        return false;
    }

    public boolean isInputRequiredError() {
        try {
            return inputRequired != null && inputRequired.isDisplayed();
        } catch (Exception ignored) {

        }
        return false;
    }

    public void clickLogOut(){
        dropdownSelect.click();
        buttonLogOut.click();
    }

    public boolean checkIfLoggedOut(){
        return inputUserName.isDisplayed();
    }


}
