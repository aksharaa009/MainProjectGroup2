package StepDefenition;
import org.ict.base.TestBase;
import org.ict.pages.AboutUs;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAboutUs extends TestBase {
	 AboutUs ap = null;
	 
	 @BeforeClass
	    public void init() {
	       ap = new AboutUs(driver);
	 }  
	 @Test(priority = 8)
	    public void aboutLink() {
		 ap.clickAboutLink();
	        String expectedUrl = driver.getCurrentUrl();
	        String actualUrl = driver.getCurrentUrl();
	        AssertJUnit.assertEquals(actualUrl, expectedUrl, "http://64.227.132.109/LandingPage/about");
	    }
	    
	    @Test(priority = 9)
	    public void verifyAboutUsLink() {
	    	ap.clickAboutLink();
	        String expectedText = "ABOUT US";
	        String actualText = ap.getAboutUsLinkText();
	        AssertJUnit.assertEquals(actualText, expectedText, "ABOUT US");
	    }
	}

