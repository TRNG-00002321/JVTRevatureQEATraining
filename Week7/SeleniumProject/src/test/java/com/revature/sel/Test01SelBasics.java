package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Basic Selenium Test")
public class Test01SelBasics {

    private WebDriver driver;

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

    @Test
    @DisplayName("Basic Chrome Browser Test")
    public void testBasic() throws InterruptedException {
        // Navigate to the website
        driver.get("https://selenium.dev/");
        Thread.sleep(5000); // throws InterruptedException

        // Get the page title
        String title = driver.getTitle();
        System.out.println("Title :: " + title);
        Assertions.assertTrue(title.contains("Selenium"));
    }

    @Test
    @DisplayName("Chrome Browser Test using getCurrentURL")
    public void testBasic2() throws InterruptedException {
        // Navigate to the website
        driver.get("https://selenium.dev/documentation/");
        Thread.sleep(5000); // throws InterruptedException

        // Get the page title
        String currentURL = driver.getCurrentUrl();
        System.out.println("URL :: " + currentURL);
        Assertions.assertTrue(currentURL.contains("documentation"));
    }
}
