package StepDefenition;
import org.ict.base.TestBase;
import org.ict.constants.AutomationConstants;
import org.ict.pages.CorporateMembershipPage;
import org.ict.pages.EventsDropdown;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestEventsDropdown extends TestBase {

	EventsDropdown events;
	
	   @BeforeClass
	    public void setUp() {
		   events = new EventsDropdown(driver);
	    }

	@Test(priority=1)
	public void TC_MP_005() {
		events.clickOnEvents();
		events.clickOnICSETpage();
		String heading = events.icsetHeading();
		Assert.assertTrue(heading.contains(AutomationConstants.EXPECTED_ICSET_HEADING), "ICSET heading is not present on the page.");

	}

	@Test(priority=2)
	public void TC_MP_006() {
		events.clickOnHome();
		events.clickOnEvents();
		events.clickOnTechathlon();
		String heading = events.techathlonHeading();
		Assert.assertTrue(heading.contains(AutomationConstants.EXPECTED_TECHATHLON_HEADING), "Techathlon heading is not present on the page.");

	}
}
