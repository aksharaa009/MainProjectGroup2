package org.ict.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    
    @FindBy(xpath = "//a[@class='btn btn-sm bg-gradient-info mb-0 me-1 mt-2 mt-md-0']")
    WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Enter Your Email']")
	public
    WebElement unamebox;

    @FindBy(name="password")
	public
    WebElement passbox;

    @FindBy(xpath = "//button[normalize-space()='Sign in']")
	public
    WebElement signbut;

    @FindBy(css = "//a[@role='button']")
    WebElement adminLink;

    @FindBy(xpath = "//ul[@class='nav']//a[@class='nav-link text-white']")
    WebElement signoutbut;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void usrname(String name) {
        unamebox.sendKeys(name);
}

    public void setPass(String pass) {
        passbox.sendKeys(pass);
    }

    public void signInClick() {
        signbut.click();
    }

    public void adminClick() {
        adminLink.click();
    }

    public void signOutClick() {
        signoutbut.click();
    }

	

	
	}

	
