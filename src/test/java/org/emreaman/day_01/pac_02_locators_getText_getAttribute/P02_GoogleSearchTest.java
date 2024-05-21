package org.emreaman.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.PressSequentiallyOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.Tracing.StopOptions;
import io.qameta.allure.Allure;
import java.io.FileInputStream;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_GoogleSearchTest {
  Playwright playwright;
  BrowserType chromium;
  Browser browser;
  Page page;
  BrowserContext context;

  @Test
  void test1() {

    playwright = Playwright.create();
    chromium = playwright.chromium();
    browser = chromium.launch(new LaunchOptions().setHeadless(false));
    Browser.NewContextOptions newContextOptions = new NewContextOptions();
    context = browser.newContext(newContextOptions);
    context
        .tracing()
        .start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
    page = browser.newPage();

    page.navigate("http://www.google.com");

    Locator searchBoxElement = page.locator("textarea[name='q']");

    //searchBoxElement.fill("Selenium");
    searchBoxElement.pressSequentially("Selenium", new PressSequentiallyOptions().setDelay(
        300)); // it writes given input like human pressing keys one by one

    page.waitForTimeout(2000);

    Keyboard keyboard = page.keyboard();
    keyboard.press("Enter");

    page.waitForTimeout(2000);
    Assertions.assertEquals(1,1);
    page.close();
    browser.close();
    playwright.close();
  }

  @After
  public void after() {
    try {

        String tracingFilePath = "target/test.zip";
        context.tracing()
            .stop(new StopOptions().setPath(Paths.get(tracingFilePath)));
        Allure.attachment("pw-trace", new FileInputStream(tracingFilePath));


    } catch (Exception e) {

    } finally {

      page.close();
      browser.close();
      playwright.close();
    }
  }

}
