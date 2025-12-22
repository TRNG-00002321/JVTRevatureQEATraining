package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test05Alerts {
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

    @DisplayName("Testing Basic Alert Handling")
    @Test
    public void testBasicAlert() {
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']"))
        );
        Assertions.assertTrue(result.getText().contains("success"));
    }

    @DisplayName("Testing Confirm Handling Accept")
    @Test
    public void testBasicConfirm01() {
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']"))
        );
        Assertions.assertTrue(result.getText().contains("Ok"));
    }
    @DisplayName("Testing Confirm Handling Dismiss")
    @Test
    public void testBasicConfirm02() {
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']"))
        );
        Assertions.assertTrue(result.getText().contains("cancel"));
    }

    @DisplayName("Testing Prompt Handling Accept")
    @Test
    public void testBasicPrompt01() {
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String enteredText = "waga baga bobo";
        alert.sendKeys(enteredText);
        alert.accept();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']"))
        );
        Assertions.assertTrue(alertText.contains("prompt"));
        Assertions.assertTrue(result.getText().contains(enteredText));
    }

    @DisplayName("Testing Prompt Handling Dismiss")
    @Test
    public void testBasicPrompt02() {
        driver.get(BASE_URL + "/javascript_alerts");

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        String enteredText = "waga baga bobo";
        alert.sendKeys(enteredText);
        alert.dismiss();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        WebElement result = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='result']"))
        );
        Assertions.assertTrue(alertText.contains("prompt"));
        Assertions.assertTrue(result.getText().contains("null"));
    }
}
