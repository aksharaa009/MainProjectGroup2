package org.ict.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBase {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();	
		driver.get("http://64.227.132.109/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	public void tearDown() 
	{
		if (driver != null) {
            driver.quit();
        }
		}
	

}
