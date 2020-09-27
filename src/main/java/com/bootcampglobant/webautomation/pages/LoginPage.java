package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        By iframe = By.id("disneyid-iframe");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(iframe));
        driver.switchTo().frame("disneyid-iframe");
    };

    @FindBy(css = ".field-username-email label span input:only-child")
    private WebElement userName;

    @FindBy(css = ".field-password label span input:only-child")
    private WebElement passWord;

    @FindBy(css = "div button:only-child")
    private WebElement signInButton;

    @FindBy(id = "#did-iu")
    private WebElement loginForm;

    public LoginPage login(String username,String password) throws InterruptedException {

        userName.sendKeys(username);
        passWord.sendKeys(password);
        signInButton.click();

        return new LoginPage(getDriver());
    }


}
