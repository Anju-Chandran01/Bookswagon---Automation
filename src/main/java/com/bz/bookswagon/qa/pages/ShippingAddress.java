package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Properties;

public class ShippingAddress extends TestBase{

    public static Properties prop;

    @FindBy(id = "ctl00_cpBody_txtNewRecipientName")
    WebElement recipientName;

    @FindBy(id = "ctl00_cpBody_txtNewCompanyName")
    WebElement companyName;

    @FindBy(id = "ctl00_cpBody_txtNewAddress")
    WebElement address;

    @FindBy(id = "ctl00_cpBody_txtNewLandmark")
    WebElement landmark;

    @FindBy(id = "ctl00_cpBody_ddlNewCountry")
    WebElement country;

    @FindBy(id = "ctl00_cpBody_ddlNewState")
    WebElement state;

    @FindBy(id = "ctl00_cpBody_ddlNewCities")
    WebElement city;

    @FindBy(id = "ctl00_cpBody_txtNewPincode")
    WebElement zipCode;

    @FindBy(id = "ctl00_cpBody_txtNewMobile")
    WebElement phone;

    @FindBy(id = "ctl00_cpBody_imgSaveNew")
    WebElement saveButton;

    public ShippingAddress() {
        PageFactory.initElements(driver, this);
    }

    public void FillAddressDetails() throws InterruptedException {
        recipientName.sendKeys(prop.getProperty("recipientName"));
        companyName.sendKeys(prop.getProperty("companyName"));
        address.sendKeys(prop.getProperty("recipientAddress"));
        landmark.sendKeys(prop.getProperty("landMark"));
        country.click();
        Select select = new Select(country);
        select.selectByVisibleText(prop.getProperty("recipientCountry"));
        state.click();
        Select select2 = new Select(state);
        select2.selectByVisibleText(prop.getProperty("recipientState"));
        city.click();
        Select select3 = new Select(city);
        select3.selectByVisibleText(prop.getProperty("recipientCity"));
        zipCode.sendKeys(prop.getProperty("recipientPin"));
        phone.sendKeys(prop.getProperty("recipientPhone"));
        saveButton.click();
    }
}
