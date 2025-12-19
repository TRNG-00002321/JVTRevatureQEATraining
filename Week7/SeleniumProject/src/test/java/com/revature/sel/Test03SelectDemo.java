package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

@DisplayName("Selecting Elements")
public class Test03SelectDemo {
    private static WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com/";
    private Actions actions;

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

    @DisplayName("Testing Select List")
    @Test
    public void testSelectDemo() {
        driver.get(BASE_URL + "/dropdown");

        WebElement dropDownElement = driver.findElement(By.id("dropdown"));

        Select dropDown = new Select(dropDownElement);
        // dropDown.isMultiple();

        // dropDown.selectByVisibleText("Option1");
        dropDown.selectByValue("1");
        WebElement selectedOption = dropDown.getFirstSelectedOption();

        // Assertions.assertEquals("Option 1", selectedOption.getText());
        Assertions.assertEquals("1", selectedOption.getAttribute("value"));
    }

    @DisplayName("Action API in Action...")
    @Test
    public void actionAPIDemo() {
        driver.get(BASE_URL + "/login");
        actions = new Actions(driver);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // Clear username and password (optional precaution)
        username.clear();
        password.clear();

        actions.click(username)
                .sendKeys("tomsmith")
                .sendKeys(Keys.TAB)
                .sendKeys("SuperSecretPassword!")
                .click(loginButton)
                .perform();

        // Note: NEVER use Thread.sleep() to wait when actually writing test code!
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement flash = driver.findElement(By.id("flash"));
        String flashText = flash.getText();

        // Verify success (check for success message or URL)
        Assertions.assertTrue(flashText.contains("You logged into a secure area!") ||
                driver.getCurrentUrl().contains("secure"));
    }
}
