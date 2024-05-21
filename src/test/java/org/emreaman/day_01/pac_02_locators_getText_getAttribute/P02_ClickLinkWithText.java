//package org.emreaman.day_01.pac_02_locators_getText_getAttribute;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.BrowserType.LaunchOptions;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//public class P02_ClickLinkWithText {
//
//  @Test
//  void test1() {
//
//    Playwright playwright = Playwright.create();
//    BrowserType chromium = playwright.chromium();
//    Browser browser = chromium.launch(new LaunchOptions().setHeadless(false));
//    Page page = browser.newPage();
//
//    page.navigate("http://practice.cydeo.com");
//
//    page.waitForTimeout(2000);
//    page.click("text=A/B Testing");
//    page.waitForTimeout(2000);
//
//    System.out.println(page.title());
//    page.waitForTimeout(2000);
//
//
//    page.close();
//    browser.close();
//    playwright.close();
//  }
//
//}
