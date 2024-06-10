package org.ict.pages;

import java.time.Duration;

import org.ict.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CorporateMembershipAdminPage extends TestBase {

	WebDriver driver;

	public CorporateMembershipAdminPage(WebDriver driver) { //---->constructor
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//--------------------------------login---------------------------------->

	@FindBy(xpath="//a[@data-bs-toggle='modal' and @data-bs-target='#exampleModalForm']")
	WebElement login;
	public void loginPopupBtn() {
		login.click(); 
	}

	@FindBy(xpath="//input[@name='email' and @required and contains(@class, 'form-control')]")
	WebElement uname;
	public void loginUsername(String name) {
		uname.sendKeys(name);
	}
	@FindBy(name="password")
	WebElement pass;
	public void loginPassword(String passsword) {
		pass.sendKeys(passsword); 
	}

	@FindBy(xpath="//button[contains(@class, 'btn') and contains(@class, 'bg-gradient-info')]")
	WebElement btn;
	public void loginButtonClick() {
		btn.click(); 
	}
	public  String dashboardHeading() {

		WebElement txt=driver.findElement(By.xpath("//h4[@class='font-weight-bolder mb-0']"));
		String heading=txt.getText();
		return heading;
	}

	//--------------------------------admin page - search bar---------------------------------->

	@FindBy(name="search")
	WebElement search;
	public void searchBarInput(String keyword) {
//		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.sendKeys(keyword); 
	}
	
	public  String corporateMemHeading() {

		WebElement txt=driver.findElement(By.xpath("//h4[@class='font-weight-bolder mb-0']"));
		String title=txt.getText();
		return title;
	}

	//--------------------------------admin page - download---------------------------------->

	@FindBy(xpath="//a[@routerlink='/adminpage/corporate' and contains(@class, 'nav-link') and contains(@class, 'text-white')]")
	WebElement corporateMembership;
	public void corporateMembershipButton() {
		corporateMembership.click(); 
	}
	
	@FindBy(xpath="//button[contains(@class, 'btn') and contains(@class, 'bg-gradient-primary')]")
	WebElement download;
	public void downloadExcelButton(){
		download.click(); 
	}



}
