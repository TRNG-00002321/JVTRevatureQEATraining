package com.revature.pw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    void setupPage() {
        String baseUrl = "https://the-internet.herokuapp.com/";
        loginPage = new LoginPage(page, baseUrl);
    }

    @Test
    @DisplayName("User can login with valid credentials")
    void testSuccessfulLogin() {
        DashboardPage dashboard = loginPage
                .navigate()
                .login("user@example.com", "password123");

        dashboard.assertIsDisplayed();
        dashboard.assertUserName("Test User");
    }

    @Test
    @DisplayName("Invalid credentials show error message")
    void testInvalidCredentials() {
        loginPage
                .navigate()
                .loginExpectingError("invalid@example.com", "wrongpassword")
                .assertErrorVisible("Invalid credentials");
    }
}
