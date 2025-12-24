package com.training.cucumber.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        // 1. Set up WebDriverManager for Chrome
        // 2. Initialize ChromeDriver
        // 3. Navigate to login page

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL + "/login");
    }

    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        // Find username field and enter the provided username

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        // Find password field and enter the provided password

        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        // Find and click the login button

        driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
    }

    @Then("the user should be redirected to the secure area")
    public void theUserShouldBeRedirectedToTheSecureArea() {
        // Verify the URL contains "/secure"

        assertTrue(driver.getCurrentUrl().contains("/secure"),
                "User was not redirected to secure area");
    }

    @Then("the user should see a success message containing {string}")
    public void theUserShouldSeeSuccessMessageContaining(String expectedMessage) {
        // Find the flash message element and verify it contains expected text

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flash = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );
        String actualMessage = flash.getText();
        assertTrue(actualMessage.contains(expectedMessage),
                "User did not see a success message containing " + expectedMessage);
    }

    @Then("the user should remain on the login page")
    public void theUserShouldRemainOnTheLoginPage() {
        // Verify URL still contains "/login"

        assertTrue(driver.getCurrentUrl().contains("/login"),
                "User did not remain on the login page");
    }

    @Then("the user should see an error message containing {string}")
    public void theUserShouldSeeErrorMessageContaining(String expectedMessage) {
        // Find the flash message element and verify it contains expected error

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flash = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );
        String actualMessage = flash.getText();
        assertTrue(actualMessage.contains(expectedMessage),
                "User did not see an error message containing " + expectedMessage);
    }
}