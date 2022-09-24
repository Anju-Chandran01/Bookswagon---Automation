package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import com.bz.bookswagon.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBooks extends TestBase {

    ShippingAddress shippingAddress;

    @FindBy(xpath="//input[@value='Buy Now']")
    WebElement buyNowButton;

    @FindBy(xpath="//input[@name='BookCart$lvCart$imgPayment']")
    WebElement placeOrderButton;

    @FindBy(id="BookCart_lvCart_ctrl0_btnMovetoWishlist")
    WebElement moveToWishlistFromCart;

    @FindBy(id="BookCart_lvCart_ctrl0_imgDelete")
    WebElement removeFromCart;


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

    // After search, add book to cart and add to wishlist from cart
    public boolean searchBook_AddToCart_AddToWishlist() throws InterruptedException {
        WebElement check = driver.findElement(By.xpath("//a[normalize-space()='Rich Dad Poor Dad']"));
        if (check.isDisplayed()) {
            check.click();
            buyNowButton.click();
            Thread .sleep(8000);
            driver.switchTo().frame(0);
            Thread.sleep(8000);
            moveToWishlistFromCart.click();
            return true;
        }else{
            return false;
        }
    }

    // After search, add book to cart and remove from cart
    public boolean searchBook_AddToCart_RemoveFromWishlist() throws InterruptedException {
        WebElement check = driver.findElement(By.xpath("//a[normalize-space()='Rich Dad Poor Dad']"));
        if (check.isDisplayed()) {
            check.click();
            buyNowButton.click();
            Thread .sleep(8000);
            driver.switchTo().frame(0);
            Thread.sleep(8000);
            removeFromCart.click();
            return true;
        }else{
            return false;
        }
    }

    // After search, add book to cart and place an order
    public boolean searchBookAndPlaceOrder() {
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
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            placeOrderButton.click();
            try {
                shippingAddress.FillAddressDetails();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }else{
            return false;
        }
    }
}
