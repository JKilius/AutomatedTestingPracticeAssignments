package Buttons;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedCondition.*;

public class ButtonsSeeButtonsDo {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    void goToSite() {
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");
    }

//1. WebElement Click
//    Paspausti Mygtuka 1 naudojant WebElement click() metoda.
//    patikrinti ar atsiranda popup pranesimas su tinkama sekmes zinute.
//    uzdaryti popup langa.

    @Test
    void clickClack() throws InterruptedException {
        goToSite();
        WebElement button = driver.findElement(new By.ById("button1"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement popup = driver.findElement(new By.ByClassName("modal-title"));
        wait.until(ExpectedConditions.visibilityOf(popup));
        assertEquals("Congratulations!", popup.getText());

        WebElement button12 = driver.findElement(By.cssSelector("body [role='dialog']:nth-child(5) .modal-footer [data-dismiss]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(new By.ByCssSelector("body [role='dialog']:nth-child(5) .modal-footer [data-dismiss]")));
        button12.click();

    }
//
//    2.JavaScript Click
//     Paspausti Mygtuka 2 naudojant JavaScript click
//     Patikrinti ar atsiranda popup pranesimas su tinkama zinute.
//    uzdaryti popup langa

    @Test
    void javaScriptClickClack() {
        goToSite();
        WebElement button2 = driver.findElement(new By.ById("button2"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button2);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement popup2 = driver.findElement(new By.ByCssSelector(".modal-dialog.modal-md .modal-title"));
        wait.until(ExpectedConditions.visibilityOf(popup2));

        assertEquals("It’s that Easy!! Well I think it is.....", popup2.getText());

        WebElement buttonPop = driver.findElement(new By.ByCssSelector(".modal-dialog.modal-md .btn.btn-default"));
        js.executeScript("arguments[0].click();", buttonPop);

    }

//    4. Sukurti WebElement objekta Mygtukui 3 naudojant pasirinkta lokatoriu
    // Paspausti mygtuka 3 naudojant Action Move $ Click Metoda
    // Patikrinkite ar atsiranda popup pranesimas su tinkama sekmes zinute

    @Test
    void actionMoveAndClickClickClack(){
        goToSite();
        Actions actions = new Actions(driver);
        WebElement button3 = driver.findElement(new By.ById("button3"));
        actions.click(button3).build().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement popup3 = driver.findElement(new By.ByCssSelector("div#myModalMoveClick > .modal-dialog.modal-sm .modal-title"));
        wait.until(ExpectedConditions.visibilityOf(popup3));

        assertTrue(popup3.getText().contains("Well done!"));

        WebElement closeButton = driver.findElement(By.cssSelector("div#myModalMoveClick > .modal-dialog.modal-sm .btn.btn-default"));
        actions.click(closeButton).build().perform();
    }

    @AfterEach
    void tearDown(){
        driver.close();
    }
}
