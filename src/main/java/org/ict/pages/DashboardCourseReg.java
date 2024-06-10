package org.ict.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardCourseReg {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@class='stati bg-peter_river']//div//b")
    WebElement numberElement;
	
	@FindBy(css = "a.nav-link.text-white[aria-controls='ProfileNav']")
    public WebElement adminLink;
	
	
	//@FindBy(css = "a.nav-link.text-white .sidenav-normal:contains('Logout')")
	@FindBy(xpath ="//ul[@class='nav']//a[@class='nav-link text-white']")
    WebElement logoutLink;
	
	@FindBy(xpath = "//a[@routerlink='/adminpage/registered-users']")
    WebElement courseRegistrationLink;
	
	@FindBy(xpath = "//h4[contains(text(),'Course Registered Users')]")
    WebElement pageHeading;
	
	@FindBy(xpath = "//table[@id='excel-table']")
	WebElement table;
	
	@FindBy(xpath="//button[@class='btn bg-gradient-primary btn-sm mb-0']")
	WebElement downloadBtn;
    
	
	public DashboardCourseReg(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }
  
	public int getNumberOfRegistrations() throws InterruptedException {
	    Thread.sleep(2000);
	    String text = numberElement.getText().trim();
	    return text.isEmpty() ? 0 : Integer.parseInt(text);
	}

	
	public void clickAdmin() throws InterruptedException {
		adminLink.click();
		Thread.sleep(2000);
	}
	
	public void clickLogout()
	{
		logoutLink.click();
	}
	
	public void clickCourseRegistration() throws InterruptedException 
	{
        courseRegistrationLink.click();
        Thread.sleep(2000);
    }


    public String getCourseRegistrationLinkText()
    {
        return courseRegistrationLink.getText();
       
    }
    
    public String getPageHeadingText()
    {
        return pageHeading.getText();
        
    }
    
    public boolean isDataPresent(String name, String phoneNumber, String email) throws InterruptedException {
       
    	Thread.sleep(5000);
    	  List<WebElement> rowsList = table.findElements(By.tagName("tr"));


                  for (WebElement row : rowsList) {
                	  List<WebElement> cells = row.findElements(By.tagName("td"));
                	  if (cells.size() > 0) {
                		  String rowName = cells.get(1).getText().trim();
                	        String rowPhoneNumber = cells.get(2).getText().trim();
                	        String rowEmail = cells.get(3).getText().trim();
                	        if (rowName.equalsIgnoreCase(name) && rowPhoneNumber.equals(phoneNumber) && rowEmail.equalsIgnoreCase(email)) {
                                return true;            
                	        }
                	  }
                  }
        return false;
    }
    
    public void clickDownload() throws InterruptedException 
    {
    	Thread.sleep(3000);
    	downloadBtn.click();
    	
    }
    
    
}
	
	

