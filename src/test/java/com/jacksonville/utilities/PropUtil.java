package com.jacksonville.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PropUtil {
	
	private Properties prop = null;
	private FileInputStream fis = null;
	private WebDriver driver = null;
	
	//it will load the properties file.
	public String getValue(String key) {
		prop = new Properties();
		try {
			fis = new FileInputStream("resourcess/testProperties.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	
	//you will get the browser based on the keyword that you mentioned in the properties file
	//acceptable keywords for browsers are chrome.. firefox..ie
	public WebDriver getBrowser() {
		String browser = getValue("browser");
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/Users/saiam/Downloads/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:/Users/saiam/Downloads/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:/Users/saiam/Downloads/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	
	//you will get a page source from where you call this method
	//and that code will save as .html in page sources folder
	//the name of the file will be pagetitle.html
	public void getPageSourceFile(WebDriver driver) {
		this.driver = driver;
		PrintWriter writer = null;
		String title = driver.getTitle();
		File file = new File("pageSources/"+title+".html");
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.write(driver.getPageSource());
	}
	
	public String getFileName() {
		StackTraceElement[] ste = Thread.currentThread().getStackTrace();
		String methodname = ste[ste.length - 2].getMethodName();
		String classname = ste[ste.length - 2].getFileName();
		String fileName = classname+"_"+methodname;
		if (fileName != null && fileName.length() > 0) {
			fileName.substring(0, fileName.length() - 5);
	    }
		return fileName;
	}
	
	public void takeScrrenshot(WebDriver driver, String name) {
		String filename = name;
		File actualScrrenshot = new File("test-output/ErrorScreenshots/"+filename+".png");
		File vertualScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(vertualScreenShot, actualScrrenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
