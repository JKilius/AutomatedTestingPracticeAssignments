package ToDoListPage;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ToDoListMain extends ToDoListBase {

    @FindBy(css = "div#container > h1")
    WebElement title;

    @FindBy(css = "ul > li")
    WebElement entry;

    @FindBy(css = "input")
    WebElement input;

    @FindBy(css = "ul li .fa-trash")
    WebElement deleteEntry;

    @FindBy(css = "ul>li")
    public List<WebElement> entries;

    public ToDoListMain(WebDriver driver) {
        super(driver);
    }

    public void enterNewInput(String task) {
        input.sendKeys(task);
        input.sendKeys(Keys.ENTER);
    }

    public void deletion(String toDelete){
        deleteEntry.click();
    }

    public String getLastEntryText() {
        return entries.getLast().getText();
    }

    public String getAllEntryText() {
        String text = "";
        for (WebElement i : entries) {
            text+=i.getText()+"\n";

        }
        return text;
    }

    public int countEntries() {
        return entries.size();
    }

    public void clickEntry() {
        entries.getLast().click();
    }



    public String getEntryClass() {
        return entries.getLast().getAttribute("class");
    }

    public String getAttributeOfLastEntry() {
        return entry.getCssValue("text-decoration");
    }


//    public void deleteToDoElement(String elementToDelete) {
//        if(getAllEntryText().contains(elementToDelete)){
//            entry.
//        }
//    }

    public Boolean checkAllEntryStatusExceptForLast() {
        int size = entries.size();
        for (int i=0; i< size -1; i++) {
            String status = entries.get(i).getAttribute("class");
            if (status != null && status.contains("completed")){
                return true;
            }
        }
        return false;
    }


}
