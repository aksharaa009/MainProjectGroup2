package StepDefenition;

import org.ict.base.TestBase;
import java.io.File;

import org.ict.pages.DashboardCourseReg;
import org.ict.pages.LandingPageCourses;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestRegList extends TestBase {
	LandingPageCourses lp=null;
	DashboardCourseReg dc=null;
	@BeforeClass
	public void classSetup()
	{
		lp = new LandingPageCourses(driver);	
		dc = new DashboardCourseReg(driver);
	}
	
	public void regSteps() throws InterruptedException
	{
		lp.clickdropDown();
		lp.enterCourse("JAVA");
		lp.btnClick();
		lp.courseImageClick();
		lp.knowMoreButClick();
		lp.applyNowButtonClick();
	}
	@Test(priority=4)
		public void testRegistrationIncreasesCount() throws InterruptedException {
			regSteps();
			lp.enterName("User");
			lp.enterEmail("aksharaa009@gmail.com");
			lp.enterPhoneNumber("0987654321");
			lp.clickRegButton();
			lp.loginClick();
			lp.enterUsernameLogin(prop.getProperty("username"));
			lp.enterPasswordLogin(prop.getProperty("password"));
			lp.loginbutClick();
			Thread.sleep(3000);
			int initialCount = dc.getNumberOfRegistrations();
			dc.clickAdmin();
			dc.clickLogout();
			regSteps();
			lp.enterName("User");
			lp.enterEmail("aksharaa009@gmail.com");
			lp.enterPhoneNumber("0987654321");
			lp.clickRegButton();
			lp.loginClick();
			lp.enterUsernameLogin(prop.getProperty("username"));
			lp.enterPasswordLogin(prop.getProperty("password"));
			lp.loginbutClick();
			Thread.sleep(3000);

			int finalCount = dc.getNumberOfRegistrations();


			Assert.assertEquals(finalCount, initialCount + 1, "Registration count  increased by 1");
		}

		@Test(priority=5)
		public void viewRegList() throws InterruptedException
		{
			dc.clickCourseRegistration();
			String linkText= dc.getCourseRegistrationLinkText();
			System.out.println(linkText);
			String headingText = dc.getPageHeadingText();
			System.out.println("Page Heading: " + headingText);
			String name = "User";
			String phoneNumber = "0987654321";
			String email = "aksharaa009@gmail.com";

			boolean isDataPresent = dc.isDataPresent(name, phoneNumber, email);

			if (isDataPresent) {
				System.out.println("The user data is present in the registration list.");
			} else {
				System.out.println("The user data is NOT present in the registration list.");
			}

			Assert.assertTrue(isDataPresent,"User data is located successfully");
		}

		@Test(priority=7)
		public void downloadFile() throws InterruptedException
		{
		
			dc.clickCourseRegistration();
			dc.clickDownload();

			String downloadDir = System.getProperty("user.home") + "\\Downloads";
			String expectedFileName = "ExcelSheet.xlsx";
			File downloadedFile = new File(downloadDir + "/" + expectedFileName);

			int waitTime = 30; 
			int elapsedTime = 0;
			while (!downloadedFile.exists() && elapsedTime < waitTime) {
				Thread.sleep(1000);
				elapsedTime++;
			}

			if (downloadedFile.exists()) {
				System.out.println("File downloaded successfully: " + downloadedFile.getAbsolutePath());
			} else {
				System.out.println("Failed to download the file within the specified time.");
			}
			Assert.assertTrue(downloadedFile.exists(), "The file was  downloaded successfully.");
			dc.clickAdmin();
			dc.clickLogout();

		}

	
	
	
	

}
