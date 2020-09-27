package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    public SignUpPage(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(css = "[name=\"firstName\"]")
    private WebElement firstName;

    @FindBy(css = "[name=\"lastName\"]")
    private WebElement lastName;

    @FindBy(css = "[name=\"email\"]")
    private WebElement newEmail;

    @FindBy(css = "[name=\"newPassword\"]")
    private WebElement newPasword;

    @FindBy(css = "div button:only-child")
    private WebElement signUpButton;

    @FindBy(id="global-user-trigger")
    private WebElement accountManagement;


    public LoggedHomePage signUp(String firstname,String lastname,String email,String newpassword) {

        waitForPresenceOfElementLocated(By.id("disneyid-iframe"));
        getDriver().switchTo().frame("disneyid-iframe");
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        newEmail.sendKeys(email);
        newPasword.sendKeys(newpassword);

        signUpButton.click();
        waitForElementToBeVisible(accountManagement);


        return new LoggedHomePage(getDriver());
    }


}
