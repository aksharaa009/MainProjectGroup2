package StepDefenition;

import java.time.Duration;

import org.ict.base.TestBase;
import org.ict.pages.ContactUs;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class TestContact extends TestBase {
	ContactUs cu = null;
	
	@BeforeClass
    public void init() {
        cu = new ContactUs(driver);        
    }
	
	 
	 @Test(priority = 5)
	    public void clickContactLink() throws InterruptedException {
	        cu.clickContactLink();	        	  
	        String expectedUrl = prop.getProperty("contactpageurl"); 
	        String actualUrl = driver.getCurrentUrl();
	        AssertJUnit.assertEquals(actualUrl, expectedUrl, "http://64.227.132.109/LandingPage/contactus");
	        
	    }

	    @Test(priority = 6)
	    public void submitContactFormSuccessfully() throws InterruptedException {
	    try {
	    	
	    	cu.setName(prop.getProperty("username"));   
	        cu.setEmail(prop.getProperty("email"));
	        cu.setLooking(prop.getProperty("lookingFor"));
	        cu.setMessage(prop.getProperty("mesg"));
	        cu.clickSubmit();
	        Thread.sleep(1000);
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Alert Message: " + alert.getText());
	        String alertMessage = alert.getText();
	        AssertJUnit.assertEquals(alertMessage, "Message Send! Our Expert Team will Contact you Soon!");
            alert.accept();
	    } catch (UnhandledAlertException e) {
	        handleAlert();
	    }
	}
	    
	    private void handleAlert() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            wait.until(ExpectedConditions.alertIsPresent());
	            Alert alert = driver.switchTo().alert();
	            Thread.sleep(2000);
	            System.out.println("Alert Text: " + alert.getText());
	            alert.accept();
	        } catch (Exception e) {
	            System.out.println("No alert present");
	        }
	    }

	    
	    @Test(priority = 7)
	    public void InvalidEmail() throws InterruptedException {
	    	try {
	        cu.setName(prop.getProperty("username"));
	        cu.setEmail(prop.getProperty("invalidEmail2"));
	        cu.setLooking(prop.getProperty("lookingFor"));
	        cu.setMessage(prop.getProperty("mesg"));
	        cu.clickSubmit();
	        Thread.sleep(1000);
	    }
	    	 catch(UnhandledAlertException e) {
		        	handleAlert();
		        }
	    }
	    	 @Test(priority = 7)
	 	    public void BlankForm() throws InterruptedException {
	 	    	
	 	        cu.setName("");
	 	        cu.setEmail("");
	 	        cu.setLooking("");
	 	        cu.setMessage("");
	 	        
	 	       WebElement sendButton = driver.findElement(By.xpath("//button[normalize-space()='Send Message']"));
	 	      
	 	      
	 	      try {
	 	          JavascriptExecutor executor = (JavascriptExecutor) driver;
	 	          executor.executeScript("arguments[0].click();", sendButton);
	 	      } catch (WebDriverException e) {
	 	          
	 	          System.out.println("Failed to click Send Message button.");
	 	          e.printStackTrace();
	 	      }
	 	      
	 	        Thread.sleep(1000);
	 	    }
}
	    

