package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountInformationPage extends BasePage{

    @FindBy(css="div#content > ul:nth-of-type(1) > li:nth-of-type(1) > a")
    WebElement editAccountInformation;

    @FindBy(css="#input-firstname")
    WebElement editFirstName;

    @FindBy(css="#input-firstname")
    WebElement getFirstName;

    @FindBy(css="#input-lastname")
    WebElement editLastName;

    @FindBy(css="#input-lastname")
    WebElement getLastName;

    @FindBy(css="#input-email")
    WebElement editEmail;

    @FindBy(css="#input-email")
    WebElement getEmail;

    @FindBy(css=".btn.btn-primary")
    WebElement buttonContinue;

    @FindBy(css="[action] .btn-light")
    WebElement buttonBack;


    public EditAccountInformationPage(WebDriver driver) {
        super(driver);
    }

    public void goToEditAccountInformation(){
        editAccountInformation.click();
    }

    public void editFirstName(String firstName){
        editFirstName.sendKeys(firstName);
    }

    public void setEditLastName(String lastName){
        editLastName.sendKeys(lastName);
    }

    public void editEmail(String email) {
        editEmail.sendKeys(email);
    }

    public void clickContinue(){
        buttonContinue.click();
    }

    public void clickBack(){
        buttonBack.click();
    }

    public String getFirstName(){
       return getFirstName.getAttribute("value");
    }
    public String getLastName(){
       return getLastName.getAttribute("value");
    }

    public String getEmail(){
       return getEmail.getAttribute("value");
    }
}
