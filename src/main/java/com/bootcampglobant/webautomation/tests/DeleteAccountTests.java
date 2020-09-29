package com.bootcampglobant.webautomation.tests;

import com.bootcampglobant.webautomation.pages.EspnHomePage;
import com.bootcampglobant.webautomation.pages.LoggedHomePage;
import com.bootcampglobant.webautomation.pages.LoginPage;
import com.bootcampglobant.webautomation.pages.UpdateProfilePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccountTests extends BaseTests {

    @Test
    public void successfulDeleteAccount() {
        EspnHomePage home = getEspnHomePage();
        LoginPage loginPage = home.searchLogin();
        LoggedHomePage loggedHomePage = loginPage.login("algohaha1@hotmail.com", "Luis1711*");
        UpdateProfilePage updateProfilePage = loggedHomePage.searchProfileOption();
        EspnHomePage home1 = updateProfilePage.deleteAccount();
        LoginPage loginPage1 = home1.searchLogin();
        loginPage1.login("algohaha1@hotmail.com", "Luis1711*");
        Assert.assertEquals(loginPage1.getAccountDisableMessage(), "Cuenta Desactivada");
    }
}