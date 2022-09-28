package com.bz.bookswagon.qa.testcases;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.pages.HomePage;
import com.bz.bookswagon.qa.pages.LoginPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    Logger log = Logger.getLogger(LoginPageTest.class);

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        log.info("Chrome is launching..");
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com");
    }

    @Test(priority = 2)
    public void loginPageUrlTest(){
        String url = loginPage.validate_LoginPage_Url();
        Assert.assertEquals(url,"https://www.bookswagon.com/login");
    }

    @Test(priority = 3)
    public void loginButtonTest(){
        boolean flag = loginPage.validate_LoginPage_LoginButton();
        Assert.assertTrue(flag);
    }

    @Test(priority = 4)
    public void loginTest(){
        homePage = loginPage.login(prop.getProperty("mobile"), prop.getProperty("pass"));
    }

//    @Test(priority = 5)
//    public void invalidLoginTest(){
//        boolean flag = loginPage.invalidLogin(prop.getProperty("mobile"), prop.getProperty("pass"));
//        Assert.assertFalse(flag);
//    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
