package com.bz.bookswagon.qa.pages;

import com.bz.bookswagon.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    Actions action = new Actions(driver);

    // pagefactory OR object repository
    @FindBy(xpath="//span[@id='ctl00_lblUser']")
    WebElement login;

    @FindBy(id="ctl00_phBody_SignIn_txtEmail")
    //name = ctl00$phBody$SignIn$txtEmail
    WebElement userName;

    @FindBy(id="ctl00_phBody_SignIn_txtPassword")
    // name = ctl00$phBody$SignIn$txtPassword
    WebElement password;

    @FindBy(xpath = "//a[text()='Login']")
    WebElement loginButton;

    @FindBy(id="ctl00_phBody_SignIn_lblemailmsg")
    WebElement errorMessage;

    //initialising page objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //actions
    public String validate_LoginPage_Url(){
        action.moveToElement(login).click().build().perform();
        return driver.getCurrentUrl();
    }

    public boolean validate_LoginPage_LoginButton(){
        action.moveToElement(login).click().build().perform();
        return loginButton.isDisplayed();
    }

    public String validateLoginPageTitle(){
        action.moveToElement(login).click().build().perform();
        return driver.getTitle();
    }

    public HomePage login(String phoneNum, String pwd){
        action.moveToElement(login).click().build().perform();
        userName.sendKeys(phoneNum);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }

//    public boolean invalidLogin(String phoneNum, String pwd){
//        action.moveToElement(login).click().build().perform();
//        userName.sendKeys(phoneNum);
//        password.sendKeys(pwd);
//        loginButton.click();
//        return errorMessage.isDisplayed();
//    }
}
