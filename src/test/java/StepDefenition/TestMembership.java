package StepDefenition;



import org.ict.base.TestBase;
import org.ict.constants.AutomationConstants;
import org.ict.pages.CorporateMembershipPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestMembership extends TestBase {

	CorporateMembershipPage corporate;
	
    @BeforeClass
    public void setUp() {
    	corporate = new CorporateMembershipPage(driver);
    }


	@Test
	public void TC_MP_001() {
		corporate.membershipDropdown();
		corporate.corpMembership();
		corporate.registerHereButton();
			  String heading = corporate.corporateMembershipFormHeading();
		      Assert.assertTrue(heading.contains(AutomationConstants.EXPECTED_FORM_HEADING), "Corporate Membership heading is not present on the page.");
	}
	@Test
	public void TC_MP_002() throws InterruptedException{
		corporate.registerName("James Howlett");
		corporate.registerAddress("47F, Thomas St, New York 10011, USA");
		corporate.headOfOrganization("Rakesh Chopra");
		corporate.natureOfOrganization("Automotive Services");
		corporate.website("http://www.wappalyzer.com/");
		corporate.typeOfCompany("Private");
		corporate.cinNum("L-16328-TN-5623-PTC-161645");
		corporate.gstNum("55DC23544G1F693");

		corporate.pocName("Marks Jobs");
		corporate.pocMob("9489248632");
		corporate.pocSkills("Communication, Analytics, Creativity");
		corporate.pocEmail("arvvik24@gmail.com");
		corporate.pocEmpCount("10");
		corporate.pocCollaborate("Internships");
		corporate.pocPatents("1-10");
		corporate.pocAvgFresherHiring("1-10");
		corporate.pocActivities("Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum Lorem Ipsum 1010 .,''$ @ () + *");
		corporate.registerSubmitButtonClick();
			String alertText = corporate.handleAlert();
			Assert.assertTrue(alertText.contains(AutomationConstants.EXPECTED_POP_UP), "Registration successfull popup is not present on the page.");
	}




}
