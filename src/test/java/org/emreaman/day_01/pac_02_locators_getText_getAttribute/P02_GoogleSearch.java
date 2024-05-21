package org.emreaman.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.PressSequentiallyOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P02_GoogleSearch {

  @Test
  void test1() {

    Playwright playwright = Playwright.create();
    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch(new LaunchOptions().setHeadless(false));
    Page page = browser.newPage();

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

}
