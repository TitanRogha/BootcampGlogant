package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class EspnHomePage extends BasePage{

    public EspnHomePage(WebDriver driver) throws InterruptedException {
        super(driver);
        driver.get("https://www.espn.com/?src=com&adblock=true");
        driver.switchTo().frame("google_ads_iframe_/21783347309/espn.com/frontpage/index_1");
        closeFrame.click();
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#sideLogin-left-rail button:last-child")));



    }

    @FindBy(css = "#sideLogin-left-rail button:last-child")
    private WebElement loginButtonHomePage;

    @FindBy(css= "#overlaybg p a")
    private WebElement closeFrame;


    public LoginPage login() {
        loginButtonHomePage.click();
        return new LoginPage(getDriver());
    }


}
