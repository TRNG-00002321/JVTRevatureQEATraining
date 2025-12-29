package com.revature.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginPage {
    private final Page page;
    private final String url;

    // Locators
    private Locator emailField() {
        return page.getByLabel("Email");
    }

    private Locator passwordField() {
        return page.getByLabel("Password");
    }

    private Locator signInButton() {
        return page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Sign In"));
    }

    private Locator errorMessage() {
        return page.getByTestId("error-message");
    }

    public LoginPage(Page page, String baseUrl) {
        this.page = page;
        this.url = baseUrl + "/login";
    }

    public LoginPage navigate() {
        page.navigate(url);
        return this;
    }

    public DashboardPage login(String email, String password) {
        emailField().fill(email);
        passwordField().fill(password);
        signInButton().click();
        return new DashboardPage(page);
    }

    public LoginPage loginExpectingError(String email, String password) {
        emailField().fill(email);
        passwordField().fill(password);
        signInButton().click();
        return this;
    }

    public void assertErrorVisible(String message) {
        assertThat(errorMessage()).isVisible();
        assertThat(errorMessage()).containsText(message);
    }
}
