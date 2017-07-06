package com.jacksonville.tests;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jacksonville.utilities.PropUtil;

public class BaseTest {
	
	protected static WebDriver driver = null;
	protected PropUtil propUtil = null;
	protected String filename = null;
	
	@BeforeMethod(alwaysRun=true)
	public void setUp(Method method) {
		filename = method.getName();
		propUtil = new PropUtil();
		driver = propUtil.getBrowser();
		driver.get(propUtil.getValue("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		if(null != driver){
			driver.close();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

}


