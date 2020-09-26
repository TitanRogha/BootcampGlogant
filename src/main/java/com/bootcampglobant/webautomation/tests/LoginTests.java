package com.bootcampglobant.webautomation.tests;

import com.bootcampglobant.webautomation.pages.EspnHomePage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    @Test
    public void test(){
        EspnHomePage home =getEspnHomePage();
        home.login();
    }

}
