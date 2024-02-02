package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class BasicTest1 {

//1. Create a new Selenium test under new Java Class
//2. Open https://demo.opencart.com/


    static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void wishList() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("http://192.168.88.87");

        //3. Click on a wishlist
        driver.findElement(By.cssSelector("a#wishlist-total > .d-md-inline.d-none")).click();
        Assertions.assertEquals("http://192.168.88.87/en-gb?route=account/login", driver.getCurrentUrl());

        //4. Count and print a number of seach boxes
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        System.out.println(inputs.stream().filter(WebElement::isDisplayed).count());

        //5. Find element of email input field and enter email “email@email.com”
        driver.findElement(By.cssSelector("#input-email")).sendKeys("emai@email.com");

        //6. Clear previous field
        driver.findElement(By.cssSelector("#input-email")).clear();

        //7. Submit form
        WebElement submit = driver.findElement(By.cssSelector("[action] .btn-primary"));
        submit.click();
        Assertions.assertTrue(submit.findElement(By.xpath("/html//div[@id='alert']")).isDisplayed());

        //8. Click on register a new customer
        WebElement reg = driver.findElement(By.linkText("Continue"));
        //WebElement reg = driver.findElement(By.className("text-end"));
        reg.click();

        //9. Check if the field to input password is enabled and print the result
        WebElement pass = driver.findElement(By.cssSelector("#input-password"));
        System.out.println(pass.isEnabled());

        //10. Check if cart element is displayed and print the result
        WebElement cart = driver.findElement(By.cssSelector(".btn-inverse"));
        System.out.println(cart.isDisplayed());

        //11. Check if agree checkbox is selected and print the result
        WebElement check = driver.findElement(By.cssSelector("input[name='agree']"));
        Assertions.assertFalse(check.isSelected());
        check.click();
        Assertions.assertTrue(check.isSelected());
        System.out.println(check.isSelected());

        //12. Go to top menu -> Desktops
        WebElement desktop = driver.findElement(By.cssSelector("li:nth-of-type(1) > .dropdown-toggle.nav-link"));
        desktop.click();
        //Thread.sleep(3000);
        driver.findElement(By.cssSelector(".dropdown-menu.show > .see-all")).click();
        Assertions.assertEquals("http://192.168.88.87/en-gb/catalog/desktops", driver.getCurrentUrl());

        //13. Select to show 25 items per page
        Select dropDown = new Select(driver.findElement(By.cssSelector("select#input-limit")));
        dropDown.selectByVisibleText("50");

        //Assertions.assertEquals(dropDown.selectByVisibleText("50"), );

        //14. Print selected option from the dropbox
        String dropDown1 = driver.findElement(By.cssSelector("select#input-limit > option[value='http://192.168.88.87/en-gb/catalog/desktops?limit=50']")).getText();
        System.out.println(dropDown1);

        //15. Select 4th option in show items per page dropbox
        Select dropDown2 = new Select(driver.findElement(By.cssSelector("select#input-limit")));
        dropDown2.selectByIndex(4);

        //16. Print selected option
        WebElement printable = driver.findElement(By.cssSelector("select#input-limit > option:nth-of-type(5)"));
        System.out.println(printable.getText());


    }

    //17. Close the window
    @AfterEach
    void teardown() {
        driver.close();
    }


}
