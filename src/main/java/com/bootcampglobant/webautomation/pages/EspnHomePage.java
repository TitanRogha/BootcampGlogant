package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EspnHomePage extends BasePage{

    public EspnHomePage(WebDriver driver) {
        super(driver);
        driver.get("https://www.espn.com.co/?src=com");



        By iframe = By.id("google_ads_iframe_/21783347309/espn.latam.co/frontpage/index_1");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonHomePage));
        driver.switchTo().frame("google_ads_iframe_/21783347309/espn.latam.co/frontpage/index_1");
        closeFrame.click();
        driver.switchTo().defaultContent();
    }

    @FindBy(css = "#sideLogin-left-rail button:last-child")
    private WebElement loginButtonHomePage;

    @FindBy(css= "#overlaybg p a")
    private WebElement closeFrame;


    public LoginPage searchLogin()  {
        loginButtonHomePage.click();
        return new LoginPage(getDriver());
    }


}
