package lt.techin.opencart.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css =".float-end.nav > .list-inline .dropdown-toggle > .fa-caret-down.fa-solid")
    WebElement dropdown;
    @FindBy(css=".dropdown-menu.dropdown-menu-right.show > li:nth-of-type(2) > .dropdown-item")
    WebElement linkLogin;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown(){
        dropdown.click();
    }

    public void clickLogin() {
        linkLogin.click();
    }
}
