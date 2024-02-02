import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//Sukurkite esamo vartotojo prisijungimo (login) automatinius testus Opencart puslapiui
// (pozitivus ir negativus testas).
//prisijungimai: vardas John, Pavarde: Smith: el.pastas: johnsmith@something.com, pass: john.

public class LoginTest {

    static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

    }

    void logout() {

        driver.findElement(By.cssSelector(".float-end .fa-caret-down")).click();
        driver.findElement(By.cssSelector("li:nth-of-type(5) > .dropdown-item")).click();
        Assertions.assertEquals("http://192.168.88.87/en-gb?route=account/logout", driver.getCurrentUrl());
        Assertions.assertEquals("Account Logout", driver.getTitle());
    }

    @Test
    void goToLoginPage() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("http://192.168.88.87");

        driver.findElement(By.cssSelector(".float-end.nav > .list-inline .dropdown-toggle > .fa-caret-down.fa-solid")).click();
        driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right.show > li:nth-of-type(2) > .dropdown-item")).click();


        Assertions.assertEquals("http://192.168.88.87/en-gb?route=account/login", driver.getCurrentUrl());
    }

    @Test
    void loginWithCorrectDetails() throws InterruptedException {

        goToLoginPage();

        driver.findElement(By.cssSelector("input#input-email")).sendKeys("johnsmith@something.com");
        driver.findElement(By.cssSelector("input#input-password")).sendKeys("john");
        driver.findElement(By.cssSelector("[action] .btn-primary")).click();
        //Thread.sleep(1000);
        Assertions.assertEquals("My Account", driver.getTitle());

        driver.findElement(By.cssSelector("div#content > ul:nth-of-type(1) > li:nth-of-type(1) > a")).click();
        //Thread.sleep(3000);
        String fName = driver.findElement(By.cssSelector("#input-firstname")).getAttribute("value");
        String lName = driver.findElement(By.cssSelector("#input-lastname")).getAttribute("value");
        String email = driver.findElement(By.cssSelector("#input-email")).getAttribute("value");
        Assertions.assertEquals("John", fName);
        Assertions.assertEquals("Smith", lName);
        Assertions.assertEquals("johnsmith@something.com", email);

        logout();

    }


    @Test
    void loginWithIncorrectDetails() {

        goToLoginPage();

        driver.findElement(By.cssSelector("#input-email")).sendKeys("john@something.com");
        driver.findElement(By.cssSelector("#input-password")).sendKeys("john");
        driver.findElement(By.cssSelector("[action] .btn-primary")).click();

        Assertions.assertNotEquals("My Account", driver.getTitle());
        Assertions.assertTrue(driver.findElement(By.cssSelector(".alert-dismissible")).isDisplayed());

        driver.findElement(By.cssSelector("#input-email")).sendKeys("john@something.com");
        driver.findElement(By.cssSelector("#input-password")).sendKeys("john4");
        driver.findElement(By.cssSelector("[action] .btn-primary")).click();

        Assertions.assertNotEquals("My Account", driver.getTitle());
        Assertions.assertTrue(driver.findElement(By.cssSelector(".alert-dismissible")).isDisplayed());

    }

    @AfterEach
    void tearDown() {
        driver.close();
    }

}
