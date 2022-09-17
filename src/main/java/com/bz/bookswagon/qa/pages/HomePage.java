package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    // pagefactory OR object repository

    @FindBy(id="inputbar")
    WebElement searchBar;

    @FindBy(id="btnTopSearch")
    WebElement searchButton;

    @FindBy(xpath="//h1[contains(text(),'My Account')]")
    WebElement pageHeading;

    @FindBy(xpath="//a[normalize-space()='My Account']")
    WebElement myAccount;

    @FindBy(xpath="//a[normalize-space()='Personal Settings']")
    WebElement personalSettings ;

    @FindBy(xpath="//a[normalize-space()='My Orders']")
    WebElement myOrders;

    @FindBy(xpath = "//a[normalize-space()='My Wishlist")
    WebElement myWishlist;

    @FindBy(xpath="//a[normalize-space()='My Gift Certificates']")
    WebElement myGiftCertificates;

    @FindBy(xpath="//a[normalize-space()='My Addresses']")
    WebElement myAddresses;

    @FindBy(xpath="//a[normalize-space()='Change Password']")
    WebElement changePassword;

    //initialising page objects
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //actions
    public String validate_HomePage_Url(){
        return driver.getCurrentUrl();
    }

    public boolean validate_HomePage_Heading(){
        return pageHeading.isDisplayed();
    }

    public SearchBooksPage searchBooksUsingSearchBar(String bookName){
        searchBar.sendKeys(bookName);
        searchButton.click();
        return new SearchBooksPage();
    }
}
