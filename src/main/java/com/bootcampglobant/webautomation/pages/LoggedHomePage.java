package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoggedHomePage extends BasePage{


    public LoggedHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".display-user span")
    private WebElement welcomeMessage;

    @FindBy(id="global-user-trigger")
    private WebElement accountManagement;

    @FindBy(css=" .account-management li:last-child a")
    private WebElement logoutButton;


    @FindBy(css="a~div div .account-management li:nth-child(3)")
    private WebElement profile;



    public String getWelcomeMessage() {
        accountManagement.click();
        return welcomeMessage.getText();
    }

    public EspnHomePage logout() {
        waitForElementToBeVisible(accountManagement);
        accountManagement.click();
        waitForElementToBeVisible(logoutButton);
        logoutButton.click();
        return new EspnHomePage(getDriver());
    }

    public UpdateProfilePage searchProfileOption() {
        waitForElementToBeVisible(accountManagement);
        accountManagement.click();
        waitForElementToBeVisible(profile);
        profile.click();
        return new UpdateProfilePage(getDriver());
    }

}
