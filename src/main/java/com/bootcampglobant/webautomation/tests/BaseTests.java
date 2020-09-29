package com.bootcampglobant.webautomation.tests;

import com.bootcampglobant.webautomation.MyDriver;
import com.bootcampglobant.webautomation.pages.EspnHomePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class BaseTests {

    MyDriver myDriver;

    private EspnHomePage espnHomePage;

    /*
    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser)  {
        myDriver = new MyDriver(browser);
        espnHomePage = new EspnHomePage(myDriver.getDriver());
    }
    */

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeClass(String browser)  {
        myDriver = new MyDriver(browser);
        espnHomePage = new EspnHomePage(myDriver.getDriver());
    }


    @AfterClass(alwaysRun = true)
    public void afterClass(){ espnHomePage.dispose();
    }


    public EspnHomePage getEspnHomePage() {
        return espnHomePage;
    }


}