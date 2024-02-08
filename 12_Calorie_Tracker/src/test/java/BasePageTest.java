import com.sun.tools.javac.Main;
import lt.techin.BasePage;
import lt.techin.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasePageTest {

    WebDriver driver;

    BasePage basePage;

    MainPage mainPage;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/tracalorie/#");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @AfterEach
//    void tearDown(){
//        driver.quit();
//    }
}
