package com.bootcampglobant.webautomation.tests;

import com.bootcampglobant.webautomation.MyDriver;
import com.bootcampglobant.webautomation.pages.EspnHomePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTests {

    MyDriver myDriver;

    private EspnHomePage espnHomePage;

    @BeforeSuite(alwaysRun = true)
    @Parameters({"browser"})
    public void beforeSuite(String browser) throws InterruptedException {
        myDriver = new MyDriver(browser);
        espnHomePage = new EspnHomePage(myDriver.getDriver());
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        //espnHomePage.dispose();
    }

    public EspnHomePage getEspnHomePage() {
        return espnHomePage;
    }
}
