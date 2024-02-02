package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicTest2 {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    // 1.Create a new Selenium test under new Java Class
    // 2.Open https://demo.opencart.com/


    @Test
    void wishList() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("http://192.168.88.87");

        // 3.Enter a wrong product name in Search field (F.e: MaxBook).
        WebElement search = driver.findElement(By.cssSelector(".form-control-lg"));
        search.sendKeys("MaxBook");

        // 4.Click Search button
        WebElement searchButton = driver.findElement(By.cssSelector("div#search > .btn.btn-lg.btn-light"));
        searchButton.click();

        // 5. Check if Search Button is displayed
        WebElement searchButton2 = driver.findElement(By.cssSelector("div#search > .btn.btn-lg.btn-light"));
        assertTrue(searchButton2.isDisplayed());

        // 6.Clear first Search field and enter the correct product name (F.e.: Macbook).
        WebElement search1 = driver.findElement(By.cssSelector(".form-control-lg"));
        search1.clear();
        search1.sendKeys("Macbook");

        // 7.Click search button again.
        WebElement searchButton1 = driver.findElement(By.cssSelector("div#search > .btn.btn-lg.btn-light"));
        searchButton1.click();

        // 8.Count the number of searched items.
        List<WebElement> howMany = driver.findElements(new By.ByClassName("product-thumb"));
        System.out.println(howMany.size());

        // 9.Select: SortBy: Price(Low>High)
        Select sortButton = new Select(driver.findElement(By.id("input-sort")));
        sortButton.selectByVisibleText("Price (Low > High)");

        // 10.Retrieve selected option text and print it.
        WebElement selected = driver.findElement(By.cssSelector("select#input-sort > option:nth-of-type(4)"));
        System.out.println(selected.getText());

    }
    // 11.Close Browser;
    @AfterEach
    void teardown() {
        driver.close();
    }
}