package com.bootcampglobant.webautomation.tests;


import com.bootcampglobant.webautomation.pages.EspnHomePage;
import com.bootcampglobant.webautomation.pages.LoggedHomePage;
import com.bootcampglobant.webautomation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LogoutTests extends BaseTests {

    @Test
    public void successfulLogout() {
        EspnHomePage home = getEspnHomePage();
        LoginPage loginPage = home.searchLogin();
        LoggedHomePage loggedHomePage = loginPage.login("luchocd27@hotmail.com", "6yh8mR9xqW4586q4");
        EspnHomePage home2 = loggedHomePage.logout();
        Assert.assertFalse(home2.checkIfIsLoggedOut());

    }
}
