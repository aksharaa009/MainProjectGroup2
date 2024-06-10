package org.ict.pages;

import org.ict.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PartnershipAdmin extends TestBase{
	private Actions actions;
	public PartnershipAdmin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	@FindBy(xpath="//a[@class='btn btn-sm bg-gradient-info mb-0 me-1 mt-2 mt-md-0']")
	WebElement partnerAdmin_login;

	@FindBy(name="email")
	WebElement partnerAdmin_email;
	
	@FindBy(name="password")
	WebElement partnerAdmin_password;
	
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement partnerAdmin_signin;
	
	//@FindBy(xpath="//a[@role='button']")
	//WebElement dashboard;
	@FindBy(css="#sidenav-collapse-main > ul > li > a")
	WebElement adminlink; 
			
	@FindBy(xpath="//a[@routerlink='/adminpage/partnership']")
	WebElement partnershipNavigation;
	
	@FindBy(xpath="//button[@class='btn bg-gradient-primary btn-sm mb-0']")
	WebElement download_excel;
	
	
	@FindBy(xpath="//a[@role='button']")
	WebElement partner_admin;
	
	@FindBy(xpath="//ul[@class='nav']//a[@class='nav-link text-white']")
	WebElement partneradmin_logout;
	
	
public void partnerAdminLogin()
{
	partnerAdmin_login.click();
}
public void PartnerAdminMail(String adminuserName)
{
	partnerAdmin_email.sendKeys(adminuserName);
}
public void partnerAdminPassword(String adminuserPassword)
{
	partnerAdmin_password.sendKeys(adminuserPassword);
}


public void PartnerAdminSignin() 
{
	
	partnerAdmin_signin.click();
	
}

public void ADMIN_Link() throws InterruptedException
{
	  adminlink.click();
	  Thread.sleep(5000);
}

	public void partnership_Navigation() 

{
		partnershipNavigation.submit();
		
	}

public void Download()
{
	download_excel.click();
}
public void Partner_Admin()
{
	partner_admin.click();
}
public void partneradminLogout()
{
	partneradmin_logout.click();
}
}










