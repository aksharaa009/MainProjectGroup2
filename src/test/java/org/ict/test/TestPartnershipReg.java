package org.ict.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.ict.base.TestBase;
import org.ict.pages.Partnership;
import org.openqa.selenium.Alert;

public class TestPartnershipReg extends TestBase {
	Partnership partnership=null;
	@Test
	public void partnership_reg()
	{
		partnership=new Partnership(driver);
		partnership.navmembership();
		partnership.navpartnership();
		partnership.partnershipRegistration();
		partnership.FULLname("Vijila");
		partnership.EMAIL("vijilapp755@gmail.com");
		partnership.PhoneNO("9526827623");
		partnership.FIRM("avcbn");
		partnership.ADDRESS("dfghjk");
		partnership.DISTRICT("edyfyugh");
		partnership.Office_space("edtyfugihj");
		partnership.employeeNo("restdyugioj");
		partnership.BriefReport("ertyughj");
		partnership.EXPECT("rtfygvhbjnm");
		partnership.PROMOTERS("a4se5dr6tf7yguhijo");
		partnership.Send_Msg();
		 String expectedMessage = "Registration Successful";
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		Assert.assertNotSame(alertMessage, expectedMessage, "Registration not successfull");
		 alert.accept();
		
	}


}
