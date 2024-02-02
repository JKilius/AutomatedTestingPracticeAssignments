package DragAndDrop;

import com.github.dockerjava.core.command.AttachContainerResultCallback;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DragAndDrop {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    void goToSite() {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
    }

    // 1. Drag&Drop
    // 1.1 Tempti dezute Draggable i dezute Droppable
    // 1.2 Patikrinti ar Droppable dezute pakeite spalva ir teksta

    @Test
    void testDragAndDrop() {
        goToSite();
        Actions actions = new Actions(driver);
        WebElement boxDrag = driver.findElement(By.id("draggable"));
        WebElement boxDrop = driver.findElement(By.id("droppable"));

        WebElement colorBefore = driver.findElement(By.cssSelector("div#droppable"));
        System.out.println(colorBefore.getCssValue("background-color"));


        actions.dragAndDrop(boxDrag, boxDrop).perform();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement text = driver.findElement(By.id("droppable"));

        WebElement color = driver.findElement(By.cssSelector("div#droppable > p"));


        assertEquals("Dropped!", text.getText());
        //assertTrue(color.getAttribute("style").contains("background-color: rgb(244, 89, 80); height: 100%;"));
        System.out.println(color.getCssValue("background-color"));
        assertNotEquals(colorBefore, color);

    }

    // 2. Doubleclick
    // 2.1 Atlikti dviguba paspaudima sekcijai Double Click Me!
    // 2.2 Patikrinti ar sekcija pakeite spalva

    @Test
    void testDoubleclick() {
        goToSite();
        Actions actions = new Actions(driver);
        WebElement yellowBox = driver.findElement(new By.ByClassName("div-double-click"));

        actions.doubleClick(yellowBox).perform();

        //WebElement greenBox = driver.findElement(By.cssSelector("#double-click"));
        assertNotEquals("rgba(254, 196, 45, 1)", yellowBox.getCssValue("background-color"));


    }

    // 3. Peles uzvedimas Hover
    // 3.1 Atlikti peles uzvedimo veiksmus ant visu Hover On Me elementu
    // 3.2 Patikrinti atsiradusius sub-menu elementus

    @Test
    void TestHover() {
        goToSite();
        Actions actions = new Actions(driver);

        WebElement hov = driver.findElement(By.cssSelector("div.container div.col-lg-12.text-center:nth-child(4) div.thumbnail div.dropdown.hover:nth-child(1) > button.dropbtn"));
        actions.moveToElement(hov).perform();
        WebElement check = driver.findElement(By.cssSelector("div.container div.col-lg-12.text-center:nth-child(4) div.thumbnail div.dropdown.hover:nth-child(1) div.dropdown-content > a.list-alert"));
        assertTrue(check.isDisplayed());

        WebElement hov2 = driver.findElement(By.cssSelector("\tdiv.container div.col-lg-12.text-center:nth-child(4) div.thumbnail div.dropdown:nth-child(2) > button.dropbtn"));
        actions.moveToElement(hov2).perform();
        WebElement check2 = driver.findElement(By.cssSelector("div.container div.col-lg-12.text-center:nth-child(4) div.thumbnail div.dropdown:nth-child(2) div.dropdown-content > a.list-alert"));
        assertTrue(check2.isDisplayed());

        WebElement hov3 = driver.findElement(By.cssSelector("div.container div.col-lg-12.text-center:nth-child(4) div.thumbnail div.dropdown:nth-child(3) > button.dropbtn"));
        actions.moveToElement(hov3).perform();
        WebElement check3 = driver.findElement(By.cssSelector("div.container div.col-lg-12.text-center:nth-child(4) div.thumbnail div.dropdown:nth-child(3) div.dropdown-content > a.list-alert:nth-child(1)"));
        WebElement check4 = driver.findElement(By.cssSelector("div.container div.col-lg-12.text-center:nth-child(4) div.thumbnail div.dropdown:nth-child(3) div.dropdown-content > a.list-alert:nth-child(2)"));

        assertTrue(check3.isDisplayed());
        assertTrue(check4.isDisplayed());

    }

    // 4.Paspausti ir laikyti
    // 4.1 Paspausti ir laikyti dezute Click and Hold
    // 4.2 Patikrinti ar dezute pakeite spalva ir teksta

    @Test
    void testClickAndHold(){
        goToSite();
        Actions actions = new Actions(driver);

        WebElement hold = driver.findElement(By.cssSelector("#click-box"));
        actions.clickAndHold(hold).perform();

        assertEquals("Well done! keep holding that click now.....", hold.getText());
        assertTrue(hold.getAttribute("style").contains("background: rgb(0, 255, 0)"));
        assertNotEquals("background: tomato; font-size: 30px;", hold.getAttribute("style"));
    }

    @AfterEach
    void tearDown(){
        driver.close();
    }
}
