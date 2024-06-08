package org.ict.pages;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageCourses {
	 WebDriver driver;
	
	 
	    @FindBy(id = "dropdownMenuBlocks")
	    WebElement courseDropdown;

	    @FindBy(id = "listSearch")
	    WebElement searchBox;

	    @FindBy(css = "button.btn.bg-gradient-dark.w-100.mb-0")
	    WebElement btnSearch;
	    
	    @FindBy(css = "img.w-100.border-radius-md.mb-7[src='uploads/image-1690684876081.png']")
	    WebElement courseImg;
	    
	    @FindBy(css = "button.btn.btn-info.btn[tabindex='0']")
	    WebElement knowMoreBut;
	    
	    @FindBy(css = "button.btn.bg-gradient-success.w-auto.me-2.ng-star-inserted")
	    WebElement applyNowButton;
	    
	    @FindBy(css = "input[name='name'][placeholder='Name']")
	    WebElement nameInputField;
	    
	    @FindBy(css = "input[type='email'][name='email'][placeholder='Email']")
	    WebElement emailInputField;
	    
	    @FindBy(css = "input[type='text'][name='phoneno'][placeholder='Number']")
	    WebElement phoneNumberInputField;
	    
	    @FindBy(css = "button[type='submit'].btn.bg-gradient-primary.w-100.mt-4.mb-0")
	    public WebElement registerButton;
	    
	    @FindBy(css = "a[data-bs-toggle='modal'][data-bs-target='#exampleModalForm']")
	    WebElement loginButton;
	    
	    @FindBy(css = "input[name='email']")
	    WebElement loginUsername;
	    
	    @FindBy(css = "input[name='password']")
	    WebElement passwordInput;
	    
	    @FindBy(css = "button.btn.bg-gradient-info[type='submit']")
	    WebElement signInButton;
	    
	    @FindBy(xpath="//div[@class='card-body pb-3']")
	    public WebElement InactiveRegister;
	 
	 public LandingPageCourses(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }

	 
	 public void clickdropDown()
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     courseDropdown.click();
	 }
	 
	 public void enterCourse(String courseName)
	 {    
		 Actions actions = new Actions(driver);
		 actions.moveToElement(searchBox).perform();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 searchBox.sendKeys(courseName);
		 
	 }
	 public void btnClick()
	 {
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
		 btnSearch.click();
		 
	 }
	 public void courseImageClick() {
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		   
		    js.executeScript("arguments[0].scrollIntoView(true);", courseImg);

		    js.executeScript("window.scrollBy(0, 250);");

		    try {
		        Thread.sleep(500); 
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		    courseImg.click();
		}

	 public void knowMoreButClick() throws InterruptedException
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", knowMoreBut);
		 knowMoreBut.click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 Thread.sleep(6000);
		 
	 }
	 
	 public void applyNowButtonClick() throws InterruptedException
	 {
		 applyNowButton.click();
		 Thread.sleep(2000);
	 }
	 
	 public void enterName(String name) throws InterruptedException
	 {
		 nameInputField.sendKeys(name);
		 //Thread.sleep(2000);
	 }
	 public void enterEmail(String email) {
	        emailInputField.sendKeys(email);
	    }
	 
	 public void enterPhoneNumber(String phoneNumber) throws InterruptedException
	 {
	        phoneNumberInputField.sendKeys(phoneNumber);
	        Thread.sleep(2000);
	    }
	 public void clickRegButton()
	 {
		 registerButton.click();
		 Alert alert = driver.switchTo().alert();
		 alert.accept();
	 }
	  
	 public void loginClick() throws InterruptedException
	 {
		 loginButton.click();
		 Thread.sleep(2000);
	 }
	 
	 public void enterUsernameLogin(String email)
	 {
		 loginUsername.sendKeys(email);
	 }
	 
	 public void enterPasswordLogin(String password) throws InterruptedException
	 {
		 passwordInput.sendKeys(password);
		 Thread.sleep(2000);
	 }
	 
	 public void loginbutClick()
	 {
		 signInButton.click();
	 }
	 
	 public void inactiveRegClick()
	 {
		 InactiveRegister.click();
	 }
	 
	 
	 

}
