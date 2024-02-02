import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ClickPage extends BasePage {

    @FindBy(css = ".icon")
    List<WebElement> toBeClicked;


    public ClickPage(WebDriver driver) {
        super(driver);
    }

    public void clickAllSquares() {
        toBeClicked.stream().forEach(WebElement::click);

    }

    public void submitAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clickEverythingEverywhereAllAtOnce() {

//        for (WebElement element : toBeClicked) {
//            clickAllSquares();
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            System.out.println(alert.getText());
//            if(alert.getText().contains("Next level")){
//                alert.accept();
//            }else if(alert.getText().equals("DONE! Congratulations on completing the task!")){
//                break;
//            }
//        }
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        do {
//
//            clickAllSquares();
//            wait.until(ExpectedConditions.alertIsPresent());
//            alert.accept();
//        }
//        while (alert.getText().equals("DONE! Congratulations on completing the task!"));


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//       //Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        Alert alert = driver.switchTo().alert();
//        try{
//            clickAllSquares();
//            //wait.until(ExpectedConditions.alertIsPresent());
//            alert.accept();
//        }catch (Exception e){
//
//        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String alertText;
        do {
            clickAllSquares();
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alertText = alert.getText();
            alert.accept();
        } while (!alertText.equals("DONE! Congratulations on completing the task!"));


    }
}


//"DONE! Congratulations on completing the task!"




