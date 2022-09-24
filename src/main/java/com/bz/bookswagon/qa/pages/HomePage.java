package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    Actions action = new Actions(driver);
    // pagefactory OR object repository

    @FindBy(id="inputbar")
    WebElement searchBar;

    @FindBy(id="btnTopSearch")
    WebElement searchButton;

    @FindBy(xpath="//h1[contains(text(),'My Account')]")
    WebElement pageHeading;

    @FindBy(id="ctl00_lblUser")
    WebElement userName;

    @FindBy(xpath="//a[@id='ctl00_lnkbtnLogout']")
    WebElement logOut;

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

    @FindBy(xpath="//label[@id='ctl00_lblWishlistCount']")
    WebElement wishlistLogo;

    @FindBy(id="ctl00_phBody_WishList_lvWishList_ctrl1_chkAdd")
    WebElement selectCheckbox;

    @FindBy(xpath="")
    WebElement addToWishlistButton;

    @FindBy(xpath="//input[@type='submit' and @value='Remove']")
    WebElement removeButton;


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

    public SearchBooks searchBooksUsingSearchBar(String bookName){
        searchBar.sendKeys(bookName);
        searchButton.click();
        return new SearchBooks();
    }

    // After search with Author name add particular book to wishlist
    public boolean searchBookAndAddToWishList(String authorName) {
        searchBar.sendKeys(authorName);
        searchButton.click();
        WebElement check = driver.findElement(By.linkText("Half Girlfriend"));
        if (check.isDisplayed()) {
            check.click();
            addToWishlistButton.click();
            return true;
        }else{
            return false;
        }
    }

    public void directRemoveFromWishlist(){
        wishlistLogo.click();
        driver.findElement(By.xpath("//a[normalize-space()='Ikigai']"));
        selectCheckbox.click();
        removeButton.click();
    }

    //logout
    public String logout() throws InterruptedException {
        action.moveToElement(userName).build().perform();
        Thread.sleep(3000);
        logOut.click();
        Thread.sleep(3000);
        return driver.getCurrentUrl();
    }
}
