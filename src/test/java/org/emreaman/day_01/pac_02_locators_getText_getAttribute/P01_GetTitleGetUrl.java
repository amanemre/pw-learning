package org.emreaman.day_01.pac_02_locators_getText_getAttribute;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01_GetTitleGetUrl {

  @Test
  void test1() {

    Playwright playwright = Playwright.create();
    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch(new LaunchOptions().setHeadless(false));
    Page page = browser.newPage();

    page.navigate("http://practice.cydeo.com");
    Assertions.assertTrue(page.url().contains("cydeo"));
    Assertions.assertEquals(page.title(), "Practice");
    System.out.println(page.url());
    System.out.println(page.title());
    page.waitForTimeout(2000);


    page.close();
    browser.close();
    playwright.close();
  }

}
