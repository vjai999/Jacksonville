package com.jacksonville.maps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jacksonville.utilities.BySizzle;

public class BaseCommands extends BySizzle{
	
	//Root Web Driver.
	protected List<WebElement> elementsListWithTagName = null;
	protected Actions actions = null;

	//timeout for element visibility.
	protected WebElement waitForElementVisibility(WebElement element) {
		driver = basetest.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	//getting Select element by passing webElement
	protected Select getSelectDropdown(WebElement element) {
		Select select = new Select(element);
		return select;
	}
	
	//getting tags count using tag name.
	public int getTagCount(String tagName) {
		int count = 0;
		driver = basetest.getDriver();
		List<WebElement> elementsListWithTagName = null;
		if (null != driver) {
			elementsListWithTagName = driver.findElements(By.tagName(tagName));
			count = elementsListWithTagName.size();
		}
		return count;
	}
	
	//getting tags count using tag name, attribute.
	public int getTagCount(String tagName, String attributrName, String attributeValue) {
		int count = 0;
		driver = basetest.getDriver();
		String cssSelector = tagName + "[" + attributrName + "=" + attributeValue + "]";
		if (null != driver) {
			elementsListWithTagName = driver.findElements(By.cssSelector(cssSelector));
			count = elementsListWithTagName.size();
		}
		return count;
	}
	
	//clcking the nth index of tag name in t=current page.
	public void clickNthTagOfPage(String tagName, int tagIndexNeedToBeClicked) {
		driver = basetest.getDriver();
		try{
			elementsListWithTagName = driver.findElements(By.tagName(tagName));
			if(null!= elementsListWithTagName){
				int tagCount = elementsListWithTagName.size();
				if(tagCount > tagIndexNeedToBeClicked){
					WebElement elementNeedToBeClicked = elementsListWithTagName.get(tagIndexNeedToBeClicked);
					elementNeedToBeClicked.click();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//checking wether a WebElement is selected or not.
	public boolean isSelected(WebElement element) {
		if(null != element){
			return element.isSelected();
		}
		return false;
	}
	
	//checking wether a WebElement is displayed or not.
	public boolean isSDisplayed(WebElement element) {
		if(null != element){
			return element.isDisplayed();
		}
		return false;
	}
	
	//checking wether a WebElement is enabled or not.
	public boolean isEnabled(WebElement element) {
		if(null != element){
			return element.isEnabled();
		}
		return false;
	}
	
	//get attribute of an WebElement.
	public String getAttr(WebElement element, String attribute) {
		String attrVal = null;
		if(null != element){
			 attrVal = element.getAttribute(attribute);
		}
		return attrVal;
	}
	
	//accept alert.
	public void acceptAlert() {
		driver = basetest.getDriver();
		if(null != driver){
			driver.switchTo().alert().accept();
		}
	}
	
	//dismiss alert.
	public void dismissAlert() {
		driver = basetest.getDriver();
		if(null != driver){
			driver.switchTo().alert().dismiss();
		}	
	}
	
	//get text of an alert box.
	public String getTextOfAlert() {
		driver = basetest.getDriver();
		String text = null;
		if(null != driver){
			text = driver.switchTo().alert().getText();
		}	
		return text;
	}
	
	//send data into an alert box.
	public void sendDataIntoAlert(String data) {
		driver = basetest.getDriver();
		if(null != driver && null != data){
			driver.switchTo().alert().sendKeys(data);
		}	
	}
	
	//It will return you with Actions class.
	public Actions getActions(WebDriver driver) {
		driver = basetest.getDriver();
		if(null != driver){
			actions = new Actions(driver);	
		}
		return actions;
	}
	
	public void scrolldownUtiity(WebElement element) {
		driver = basetest.getDriver();
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
