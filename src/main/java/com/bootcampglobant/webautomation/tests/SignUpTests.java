package com.bootcampglobant.webautomation.tests;

import com.bootcampglobant.webautomation.pages.BasePage;
import com.bootcampglobant.webautomation.pages.EspnHomePage;
import com.bootcampglobant.webautomation.pages.LoggedHomePage;
import com.bootcampglobant.webautomation.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BaseTests {

    @Test
    public void successfulSignUp(){
        EspnHomePage home = getEspnHomePage();
        SignUpPage signUpPage = home.searchSignUp();
        LoggedHomePage loggedHomePage = signUpPage.signUp("Esteban","Castillo","algohaha@hotmail.com","Luis1711*");
        Assert.assertEquals(loggedHomePage.getWelcomeMessage(), "Esteban!");
    }


}
