package StepDefenition;

import java.io.File;

import org.ict.base.TestBase;
import org.ict.constants.AutomationConstants;
import org.ict.pages.CorporateMembershipAdminPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class TestMembershipAdminPage extends TestBase {

	CorporateMembershipAdminPage admin;

	@BeforeClass
	public void setUp() {
		admin = new CorporateMembershipAdminPage(driver);
	}

	@Test(priority=2)
	public void TC_MP_08(){
		admin.searchBarInput("Howlett");
	}

	@Test(priority=1)
	public void TC_MP_010() {
		admin.loginPopupBtn();
		admin.loginUsername("superadmin");
		admin.loginPassword("12345");
		admin.loginButtonClick();
		String heading = admin.dashboardHeading();
		Assert.assertTrue(heading.contains(AutomationConstants.EXPECTED_DASHBOARD_HEADING), "Dashboard heading is not present on the page.");
		admin.corporateMembershipButton();
		String title = admin.corporateMemHeading();
		Assert.assertTrue(title.contains(AutomationConstants.EXPECTED_CORPORATE_HEADING), "Corporate Membership heading is not present on the page.");;	
		admin.downloadExcelButton();
		String downloadDir = System.getProperty("user.home") + "\\Downloads";
		String expectedFileName = "ExcelSheet.xlsx";
		File downloadedFile = new File(downloadDir + "/" + expectedFileName);

		int waitTime = 30; 
		int elapsedTime = 0;
		while (!downloadedFile.exists() && elapsedTime < waitTime) {
			elapsedTime++;
		}

		if (downloadedFile.exists()) {
			System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
		} else {
			System.out.println("Failed to download the file within the specified time.");
		}
		Assert.assertTrue(downloadedFile.exists(), "The file was  downloaded successfully.");

	}
}
