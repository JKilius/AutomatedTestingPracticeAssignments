package Alerts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    void goToSite(){
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
    }
    // 1. Patikrinti JavaScript Alert
    // 1.1 Paspausti mygtuka Click Me po JavaScript Alert skyriumi
    // 1.2 Patikrinti ar ispejimo pranesimas yra I am an alert box!
    // 1.3 patvirtinti ispejima

    @Test
    void alertThis(){
        goToSite();
        WebElement buttonAlert = driver.findElement(new By.ById("button1"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonAlert);


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        assertEquals("I am an alert box!", alert.getText());

        alert.accept();
    }

    // 2. Patikrinti JavaScript Confirm box
    // 2.1 Paspausti mygtuka CLICK ME po Javascript Confirm Box skyriumi
    // 2.2 Patikrinti ar ispejimo pranesimas yra Press a button!
    // 2.3 Patvirtinti ispejima
    // 2.4 Patikrinti ar puslapyje atsiranda tekstas You pressed OK!

    @Test
    void alertConfirmBox(){
        goToSite();
        WebElement button2 = driver.findElement(By.id("button4"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alertBox = wait.until(ExpectedConditions.alertIsPresent());

        assertEquals("Press a button!", alertBox.getText());

        alertBox.accept();

        WebElement text = driver.findElement(new By.ById("confirm-alert-text"));
        assertEquals("You pressed OK!", text.getText());
    }

    // 3. Patikrinti Modal Popup
    // 3.1 Paspausti mygtuka CLICK ME! po Modal POPUP skyriumi
    // 3.2 Patikrinti ar modalinio lango antraste yra It’s that Easy!!  Well I think it is.....
    // 3.3 Uzdaryti modalini langa

    @Test
    void alertModal(){
        goToSite();
        WebElement button2 = driver.findElement(By.id("button2"));
        button2.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement text = driver.findElement(new By.ByCssSelector(".modal-title"));
        wait.until(ExpectedConditions.visibilityOf(text));
        assertEquals("It’s that Easy!! Well I think it is.....", text.getText());

        WebElement close = driver.findElement(By.cssSelector(".modal-footer [data-dismiss]"));
        close.click();
    }

    // 4. Patikrinti Ajax Loader
    // 4.1 Paspausti mygtuka CLICK ME! po Ajax loader skyriumi
    // 4.2 Paspausti mygtuka CLICK ME! kuris atsiranda po tam tikro laiko
    // 4.3 Patikrinti ar modalinio lango antraste yra Well Done For Waiting.....!!!
    // 4.4 Uzdaryti modalini langa

    @Test
    void alertAjax(){
        goToSite();
        WebElement button3 = driver.findElement(By.id("button3"));
        button3.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonAfterWait = driver.findElement(By.id("button1"));
        buttonAfterWait.click();

        WebElement headline = driver.findElement(new By.ByCssSelector(".modal-title"));
        wait.until(ExpectedConditions.visibilityOf(headline));
        assertEquals("Well Done For Waiting....!!!", headline.getText());

        WebElement close = driver.findElement(By.cssSelector(".modal-footer [data-dismiss]"));
        close.click();

    }
    @AfterEach
    void tearDown(){
        driver.close();
    }

}
