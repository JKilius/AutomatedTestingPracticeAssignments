package LoginTest;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class PageTest {

    static WebDriver driver;

    @BeforeEach
    void setUpBefore() {
        driver = new ChromeDriver();

    }


    @Test
    @DisplayName("Pirmas-Testas")
    void PirmasTestasGeras() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        WebElement elementUser = driver.findElement(By.id("user-name"));
        elementUser.click();
        WebElement elementUser1 = driver.findElement(By.id("user-name"));
        elementUser1.sendKeys("standard_user");

        WebElement elementPass = driver.findElement(By.id("password"));
        elementPass.click();
        WebElement elementPass1 = driver.findElement(By.id("password"));
        elementPass1.sendKeys("secret_sauce");

        WebElement elementBtn = driver.findElement(By.id("login-button"));
        elementBtn.click();

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

    }

    @Test
    @DisplayName("Antras-Testas")
    void PirmasTestasBlogas() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        WebElement elementUser = driver.findElement(By.id("user-name"));
        elementUser.click();

        WebElement elementUser1 = driver.findElement(By.id("user-name"));
        elementUser1.sendKeys("standard_user");

        WebElement elementPass = driver.findElement(By.id("password"));
        elementPass.click();
        WebElement elementPass1 = driver.findElement(By.id("password"));
        elementPass1.sendKeys("wrong_password");

        WebElement elementBtn = driver.findElement(By.id("login-button"));
        elementBtn.click();

        assertEquals("https://www.saucedemo.com/", driver.getCurrentUrl());

        WebElement elementError = driver.findElement(By.cssSelector(".error-message-container.error"));
        assertEquals("Epic sadface: Username and password do not match any user in this service", elementError.getText());


    }

    @Test
    @DisplayName("Trecias-Testas")
    void ArLockedOut() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");

        WebElement elementUser = driver.findElement(By.id("user-name"));
        elementUser.click();

        WebElement elementUser1 = driver.findElement(By.id("user-name"));
        elementUser1.sendKeys("locked_out_user");

        WebElement elementPass = driver.findElement(By.id("password"));
        elementPass.click();
        WebElement elementPass1 = driver.findElement(By.id("password"));
        elementPass1.sendKeys("secret_sauce");

        WebElement elementBtn = driver.findElement(By.id("login-button"));
        elementBtn.click();

        String elementError = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        //System.out.print(elementError);

        Assertions.assertTrue(elementError.contains("this user has been locked out"));


    }


    @ParameterizedTest
    @DisplayName("Ketvirtas-Testas")
    @CsvFileSource(files = "src/main/resources/logins.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceFromFile(String USER_NAME, String PASSWORD) {
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys(USER_NAME);
        driver.findElement(By.id("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("login-button")).click();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        //assertNotNull(USER_NAME);


    }


    @Test
    @DisplayName("Penktas-testas")
    @Timeout(2)
    void testForTime(){
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).click();
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");

        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

    }
    //Kitoks timeout uzrasymas;
//    @Test
//    @DisplayName("Papildomas")
//    void papTest(){
//        assertTimeout(Duration.ofSeconds(2), ()-> {
//            driver.get("https://www.saucedemo.com/");
//
//            driver.findElement(By.id("user-name")).click();
//            driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
//
//            driver.findElement(By.id("password")).click();
//            driver.findElement(By.id("password")).sendKeys("secret_sauce");
//
//            driver.findElement(By.id("login-button")).click();
//        });
//    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}