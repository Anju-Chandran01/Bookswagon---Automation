package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBooksPage extends TestBase {

    @FindBy(xpath="//input[@value='Buy Now']")
    WebElement buyNowButton;

    @FindBy(id = "BookCart_lvCart_imgPayment")
    WebElement placeOrderButton;

    //initialising page objects
    public SearchBooksPage() {
        PageFactory.initElements(driver, this);
    }

    public void searchBook() {
        WebElement check = driver.findElement(By.xpath("//a[normalize-space()='Wings of Fire']"));
        if (check.isDisplayed()) {
            check.click();
            buyNowButton.click();
            placeOrderButton.click();
//            webdriver.switchTo().frame(1);
//            placeOrder.click();
        }
    }
}
