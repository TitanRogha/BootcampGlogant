package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".field-username-email label span input:only-child")
    private WebElement userName;

    @FindBy(css = ".field-password label span input:only-child")
    private WebElement passWord;

    @FindBy(css = "div button:only-child")
    private WebElement signInButton;

    @FindBy(id = "#did-iu")
    private WebElement loginForm;

    @FindBy(id="global-user-trigger")
    private WebElement accountManagement;


    public LoggedHomePage login(String username,String password) {

        waitForPresenceOfElementLocated(By.id("disneyid-iframe"));
        getDriver().switchTo().frame("disneyid-iframe");
        userName.sendKeys(username);
        passWord.sendKeys(password);
        signInButton.click();
        waitForElementToBeVisible(accountManagement);


        return new LoggedHomePage(getDriver());
    }


}
