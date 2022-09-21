package com.bz.bookswagon.qa.testcases;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.pages.HomePage;
import com.bz.bookswagon.qa.pages.LoginPage;
import com.bz.bookswagon.qa.pages.NewArrivals;
import com.bz.bookswagon.qa.pages.SearchBooks;
import com.bz.bookswagon.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewArrivalsTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    NewArrivals newArrivalsPage;
    TestUtil testUtil;


    public NewArrivalsTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("mobile"), prop.getProperty("pass"));
        newArrivalsPage = new NewArrivals();
    }

    @Test(priority = 1)
    public void searchBooksPageUrl_Test(){
        String url = newArrivalsPage.verify_NewArrivals_url();
        Assert.assertEquals(url,"https://www.bookswagon.com/promo-best-seller/new-arrivals/99325F010C89");
    }

    //test to check the functionality of new arrival module
    @Test(priority = 2)
    public void place_An_Order(){
        newArrivalsPage = new NewArrivals();
        Boolean check = newArrivalsPage.placeOrderForNewArrival();
        Assert.assertTrue(check);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


