package ToDoListTest;

import ToDoListPage.ToDoListBase;
import ToDoListPage.ToDoListMain;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

   protected WebDriver driver;

    ToDoListBase toDoListBase;
    ToDoListMain toDoListMain;

   @BeforeEach
    void setUp(){
       driver = new ChromeDriver();
       driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

   }

//   @AfterEach
//    void tearDown(){
//       driver.close();
//   }
}
