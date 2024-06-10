package org.ict.pages;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {
	
	
	 WebDriver driver;

    @FindBy(xpath = "(//a[@id='dropdownMenuPages'])[3]")
    WebElement contactLink;
    
    @FindBy(xpath = "//input[@placeholder='Full Name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@placeholder='Email id']")
    WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='What you love']")
    WebElement lookingField;

    @FindBy(xpath = "//input[@id='message']")
    WebElement messageField;

    @FindBy(xpath = "//button[normalize-space()='Send Message']")
    WebElement sendButton;


    public ContactUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickContactLink() {
        contactLink.click();
    }

    public void setName(String name) {
        nameField.sendKeys(name);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public void setLooking(String looking) {
        lookingField.sendKeys(looking);
    }

    public void setMessage(String message) {
        messageField.sendKeys(message);
    }

    public void clickSubmit() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send Message']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendButton);
        sendButton.click();
    }
}