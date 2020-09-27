package com.bootcampglobant.webautomation.tests;

import com.bootcampglobant.webautomation.pages.EspnHomePage;
import com.bootcampglobant.webautomation.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test
    public void test() throws InterruptedException {
        EspnHomePage home =getEspnHomePage();
        LoginPage loginPage=home.searchLogin();
        loginPage.login("luchocd27@gmail.com","Werewolf27*");

    }

}
