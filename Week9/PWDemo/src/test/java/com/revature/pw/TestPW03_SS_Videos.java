package com.revature.pw;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotAnimations;
import com.microsoft.playwright.options.ScreenshotType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

@DisplayName("PW Screen Shot and Video Demo")
public class TestPW03_SS_Videos extends BaseTest{

    @DisplayName("Screenshot Demo")
    @Test
    public void testScreenshots() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();

            page.navigate("https://playwright.dev");

            page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/screenshots/screenshot.png")));

            // Optional but IDE flags the browser with a warning otherwise
            browser.close(); // Should be done automatically once we leave this try block
        }
    }

    @Test
    void screenshotWithOptions() {
        page.navigate("https://playwright.dev");

        page.screenshot(new Page.ScreenshotOptions()
                // Save location
                .setPath(Paths.get("target/screenshots/page.png"))

                // Full page (scrolls entire page)
                .setFullPage(true)

                // Image format
                .setType(ScreenshotType.PNG)  // or JPEG

                // JPEG quality (0-100)
                // .setQuality(80)  // Only for JPEG

                // Clip to specific area
                // .setClip(100, 100, 500, 300)  // x, y, width, height

                // Omit background (transparent)
                .setOmitBackground(false)

                // Animation handling
                .setAnimations(ScreenshotAnimations.DISABLED)

                // Timeout
                .setTimeout(30000)
        );
    }

    @Test
    void screenshotToBytes() {
        page.navigate("https://playwright.dev");

        // Get screenshot as byte array
        byte[] buffer = page.screenshot();

        // Useful for:
        // - Attaching to reports
        // - Sending to APIs
        // - Base64 encoding
        String base64 = java.util.Base64.getEncoder().encodeToString(buffer);
    }

    @DisplayName("Element Screenshot Demo")
    @Test
    public void elementScreenshot() {
        page.navigate("https://the-internet.herokuapp.com/dropdown");

        // Screenshot of specific element
        page.locator("#content").screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("target/screenshots/content.png"))
        );

        // Element with options
        page.locator("#dropdown").first().screenshot(new Locator.ScreenshotOptions()
                .setPath(Paths.get("target/screenshots/dropdown_first.png"))
                .setOmitBackground(true)  // Transparent background
                .setAnimations(ScreenshotAnimations.DISABLED)
        );
    }

    @Test
    void fullPageScreenshot() {
        page.navigate("https://the-internet.herokuapp.com");

        // Captures entire scrollable page
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get("target/screenshots/full-page.png"))
                .setFullPage(true)
        );
    }

    @Test
    public void testVideo() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(true)
            );

            // Enable video recording in context
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    // Video directory
                    .setRecordVideoDir(Paths.get("target/videos/"))

                    // Video dimensions
                    .setRecordVideoSize(1280, 720)
            );

            // TODO: Run test
            page.navigate("https://the-internet.herokuapp.com");
            System.out.println("   Navigated to homepage");

            page.locator("a:has-text('Form Authentication')").click();
            System.out.println("   Clicked Form Authentication");

            page.locator("#username").fill("tomsmith");
            page.locator("#password").fill("SuperSecretPassword!");
            System.out.println("   Filled login form");

            page.locator("button[type='submit']").click();
            System.out.println("   Submitted form");

            page.waitForTimeout(1000);  // Wait for video to capture result

            // Get video path (available after page closes)
            page.close();
            Path videoPath = page.video().path();
            System.out.println("Video saved: " + videoPath);

            context.close();
            browser.close();
        }
    }
}
