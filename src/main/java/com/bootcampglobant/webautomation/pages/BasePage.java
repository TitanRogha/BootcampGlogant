package com.bootcampglobant.webautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        this.driver = pDriver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    public void dispose() {

            driver.quit();

    }

    public void waitForElementToBeVisible(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForPresenceOfElementLocated(final By element) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitForElementToBeClickable(final WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean isDisplayedOwn(WebElement element) {

        Boolean passFail = false;

        try {
            if (element.isDisplayed())
                passFail = true;
        } catch (NullPointerException | NoSuchElementException e) {
            System.err.println("Unable to locate element '"  + "'");
        } catch (Exception e) {
            System.err.println("Unable to check display status of element '" + "'");
            e.printStackTrace();
        }

        return passFail;

    }
}