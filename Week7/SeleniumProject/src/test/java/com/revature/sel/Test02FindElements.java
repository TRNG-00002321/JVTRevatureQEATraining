package com.revature.sel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Finding Elements")
public class Test02FindElements {
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

    @DisplayName("Test By Id")
    @Test
    public void testById() {
        driver.get(BASE_URL + "/login");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));

        Assertions.assertTrue(userName.isDisplayed());
        Assertions.assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By Id With Keyboard Input")
    @Test
    public void testByIdWithKeys() throws InterruptedException {
        driver.get(BASE_URL + "/login");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("Hello");
        Thread.sleep(5000);
        WebElement pass = driver.findElement(By.id("password"));

        Assertions.assertTrue(userName.isDisplayed());
        Assertions.assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test With Mouse Click Input")
    @Test
    public void testWithClick() {
        driver.get(BASE_URL + "/login");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));
        if (!loginButton.isDisplayed()) {
            throw new IllegalStateException("Login button is not displayed");
        }
        if (!loginButton.isEnabled()) {
            throw new IllegalStateException("Login button is not enabled");
        }
        try {
            loginButton.click();
            Thread.sleep(5000);
        } catch (ElementClickInterceptedException e) {
            // Element obscured, try JavaScript click
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click()", loginButton
            );
        } catch (InterruptedException e) {
            throw new IllegalStateException("testWithClick() was interrupted");
        }
        WebElement error = driver.findElement(By.id("flash"));

        Assertions.assertTrue(error.isDisplayed());
    }

    @DisplayName("Test By Name")
    @Test
    public void testByName() {
        driver.get(BASE_URL + "/login");
        WebElement userName = driver.findElement(By.name("username"));
        WebElement pass = driver.findElement(By.name("password"));

        Assertions.assertTrue(userName.isDisplayed());
        Assertions.assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By Tag Name")
    @Test
    public void testByTagName() {
        driver.get(BASE_URL + "/login");
        WebElement userName = driver.findElement(By.tagName("input"));
        System.out.println("Web Element userName :: " + userName);
        WebElement pass = driver.findElement(By.tagName("input"));
        System.out.println("Web Element pass :: " + pass);

        Assertions.assertTrue(userName.isDisplayed());
        Assertions.assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By Relative XPath")
    @Test
    public void testByRelativeXPath() {
        driver.get(BASE_URL + "/login");
        // By text content
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        // By multiple attributes
        WebElement pass = driver.findElement(By.xpath("//input[@type='password'][@name='password']"));

        Assertions.assertTrue(userName.isDisplayed());
        Assertions.assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test By Absolute XPath")
    @Test
    public void testByAbsoluteXPath() {
        driver.get(BASE_URL + "/login");
        // By text content
        WebElement userName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        // By multiple attributes
        WebElement pass = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/input[1]"));

        Assertions.assertTrue(userName.isDisplayed());
        Assertions.assertTrue(pass.isDisplayed());
    }

    @DisplayName("Test Login Button Contains Login Text")
    @Test
    public void testLoginButtonText() {
        driver.get(BASE_URL + "/login");
        WebElement loginButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));

        Assertions.assertTrue(loginButton.getText().toLowerCase().contains("login"));
    }
}
