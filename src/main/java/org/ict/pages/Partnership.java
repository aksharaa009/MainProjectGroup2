package org.ict.pages;

import org.ict.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

public class Partnership extends TestBase {

	public Partnership(WebDriver driver)
	{
		driver=this.driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(id="dropdownMenuDocs")
	WebElement membership;

	@FindBy(xpath="//*[contains(text(),'Partnership')]")
	WebElement partner_ship;

	@FindBy(xpath="//h1[normalize-space()='PARTNERSHIP']")
	WebElement PARTNERSHIP;

	@FindBy(xpath="//button[normalize-space()='Register Here']")
	WebElement Register;

	@FindBy(xpath="//h3[normalize-space()='PARTNERSHIP FORM']")
	WebElement partnershipForm;

	@FindBy(name="name")
	WebElement Fullname;

	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement Email;

	@FindBy(name="phone")
	WebElement phone_number;

	@FindBy(name="firm")
	WebElement Firm;

	@FindBy(name="address")
	WebElement Address;

	@FindBy(name="district")
	WebElement District;

	@FindBy(name="officeSpace")
	WebElement OfficeSpace;

	@FindBy(name="employeeCount")
	WebElement No_Of_Employees;

	@FindBy(xpath="/html/body/app-root/app-partenshipform/header/div[2]/section/div/div/div/div/div[2]/form/div/div[5]/textarea")
	WebElement brief_report;

	@FindBy(name="expect")
	WebElement Expect;

	@FindBy(name="profile")
	WebElement Promoters;

	@FindBy(xpath="//button[@value='Submit']")
	WebElement send_msg;


	public void navmembership()
	{
		membership.click();
	}

	public void navpartnership()
	{
		partner_ship.click();
	}
	

	public void partnershipRegistration()
	{
		Register.click();
	}

	

	public void FULLname(String name)
	{
		Fullname.sendKeys(name);
	}

	public void EMAIL(String mail)
	{
		Email.sendKeys(mail);
	}

	public void PhoneNO(String phone)
	{
		phone_number.sendKeys(phone);
	}

	public void FIRM(String firm1)
	{
		Firm.sendKeys(firm1);
	}

	public void ADDRESS(String addres)
	{
		Address.sendKeys(addres);
	}

	public void DISTRICT(String dt)
	{
		District.sendKeys(dt);
	}

	public void Office_space(String offcespace)
	{
		OfficeSpace.sendKeys(offcespace);
	}

	public void employeeNo(String empno)
	{
		No_Of_Employees.sendKeys(empno);
	}

	public void BriefReport(String report)
	{
		brief_report.sendKeys(report);
	}

	public void EXPECT(String expct)
	{
		Expect.sendKeys(expct);
	}

	public void PROMOTERS(String promotrs)
	{
		Promoters.sendKeys(promotrs);
	}


	public void Send_Msg()
	{
		send_msg.submit();
		

	}
	

}










