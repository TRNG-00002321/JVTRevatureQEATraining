package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class Test04Waits {
    private static WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setUp() {
        // Set up your WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize your WebDriver
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        /*
         * ALWAYS close the driver!
         * Forgetting to quit leaves browser processes running
         */
        if (driver != null) {
            // driver.close();  // Close currently focused window of driver; session remains active
            driver.quit(); // Closes all windows, pop-ups, & tabs managed by driver; terminates the session
        }
    }

    @DisplayName("Without Waits")
    @Test
    public void withoutWaits() {
        driver.get(BASE_URL + "/dynamic_loading/1");

        driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

        WebElement result = driver.findElement(By.id("finish"));
        System.out.println(result.getText());
        // Assertions.assertEquals("Hello World!", result.getText()); // Fails because it is unable to load in time
    }

    @DisplayName("Test Implicit Wait")
    @Test
    public void testImplicitWait() {

        // Set implicit wait for all elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));

        driver.get(BASE_URL + "/dynamic_loading/1");

        driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

        WebElement result = driver.findElement(By.id("finish"));
        Assertions.assertTrue(result.getText().contains("Hello"));
    }

    @DisplayName("Test Explicit Wait")
    @Test
    public void testExplicitWait() {
        driver.get(BASE_URL + "/dynamic_loading/1");

        driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("finish"))
        );
        Assertions.assertTrue(result.getText().contains("Hello"));
    }

    @DisplayName("Test Fluent Wait")
    @Test
    public void testFluentWait() {
        driver.get(BASE_URL + "/dynamic_loading/1");

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10L))
                .pollingEvery(Duration.ofMillis(500L))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class)
                .withMessage("Waiting for the result element");

        driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();

        WebElement result = fluentWait.until(driver ->
            driver.findElement(By.id("finish"))
        );
        Assertions.assertTrue(result.getText().contains("Hello"));
    }
}
