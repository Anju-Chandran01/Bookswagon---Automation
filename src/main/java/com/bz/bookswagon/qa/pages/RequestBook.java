package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestBook extends TestBase {

    @FindBy(xpath="//h4[@class='floatheading']")
    WebElement floatHeading;

    @FindBy(id="ctl00_phBody_RequestBook_txtISBN")
    WebElement ISBN13;

    @FindBy(id="ctl00_phBody_RequestBook_txtTitle")
    WebElement bookTitle;

    @FindBy(id="ctl00_phBody_RequestBook_txtAuthor")
    WebElement author;

    @FindBy(id="ctl00_phBody_RequestBook_txtQty")
    WebElement quantity;

    @FindBy(id="ctl00_phBody_RequestBook_txtEmailReq")
    WebElement email;

    @FindBy(id ="ctl00_phBody_RequestBook_btnVeiry")
    WebElement verifyEmailButton;

    @FindBy(id="ctl00_phBody_RequestBook_txtPhone")
    WebElement phone;

    @FindBy(id="ctl00_phBody_RequestBook_imgbtnSave")
    WebElement submitButton;

    // initialising page objects
    public RequestBook() {
        PageFactory.initElements(driver, this);
    }

    public String verify_RequestBook_url(){
        return driver.getCurrentUrl();
    }

    public String verify_floatHeading(){
        String heading = floatHeading.getText();
        return heading;
    }

    // fill the request form
    public void fillRequest(){
        ISBN13.sendKeys("Fundamentals of Software Testing by DOROTHY");
        bookTitle.sendKeys("Fundamentals of Software Testing");
        author.sendKeys("DOROTHY");
        email.sendKeys("anjuchandrancs01@gmail.com");
//        verifyEmailButton.click();
        phone.sendKeys("7306096567");
        submitButton.click();
    }
}
