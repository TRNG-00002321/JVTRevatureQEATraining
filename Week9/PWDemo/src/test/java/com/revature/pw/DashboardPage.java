package com.revature.pw;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DashboardPage {
    private final Page page;

    private Locator heading() {
        return page.getByRole(AriaRole.HEADING);
    }

    private Locator userMenu() {
        return page.getByTestId("user-menu");
    }

    private Locator userName() {
        return page.getByTestId("user-name");
    }

    public DashboardPage(Page page) {
        this.page = page;
    }

    public void assertIsDisplayed() {
        assertThat(heading()).hasText("Dashboard");
        assertThat(userMenu()).isVisible();
    }

    public void assertUserName(String name) {
        assertThat(userName()).hasText(name);
    }
}
