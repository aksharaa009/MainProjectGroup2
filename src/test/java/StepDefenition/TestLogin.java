package StepDefenition;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeoutException;

import org.ict.base.TestBase;
import org.ict.pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class TestLogin extends TestBase {

    LoginPage testObj = null;
    WebDriverWait wait;

    @BeforeClass
    public void init() {
        testObj = new LoginPage(driver);         
    }

    @AfterMethod
    public void clearForm() throws InterruptedException {
        Thread.sleep(1000); 
        testObj.usrname("");
        testObj.setPass("");
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 1)
    public void poslogin() throws InterruptedException {
        try {
            Thread.sleep(1000);
            testObj.clickLogin();
            testObj.usrname(prop.getProperty("validEmail"));            
            testObj.setPass(prop.getProperty("validPassword"));
            testObj.signInClick();
            wait.until(ExpectedConditions.urlContains("/adminpage"));
            String actualUrl = driver.getCurrentUrl();
            Thread.sleep(2000); 
            System.out.println("Current URL after valid login attempt: " + actualUrl);
            String expectedUrl = prop.getProperty("adminUrl");
            AssertJUnit.assertEquals(actualUrl, expectedUrl, "http://64.227.132.109/adminpage");
            testObj.adminClick();
            Thread.sleep(1000);
            testObj.signOutClick();

        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable.");
        } catch (UnhandledAlertException e) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
    }

    

    @Test(priority = 2)
    public void negInvalidCredentials() throws InterruptedException {
        Thread.sleep(1000);
        testObj.usrname(prop.getProperty("invalidEmail"));
        testObj.setPass(prop.getProperty("invalidPassword"));
        testObj.signInClick();

        Thread.sleep(2000); 
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL after invalid login attempt: " + actualUrl);

        String expectedUrl = prop.getProperty("landingPageUrl");
        AssertJUnit.assertEquals(actualUrl, expectedUrl, "http://64.227.132.109/LandingPage");
    }

    @Test(priority = 3)
    public void poslogin2() throws InterruptedException {
        Thread.sleep(1000);
        testObj.usrname(prop.getProperty("userEmail"));
        testObj.setPass(prop.getProperty("userPassword"));
        testObj.signInClick();

        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login attempt: " + actualUrl);

        String expectedUrl = prop.getProperty("landingPageUrl");
        AssertJUnit.assertEquals(actualUrl, expectedUrl, "http://64.227.132.109/LandingPage");
    }

    @Test(priority = 4)
    public void blankCredentials() throws InterruptedException {
        Thread.sleep(1000);
        testObj.usrname("");
        testObj.setPass("");
        testObj.signInClick();

        Thread.sleep(2000); 
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Current URL after invalid login attempt: " + actualUrl);

        String expectedUrl = prop.getProperty("landingPageUrl");
        AssertJUnit.assertEquals(actualUrl, expectedUrl, "http://64.227.132.109/LandingPage");
    }
}
    

   
   

      
  
   