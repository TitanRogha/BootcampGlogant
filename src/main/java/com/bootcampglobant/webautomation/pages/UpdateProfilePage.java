package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class UpdateProfilePage extends BasePage{

    public UpdateProfilePage(WebDriver pDriver) {
        super(pDriver);

    }

    @FindBy(id = "cancel-account")
    private WebElement cancelAccount;

    @FindBy(id="disneyid-iframe")
    private WebElement disneyIframe;

    @FindBy(css="section .btn-group button:first-child")
    private WebElement acceptButton;


    public EspnHomePage deleteAccount() {

        waitForElementToBeVisible(disneyIframe);
        getDriver().switchTo().frame(disneyIframe);
        Boolean staleElement = true;

        while(staleElement){
            try{
                cancelAccount.click();
                staleElement = false;

            } catch(StaleElementReferenceException e){
                staleElement = true;
            }
        }
        waitForElementToBeClickable(acceptButton);
        acceptButton.click();

        return new EspnHomePage(getDriver());
    }



}
