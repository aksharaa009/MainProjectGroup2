package org.ict.pages;

import java.time.Duration;

import org.ict.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorporateMembershipPage extends TestBase {

	WebDriver driver;

	public CorporateMembershipPage(WebDriver driver) {  //---->constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//----------locators-------------

	//-----------------------------TC_MP_002-----------------------------

	@FindBy(xpath="//a[@routerlink='/LandingPage/corporate']/h6[@class='dropdown-header text-dark font-weight-bolder d-flex justify-content-cente align-items-center p-0']")
	WebElement corporatePage;

	@FindBy(xpath="//button[@class='btn btn-white bg-white text-dark mt-3']")
	WebElement registerbtn;
	
	@FindBy(name = "name")
	WebElement nameField;
	
	@FindBy(name = "address")
	WebElement addressField;

	@FindBy(xpath="//*[@id=\"dropdownMenuDocs\"]")
	WebElement members_dropdown;
	
	@FindBy(name="head")
	WebElement HeadofOrgField;
	
	@FindBy(name="nature")
	WebElement natureOfOrg;
	
	@FindBy(name="website")
	WebElement website;
	
	@FindBy(xpath="//div[@class='input-group input-group-dynamic mb-4']/select[@formcontrolname='typeof']")
	WebElement company;
	
	@FindBy(name="identityNo")
	WebElement cin;
	
	@FindBy(name="GST")
	WebElement gst;
	
	@FindBy(name="nameofContact")
	WebElement namePoc;
	
	//-----------------------------------------TC_MP_003----------------------------------------------
	
	@FindBy(xpath="//input[@type='text' and @name='identityNo' and @formcontrolname='identityNo']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@type='text' and @name='email' and @formcontrolname='email']")
	WebElement email;
	
	@FindBy(name="employeeCount")
	WebElement emp;
	
	@FindBy(name="TechnicalSkill")
	WebElement skills;

	@FindBy(xpath="//input[@aria-autocomplete='list' and @type='text' and @autocorrect='off' and @autocapitalize='off']")
	WebElement collab;
	
	@FindBy(xpath="//select[@formcontrolname='patents']")
	WebElement patents;
	
	@FindBy(xpath="//select[@formcontrolname='hire']")
	WebElement pocAvg;
	
	@FindBy(xpath="//input[@type='text' and @name='details' and @formcontrolname='details']")

	WebElement act;
	
	@FindBy(xpath="//input[@type='submit' and @value='REGISTER' and contains(@class, 'btn btn-info w-100')]")
	WebElement regSubmit;
	

	
	
	
	public void membershipDropdown() {
		members_dropdown.click(); 
	}

	public void corpMembership() {
		corporatePage.click(); 
	}
		
	public void registerHereButton() {
		registerbtn.click();
	}

	//-----------------------------------------TC_MP_003----------------------------------------------
	
	public void registerName(String name) {
		nameField.sendKeys(name);
	}

	public void registerAddress(String address) {
		addressField.sendKeys(address);
	}

	public void headOfOrganization(String HO) {
		HeadofOrgField.sendKeys(HO);
	}

	public void natureOfOrganization(String nature) {
		natureOfOrg.sendKeys(nature);
	}

	public void website(String link) {
		website.sendKeys(link);
	}

	public void typeOfCompany(String comp) {
		Select dropdown = new Select(company);
		dropdown.selectByVisibleText(comp);
	}

	public void cinNum(String cinNo) {
		cin.sendKeys(cinNo);
	}

	public void gstNum(String gstNo) {
		gst.sendKeys(gstNo);
	}

	//<---------------------------------point of contact section --------------------------------->


	public void pocName(String pname) {
		namePoc.sendKeys(pname);
	}

	public void pocMob(String mob) {
		mobile.sendKeys(mob);
	}

	public void pocSkills(String skill) {
		skills.sendKeys(skill);
	}

	public void pocEmail(String pemail) {
		email.sendKeys(pemail);
	}

	public void pocEmpCount(String count) {
		emp.sendKeys(count);
	}

	public void pocCollaborate(String poc_collab) {
		collab.sendKeys(poc_collab);
		collab.sendKeys(Keys.RETURN);
	}
	
	public void pocPatents(String pocPat) {
		patents.sendKeys(pocPat);
	}
	
	public void pocAvgFresherHiring(String avg) {
		pocAvg.sendKeys(avg);
	}
	
	public void pocActivities(String activities) {
		act.sendKeys(activities);
	}
	
	public void registerSubmitButtonClick(){
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(regSubmit));
		regSubmit.click();
	}
	
//-------------------------Assertion methods-----------------------
	public  String corporateMembershipFormHeading() {
		
		WebElement txt=driver.findElement(By.xpath("//h3[contains(@class, 'text-center text-primary') and contains(text(), 'Corporate Membership Form')]"));
		String heading=txt.getText();
		return heading;
	}
	
	public String handleAlert() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	    String alertText = alert.getText();
	    System.out.println("Alert text is: " + alertText);
	    return alertText;
	}



}
