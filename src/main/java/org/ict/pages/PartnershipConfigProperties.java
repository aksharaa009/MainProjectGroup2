package org.ict.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PartnershipConfigProperties {
 Properties property;
String configpath="src/test/java/StepDefinition/config.properties";
public void initialisePropertyFile()
{
	property=new Properties();
	try {
		FileInputStream instm=new FileInputStream(configpath);
		property.load(instm);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
