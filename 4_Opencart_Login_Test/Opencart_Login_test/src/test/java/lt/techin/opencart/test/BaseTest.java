package lt.techin.opencart.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get("http://192.168.88.87");
        driver.manage().window().maximize();
    }
    @AfterEach
    void tearDown(){
        driver.close();
    }

}
