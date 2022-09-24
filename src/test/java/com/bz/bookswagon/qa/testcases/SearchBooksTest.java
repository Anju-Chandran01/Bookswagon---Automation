package com.bz.bookswagon.qa.testcases;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.pages.HomePage;
import com.bz.bookswagon.qa.pages.LoginPage;
import com.bz.bookswagon.qa.pages.SearchBooks;
import com.bz.bookswagon.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBooksTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    SearchBooks searchBooksPage;
    TestUtil testUtil;

    public SearchBooksTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        testUtil = new TestUtil();
        loginPage = new LoginPage();
        searchBooksPage = new SearchBooks();
        homePage = loginPage.login(prop.getProperty("mobile"), prop.getProperty("pass"));
        searchBooksPage = homePage.searchBooksUsingSearchBar("Rich Dad Poor Dad");
    }

    @Test(priority = 1)
    public void searchBooksPageUrl_Test(){
        String url = searchBooksPage.verify_SearchBooks_url();
        Assert.assertEquals(url,"https://www.bookswagon.com/search-books/rich-dad-poor-dad");
    }

    @Test(priority = 2)
    public void searchBooks_AddToCart_Test(){
        searchBooksPage.searchBookAndAddToCart();
    }

    @Test(priority = 3)
    public void searchBooks_AddToCart_AddToWishlist_Test() throws InterruptedException {
        searchBooksPage = new SearchBooks();
        boolean checkBook = searchBooksPage.searchBook_AddToCart_AddToWishlist();
        Assert.assertTrue(checkBook);
    }

    @Test(priority = 4)
    public void searchBooks_AddToCart_PlaceAnOrder_Test(){
        searchBooksPage = new SearchBooks();
        boolean checkBook = searchBooksPage.searchBookAndPlaceOrder();
        Assert.assertTrue(checkBook);
    }

    @Test(priority = 5)
    public void searchBooks_AddToCart_RemoveFromCart_Test() throws InterruptedException {
        searchBooksPage = new SearchBooks();
        boolean checkBook = searchBooksPage.searchBook_AddToCart_RemoveFromWishlist();
        Assert.assertTrue(checkBook);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
