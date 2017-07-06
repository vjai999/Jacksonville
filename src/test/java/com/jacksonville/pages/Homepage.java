package com.jacksonville.pages;

import org.openqa.selenium.interactions.Actions;

import com.jacksonville.maps.BaseCommands;
import com.jacksonville.maps.HomepageMap;

public class Homepage extends HomepageMap{
	
	BaseCommands bc = new BaseCommands();
	
	public void clickFindAnOffice() {
		if(null != getFindAnOffice()){
			getFindAnOffice().click();
		}
	}
	public int getLinksCount() {
		return bc.getTagCount("a");
	}
	
	public int getTagsCount(String tagName) {
		return bc.getTagCount(tagName);
	}
	
	public int getTagsCount(String tagName, String attribute, String value) {
		return bc.getTagCount(tagName,attribute,value);
	}
	
	public void clickNThLink(String tagName, int index) {
		bc.clickNthTagOfPage(tagName, index);
	}
	
	public void hoverDownArrow() {
		driver = basetest.getDriver();
		Actions act = getActions(driver);
		act.moveToElement(getDownArrow()).build().perform();
	}
	
	public void clickLearnAboutMyJHLink() {
		hoverDownArrow();
		getLearnAboutMyJHLink().click();
	}
	
	public void clickCheckStatusLink() {
		hoverDownArrow();
		getCheckStatusLink().click();
	}
	
	public void clickManageDocumentsLink() {
		hoverDownArrow();
		getManageDocumentsLink().click();
	}
	
	public void clickNotificationsLink() {
		hoverDownArrow();
		getNotificationsLink().click();
	}
	
	public void clickFileOnlineLink() {
		hoverDownArrow();
		getFileOnlineLink().click();
	}
	
	public void hoverFacebookElement() {
		driver = basetest.getDriver(); 
		Actions act = getActions(driver);
		act.moveToElement(getFacebookElement()).build().perform();
	}
	
	public boolean startNowElementIsDisplayed() {
		return bc.isSDisplayed(getStartNowElement());
	}
}
