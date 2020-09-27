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
        waitForPresenceOfElementLocated(By.id("google_ads_iframe_/21783347309/espn.latam.co/frontpage/index_1"));
        if(iframe.isDisplayed()){
            driver.switchTo().frame("google_ads_iframe_/21783347309/espn.latam.co/frontpage/index_1");
            closeFrame.click();
            driver.switchTo().defaultContent();
            waitForElementToBeClickable(loginButtonHomePage);
        }
    }

    @FindBy(css = "#sideLogin-left-rail button:last-child")
    private WebElement loginButtonHomePage;

    @FindBy(css = "#sideLogin-left-rail h1 + button")
    private WebElement singUpButtonHomePage;

    @FindBy(css= "#overlaybg p a")
    private WebElement closeFrame;

    @FindBy(id= "google_ads_iframe_/21783347309/espn.latam.co/frontpage/index_1")
    private WebElement iframe;

    @FindBy(css=".display-user span")
    private WebElement welcomeMessage;

    @FindBy(id="global-user-trigger")
    private WebElement accountManagement;


    public LoginPage searchLogin()  {
        loginButtonHomePage.click();
        return new LoginPage(getDriver());
    }

    public SignUpPage searchSignUp()  {
        singUpButtonHomePage.click();
        return new SignUpPage(getDriver());
    }

    public Boolean checkIfIsLoggedOut() {
        accountManagement.click();

        return isDisplayed(welcomeMessage);
    }

}
