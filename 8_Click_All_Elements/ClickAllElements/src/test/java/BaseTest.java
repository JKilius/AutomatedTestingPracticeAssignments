import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("file:///D:/Automatinis%20Testavimas/AutomatedTestingPractice/8_Click_All_Elements/QApraktinisALL.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

//    @AfterEach
//    void tearDown(){
//        driver.quit();
//    }
}
