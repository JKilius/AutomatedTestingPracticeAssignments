package ToDoListPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ToDoListBase {

   protected WebDriver driver;

    public ToDoListBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



}
