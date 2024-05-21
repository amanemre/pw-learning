//package org.emreaman.day_01.pac_01_playwright_intro;
//
//import com.microsoft.playwright.Browser;
//import com.microsoft.playwright.BrowserType;
//import com.microsoft.playwright.BrowserType.LaunchOptions;
//import com.microsoft.playwright.Page;
//import com.microsoft.playwright.Playwright;
//
//public class P01_PlaywrightTest {
//
//  public static void main(String[] args) throws InterruptedException {
//    Playwright playwright = Playwright.create();
//    BrowserType chromium = playwright.chromium();
//    Browser browser = chromium.launch(new LaunchOptions().setHeadless(false));
//    Page page = browser.newPage();
//    page.navigate("http://www.google.com");
//    Thread.sleep(3000);
//
//    page.close();
//    browser.close();
//    playwright.close();
//  }
//
//}
