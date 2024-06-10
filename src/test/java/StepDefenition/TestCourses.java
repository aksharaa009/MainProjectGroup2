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
        String filePath = "C:\\gitsd\\MainProjectGroup2\\TestData\\data.xlsx"; 
        String sheetName = "Sheet1"; 
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

        for (int i = 1; i < rowCount - 1; i++) { 
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
        lp.loginClick();

        lp.enterUsernameLogin(prop.getProperty("username"));
        lp.enterPasswordLogin(prop.getProperty("password"));
        Thread.sleep(2000);
        lp.loginbutClick();
        Thread.sleep(2000);
        Assert.assertTrue(dc.adminLink.isDisplayed(), "Login successful");
        dc.clickAdmin();
        dc.clickLogout();
        Thread.sleep(2000);
    }
}
