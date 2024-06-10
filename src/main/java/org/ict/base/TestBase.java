package org.ict.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class TestBase {
	
	public static WebDriver driver;
	
	public Properties prop=null;
	public void loadProp() throws IOException
	{
		prop=new Properties();
		FileInputStream fileip=new FileInputStream("C:\\gitsd\\MainProjectGroup2\\src\\test\\resources\\config.properties");
		prop.load(fileip);
	}
	   
		@BeforeClass
	    public void initialiseDriver() throws IOException
	    {
		        loadProp();
		        String browser = prop.getProperty("browser");
		        switch (browser) {
		            case "chrome":
		                driver = new ChromeDriver();
		                break;
		            case "firefox":
		                driver = new FirefoxDriver();
		                break;
		            default:
		                throw new RuntimeException("Unsupported browser specified in config.properties.");
		        }
		        
				  driver.get(prop.getProperty("url"));
				  driver.manage().window().maximize();
	    }
	@AfterClass
	public void tearDown() 
	{
		if (driver != null) {
            driver.quit();
        }
		}
	

}
