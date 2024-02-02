import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {

    @FindBy(css = "select#page-menu")
    WebElement dropDownPageSize;

    @FindBy(css = "#search-field")
    WebElement searchField;

    @FindBy(css = "select#page-menu")
    WebElement dropDownValue;

    @FindBy(css = "td:first-child")
    List<WebElement> namesOfProduct;

    @FindBy(css = "th:first-child")
    WebElement sortItems;

    @FindBy(xpath = "//li/a[@aria-label='Next']")
    WebElement buttonNext;




    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown() {
        dropDownPageSize.click();
    }

    public void selectSizeOfPageSize(String valueNeeded) {
        Select value = new Select(dropDownValue);
        value.selectByValue(valueNeeded);
    }

    public String getValueOfPageSize() {
        return dropDownPageSize.getAttribute("value");
    }

    public List<String> getListOfAllProductNames() {
        clickDropdown();
        selectSizeOfPageSize("20");
        return namesOfProduct.stream().map(WebElement::getText).toList();
    }

    public void clickSortItems() {
        sortItems.click();
    }

    public void enterStringInToSearchField(String searchable) {
        searchField.sendKeys(searchable);
    }

    public void clickButtonNext() {
        buttonNext.click();
    }

    public List<String> getListOfProductsFromAllPages() {
        List<String> addedList = new ArrayList<>();
        while (buttonNext.isEnabled()) {
            try {
                addedList.addAll(getListOfAllProductNames());
                clickButtonNext();
            } catch (Exception e) {
                break;
            }

        }
        return addedList;
    }


    }


