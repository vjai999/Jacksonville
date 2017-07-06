package com.jacksonville.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jacksonville.tests.BaseTest;

public class BySizzle{
	
	protected WebDriver driver = null;
	private WebElement element = null;
	
	protected BaseTest basetest = new BaseTest();

	public WebElement byXpath(String xpath) {
		try {
			driver = basetest.getDriver();
			if (null != driver) {
				element =  driver.findElement(By.xpath(xpath));
				element = waitForElementVisibility(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return element;
	}

	public WebElement byCssSelector(String cssSelector) {
		try{
			driver = basetest.getDriver();
			if (null != driver) {
				element =  driver.findElement(By.cssSelector(cssSelector));
				element = waitForElementVisibility(element);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return element;
	}
	
	
	
	private WebElement waitForElementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	
	
}
