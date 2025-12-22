package com.revature.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPOMImpl {
    private static WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setUp() {
        // Set up your WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize your WebDriver
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(BASE_URL + "/login");
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

    @DisplayName("Test Login Valid")
    @Test
    public void testLogin_valid_returnsSecurePage() {
        LoginPage loginPage = new LoginPage(driver);

        // Fluent style usage
        SecurePage securePage = loginPage
                .enterUsername("tomsmith")
                .enterPassword("SuperSecretPassword!")
                .clickLogin();

        // Single method call
        // SecurePage securePage = loginPage.loginAs("tomsmith", "SuperSecretPassword!");

        Assertions.assertTrue(securePage.isSecureAreaDisplayed());
        Assertions.assertTrue(securePage.getFlashMessage().contains("logged into"));
    }

    @DisplayName("Test Login Invalid")
    @Test
    public void testLogin_invalid_returnsLoginPageErrorFlash() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .enterUsername("invalid")
                .enterPassword("invalid")
                .clickLoginExpectingError();

        String errorMessage = loginPage.getErrorMessage();
        Assertions.assertTrue(errorMessage.contains("invalid"));
    }

    @DisplayName("Login and logout flow")
    @Test
    public void loginLogout_flow() {
        LoginPage loginPage = new LoginPage(driver);

        // Login
        SecurePage securePage = loginPage.loginAs("tomsmith", "SuperSecretPassword!");
        Assertions.assertTrue(securePage.isSecureAreaDisplayed());

        // Logout
        LoginPage loginPageAfterLogout = securePage.clickLogout();
        Assertions.assertTrue(loginPageAfterLogout.isUsernameFieldDisplayed());
    }
}
