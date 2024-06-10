package org.ict.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.ict.base.TestBase;
import org.ict.constants.PartnershipAutomationConstants;
import org.ict.pages.PartnershipAdmin;


@Test
public class TestPartnershipAdmin extends TestBase {
	PartnershipAdmin partneradmin=null;
	
  public void partnership_Admin()
  {
	  
	  partneradmin=new PartnershipAdmin(driver);
	  partneradmin.partnerAdminLogin();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  partneradmin.PartnerAdminMail("superadmin");
	  partneradmin.partnerAdminPassword("12345");
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  partneradmin.PartnerAdminSignin();
	  try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String actresult=partneradmin.Dashboard();
	  Assert.assertEquals(actresult, PartnershipAutomationConstants.ExpectedHome3, "Dashboard page is loaded");
	 // String text=partneradmin.getDashboardText();
	  //boolean isDisplayed = partneradmin.isDashboardDisplayed();
	 // Assert.assertTrue(isDisplayed, "Dashboard should be displayed");
	//  partneradmin.partnership_Navigation();
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  partneradmin.Download();
	  partneradmin.Partner_Admin();
	  partneradmin.partneradminLogout();
  }
}
