package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBooks extends TestBase {

    TestUtil testUtil;

    @FindBy(xpath="//input[@value='Buy Now']")
    WebElement buyNowButton;

    @FindBy(xpath="//input[@name='BookCart$lvCart$imgPayment']")
    WebElement placeOrderButton;

    // initialising page objects
    public SearchBooks() {
        PageFactory.initElements(driver, this);
    }

    public String verify_SearchBooks_url(){
        return driver.getCurrentUrl();
    }

    // After search add book to cart
    public void searchBookAndAddToCart() {
        WebElement check = driver.findElement(By.xpath("//a[normalize-space()='Rich Dad Poor Dad']"));
        if (check.isDisplayed()) {
            check.click();
            buyNowButton.click();
        }
    }


    // After search, add book to cart and place an order
    public boolean searchBookAndPlaceOrder(String bookName) {
        WebElement check = driver.findElement(By.xpath("//a[normalize-space()='Rich Dad Poor Dad']"));
        if (check.isDisplayed()) {
            check.click();
            buyNowButton.click();
            try {
                Thread .sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.switchTo().frame(0);
            placeOrderButton.click();
            return true;
        }else{
            return false;
        }
    }
}
