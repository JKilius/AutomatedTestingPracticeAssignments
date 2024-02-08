package lt.techin;

import org.apache.hc.client5.http.auth.KerberosConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@id=\"item-name\"]")
    WebElement inputAddItem;

    @FindBy(xpath = "//input[@id=\"item-calories\"]")
    WebElement inputAddItemCalories;

    @FindBy(xpath = "//button[contains(text(), \"Add Meal\")]")
    WebElement buttonAddMeal;

    @FindBy(xpath = "//a[contains(text(), \"Clear All\")]")
    WebElement buttonClearAllItems;

    @FindBy(xpath = "//ul/li[@class=\"collection-item\"]")
    List<WebElement> collectionOfAllItemsAndCalories;

    @FindBy(xpath = "//li[@class=\"collection-item\"]/strong")
    List<WebElement> collectionOfItemNames;

    @FindBy(xpath = "//ul/li[@class=\"collection-item\"]/strong/../a")
    List<WebElement> buttonsToClickEdit;

    @FindBy(xpath = "//i[@class=\"edit-item fa fa-pencil\"]")
    WebElement buttonEditItem;

    @FindBy(xpath = "//button[@class=\"update-btn btn orange\"]")
    WebElement buttonUpdateMeal;

    @FindBy(xpath = "//button[@class=\"delete-btn btn red\"]")
    WebElement buttonDeleteMeal;

    @FindBy(xpath = "//button[@class=\"back-btn btn grey pull-right\"]")
    WebElement buttonGoBack;

    @FindBy(xpath = "//h3/span[@class=\"total-calories\"]")
    WebElement textTotalCalories;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void enterTextItem(String newItem) {
        inputAddItem.sendKeys(newItem);
    }

    public void enterNumberOfCalories(String itemCalories) {
        inputAddItemCalories.sendKeys(String.valueOf(itemCalories));
    }

    public void clickAddMeal() {
        buttonAddMeal.click();
    }

//    public void clickEditItem(String item) {
//        buttonEditItem.click();
//    }

    public void selectItemToEditByName(String itemName) {
        WebElement editButtonss = driver.findElement(By.xpath("//ul/li[@class='collection-item']/strong[contains(text(), '"+itemName+"')]/../a"));
        //Optional<WebElement> targetButton = editButtons.stream().filter(a->a.getText().contains(itemName)).findFirst();

        editButtonss.click();

    }

    public void clickClearAll() {
        buttonClearAllItems.click();
    }

    public int getAllCalories() {
        String allCalories = textTotalCalories.getText();
        int allCaloriesInt = Integer.parseInt(allCalories);
        return allCaloriesInt;
    }

    public int countAllCalories() {
        List<Integer> allCalories = collectionOfAllItemsAndCalories.stream()
                .map(WebElement::getText)
                //.map(text -> text.split(": ")[1])
                .map(text->text.split(" ")[1])
                //.map(text->text.replace(":", "").trim())
                //.map(text -> text.replace("Calories", "").trim())
                .map(Integer::parseInt)
                .toList();

        return allCalories.stream().mapToInt(Integer::intValue).sum();
    }

    public List<String> getAllItems() {
        return collectionOfAllItemsAndCalories.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void addAListOfItemsAndCalories() {
        enterTextItem("Apple");
        enterNumberOfCalories("95");
        clickAddMeal();
        enterTextItem("Banana");
        enterNumberOfCalories("105");
        clickAddMeal();
        enterTextItem("Carrot");
        enterNumberOfCalories("25");
        clickAddMeal();
        enterTextItem("Egg");
        enterNumberOfCalories("70");
        clickAddMeal();
        enterTextItem("Cake");
        enterNumberOfCalories("1700");
        clickAddMeal();
    }

    public List<String> getAllItemNames() {
        return collectionOfItemNames.stream().map(WebElement::getText).toList();
    }

    public boolean isItemInTheList(String itemNeeded) {
        return collectionOfItemNames.stream().map(WebElement::getText).map(text -> text.replace(":", "")).toList().contains(itemNeeded);
    }

    public void clickButtonUpdateMeal(){
        buttonUpdateMeal.click();
    }

    public void clickButtonDeleteMeal(){
        buttonDeleteMeal.click();
    }

    public void clearInputItem(){
        inputAddItem.clear();
    }

    public void clickButtonBack(){
        buttonGoBack.click();
    }
}
