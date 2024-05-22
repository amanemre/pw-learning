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
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Step;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

public class P02_GoogleSearchTest {

  Playwright playwright;
  BrowserType chromium;
  Browser browser;
  Page page;
  BrowserContext context;

  @Before
  public void setup() {
    playwright = Playwright.create();
    chromium = playwright.chromium();
    browser = chromium.launch(new LaunchOptions().setHeadless(false));
    Browser.NewContextOptions newContextOptions = new NewContextOptions();
    context = browser.newContext(newContextOptions);
    context
        .tracing()
        .start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
    page = browser.newPage();
  }


  @Epic("Web interface")
  @Feature("Essential features")
  @Story("Navigate page")
  @Test
  void test() {
    step1();
    step2();
    step3();
    step4();
  }

  @Step("Step 1 - Navigate to page")
  void step1() {
    page.navigate("http://www.google.com");
  }

  @Step("Step 2 - input search")
  void step2() {
    Locator searchBoxElement = page.locator("textarea[name='q']");

    searchBoxElement.pressSequentially("Selenium", new PressSequentiallyOptions().setDelay(
        300)); // it writes given input like human pressing keys one by one
  }

  @Step("Step 3 - press enter")
  void step3() {
    Keyboard keyboard = page.keyboard();
    keyboard.press("Enter");
    page.waitForTimeout(2000);
  }

  @Step("Step 4 - assert")
  void step4() {
    Assertions.assertEquals(1, 1);
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
