package com.bz.bookswagon.qa.testcases;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.pages.HomePage;
import com.bz.bookswagon.qa.pages.LoginPage;
import com.bz.bookswagon.qa.pages.RequestBook;
import com.bz.bookswagon.qa.pages.SearchBooks;
import com.bz.bookswagon.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RequestBookTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    RequestBook requestBook;

    public RequestBookTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("mobile"), prop.getProperty("pass"));
        requestBook = new RequestBook();
    }

    @Test(priority = 1)
    public void requestBooks_PageUrl_Test(){
        String url = requestBook.verify_RequestBook_url();
        Assert.assertEquals(url,"https://www.bookswagon.com/requestbook");
    }

    @Test(priority = 2)
    public void searchBooks_Heading_Test(){
        String heading = requestBook.verify_floatHeading();
        Assert.assertEquals(heading,"Request A Book");
    }

    @Test(priority = 3)
    public void fill_RequestBookForm_Test(){
        requestBook.fillRequest();
    }
}
