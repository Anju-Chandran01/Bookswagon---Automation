package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArrivals extends TestBase {

    ShippingAddress shippingAddress;
    CheckOut checkOut;

    @FindBy(xpath = "//a[text()='New Arrivals']")
    WebElement newArrivalButton;

    @FindBy(xpath = "//img[@alt='Skin Revolution']")
    WebElement book;

    @FindBy(xpath = "//input[@value='Buy Now']")
    WebElement addToCart;

    @FindBy(xpath = "//input[@name ='BookCart$lvCart$imgPayment']")
    WebElement placeOrder;

    @FindBy(xpath = "//input[@id='ctl00_cpBody_imgSaveNew']")
    WebElement continueButton;

    @FindBy(xpath = "//label[@id='ctl00_lblTotalCartItems']")
    WebElement selectCart;

    @FindBy(xpath = "//div[@id='cboxClose']")
    WebElement closeWindow;

    // initialising page objects
    public NewArrivals() {
        PageFactory.initElements(driver, this);
    }

    public String verify_NewArrivals_url(){
        newArrivalButton.click();
        return driver.getCurrentUrl();
    }

    //method to place an order for book in new arrival
    public Boolean placeOrderForNewArrival() {
        try {
            newArrivalButton.click();
            book.click();
            addToCart.click();
            Thread.sleep(7000);
            driver.switchTo().frame(1);
            System.out.println("Enter inside frame");
            Thread.sleep(7000);
            placeOrder.click();
            Thread.sleep(7000);
            driver.switchTo().parentFrame();
            Thread.sleep(7000);
            continueButton.click();
            shippingAddress.FillAddressDetails();
            checkOut.checkOutFromCart();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
