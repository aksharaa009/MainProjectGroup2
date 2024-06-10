package org.ict.pages;

import org.ict.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsDropdown extends TestBase {

	WebDriver driver;
	
	public EventsDropdown(WebDriver driver) {  //---->constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//--------------------------------events dropdown---------------------------------->
	@FindBy(xpath="//h6[contains(@class, 'dropdown-header text-dark font-weight-bolder') and contains(text(), 'ICSET')]")
	WebElement icset;
	
	@FindBy(id = "dropdownMenuPages")
	WebElement home;
	
	@FindBy(xpath = "/html/body/app-root/app-home-main/app-header/div[1]/div/div/nav/div/div/ul/li[5]/a")
	WebElement events;
	
	@FindBy(xpath="//h6[contains(@class, 'dropdown-header text-dark font-weight-bolder') and contains(text(), 'Techathlon')]")
	WebElement techathlon;

	

	public void clickOnICSETpage() {
		icset.click(); 
	}

	public void clickOnEvents() {
		events.click(); 
	}
	public void clickOnTechathlon() {
		techathlon.click(); 
	}

	public void clickOnHome() {
		home.click(); 
	}
	public  String icsetHeading() {
		WebElement txt=driver.findElement(By.xpath("//h2[contains(@class, 'text-white') and contains(text(), 'ICSET')]"));
		String heading=txt.getText();
		return heading;
	}
	public  String techathlonHeading() {
		WebElement txt=driver.findElement(By.xpath("//h2[contains(@class, 'text-white') and contains(text(), 'Techathlon')]"));
		String heading=txt.getText();
		return heading;
	}
	



}
