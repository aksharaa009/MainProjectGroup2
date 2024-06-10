package org.ict.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUs {

    WebDriver driver;

    @FindBy(xpath = "(//a[@id='dropdownMenuPages'])[2]")
    public WebElement aboutLink;


    public AboutUs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAboutLink() {
        aboutLink.click();
    }

    public String getAboutUsLinkText() {
        return aboutLink.getText();
    }
}
   

   

	

