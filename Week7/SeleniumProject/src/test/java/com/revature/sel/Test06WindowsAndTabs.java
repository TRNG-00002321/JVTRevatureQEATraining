package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Test06WindowsAndTabs {
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

    @DisplayName("Testing Multiple Windows")
    @Test
    void testMultipleWindows() {
        driver.get(BASE_URL + "/windows");

        // Store original window handle
        String originalWindow = driver.getWindowHandle();

        // Click link that opens new window
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        // Wait for new window
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to new window
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Now in new window - perform actions
        Assertions.assertTrue(driver.getCurrentUrl().contains("new"));

        // Close new window
        driver.close();

        // Switch back to original
        driver.switchTo().window(originalWindow);

        // Verify we're back
        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));
    }

    @DisplayName("Testing Multiple Tabs")
    @Test
    void testMultipleTabs() {
        driver.get(BASE_URL);
        String mainTab = driver.getWindowHandle();

        // Open new tab (Selenium 4)
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(BASE_URL + "/windows");

        // Open another tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(BASE_URL + "/windows");

        // Now have 3 tabs
        Assertions.assertEquals(3, driver.getWindowHandles().size());

        // Switch back to main tab
        driver.switchTo().window(mainTab);

        Assertions.assertEquals(BASE_URL, driver.getCurrentUrl());
    }
}
