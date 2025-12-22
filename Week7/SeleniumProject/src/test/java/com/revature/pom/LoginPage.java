package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("//button[@type='submit']");
    private final By flashMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public LoginPage enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(pass);
        return this;
    }

    public SecurePage clickLogin() {
        driver.findElement(loginButton).click();
        return new SecurePage(driver);
    }

    public LoginPage clickLoginExpectingError() {
        driver.findElement(loginButton).click();
        return this;
    }

    // Verification methods
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(flashMessage));
        return driver.findElement(flashMessage).getText();
    }

    public boolean isUsernameFieldDisplayed() {
        return driver.findElement(usernameField).isDisplayed();
    }

    // Compound Action
    public SecurePage loginAs(String user, String pass) {
        return enterPassword(user).enterPassword(pass).clickLogin();
    }
}
