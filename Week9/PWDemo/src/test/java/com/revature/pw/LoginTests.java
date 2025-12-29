package com.revature.pw;

import java.util.regex.Pattern;
import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTest {

    @Test
    void shouldLoginSuccessfully() {
        navigateTo("/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator(".fa.fa-2x.fa-sign-in").click();

        assertThat(page).hasURL(Pattern.compile(".*secure"));
        assertThat(page.locator("#flash")).containsText("secure");
    }

    @Test
    void shouldShowErrorForInvalidCredentials() {
        navigateTo("/login");

        page.locator("#username").fill("invalid");
        page.locator("#password").fill("wrong");
        page.locator(".fa.fa-2x.fa-sign-in").click();

        assertThat(page.locator("#flash")).isVisible();
        assertThat(page.locator("#flash")).containsText("invalid");
    }
}
