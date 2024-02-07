package lt.techin.Tests;


import lt.techin.AccountPage;
import lt.techin.HomePage;
import lt.techin.RegistrationPage;
import lt.techin.Tests.Utils.FailureWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import java.time.Duration;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

@ExtendWith(FailureWatcher.class)
public class BaseTest {

    private static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

    HomePage homePage;
    RegistrationPage registrationPage;

    AccountPage accountPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/notes/app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log.info("Test Environment initialized");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
        log.info("WebDriver closed");
    }
}
