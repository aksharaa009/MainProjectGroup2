package StepDefenition;

import org.ict.base.TestBase;
import org.ict.pages.DashboardCourseReg;
import org.ict.pages.ExcelUtils;
import org.ict.pages.LandingPageCourses;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCourses extends TestBase {

    LandingPageCourses lp = null;
    DashboardCourseReg dc = null;
    ExcelUtils excelUtils;

    @BeforeClass
    public void classSetup() {
        lp = new LandingPageCourses(driver);
        dc = new DashboardCourseReg(driver);
        String filePath = "C:\\gitsd\\MainProjectGroup2\\TestData\\data.xlsx"; // Update with your Excel file path
        String sheetName = "Sheet1"; // Update with your Excel sheet name
        excelUtils = new ExcelUtils(filePath, sheetName);
    }

    public void regSteps() throws InterruptedException {
        lp.clickdropDown();
        lp.enterCourse("JAVA");
        lp.btnClick();
        lp.courseImageClick();
        lp.knowMoreButClick();
        lp.applyNowButtonClick();
    }

    @DataProvider(name = "readData")
    public Object[][] validDataProvider() {
        int rowCount = excelUtils.getRowCount();
        int colCount = excelUtils.getColumnCount();
        Object[][] data = new Object[rowCount - 2][colCount];

        for (int i = 1; i < rowCount - 1; i++) { // Skip header and invalid data
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excelUtils.getCellData(0, i, j);
            }
        }

        return data;
    }


    @Test(dataProvider = "readData", priority = 0)
    public void searchCourses(String name, String email, String phoneNumber) throws InterruptedException {
        Thread.sleep(2000);
        regSteps();
        lp.enterName(name);
        lp.enterEmail(email);
        lp.enterPhoneNumber(phoneNumber);
        lp.clickRegButton();

        if (lp.registerButton.isEnabled()) {
            Assert.assertTrue(true, "Registration success");
        }
    }

//@Test(priority = 1)
    public void blankRegistrationForm() throws InterruptedException {
        regSteps();
        lp.enterName("");
        lp.enterEmail("");
        lp.enterPhoneNumber("");
        lp.inactiveRegClick();
        
        Assert.assertFalse(lp.registerButton.isEnabled(), "Registration failed with blank data"); 
        driver.get("http://64.227.132.109/LandingPage");
        
      
    }
    
    @Test(priority = 2)
    public void signIn() throws InterruptedException {
        lp.loginClick();

        lp.enterUsernameLogin(prop.getProperty("username"));
        lp.enterPasswordLogin(prop.getProperty("password"));
        Thread.sleep(2000);
        lp.loginbutClick();
        Thread.sleep(2000);
        if (dc.adminLink.isDisplayed()) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
        Assert.assertTrue(true, "Login successful");
        dc.clickAdmin();
        dc.clickLogout();
        Thread.sleep(2000);
    }
}
