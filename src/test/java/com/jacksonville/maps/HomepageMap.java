package com.jacksonville.maps;

import org.openqa.selenium.WebElement;

public class HomepageMap extends BaseCommands{
	
	protected WebElement findAnOffice;
	protected WebElement downArrow;
	protected WebElement learnAboutMyJHLink;
	protected WebElement checkStatusLink;
	protected WebElement manageDocumentsLink;
	protected WebElement notificationsLink;
	protected WebElement fileOnlineLink;
	protected WebElement facebookElement;
	protected WebElement startNowElement;
	protected WebElement hoverElement;
	
	protected WebElement getFindAnOffice() {
		findAnOffice = byXpath("//*[@id='primary-nav']/ul/li[1]/label/a");
		return findAnOffice;
	}

	public WebElement getHoverElement() {
		hoverElement = byXpath("//*[@id='expand']/span[2]");
		return hoverElement;
	}
		
	protected WebElement getDownArrow() {
		downArrow = byXpath("//*[@id='expand']/span[2]");
		return downArrow;
	}

	protected WebElement getLearnAboutMyJHLink() {
		learnAboutMyJHLink = byXpath("//*[@id='my-jh-options']/ul/li[1]/a");
		return learnAboutMyJHLink;
	}

	protected WebElement getCheckStatusLink() {
		checkStatusLink = byXpath("//*[@id='my-jh-options']/ul/li[2]/a");
		return checkStatusLink;
	}

	protected WebElement getManageDocumentsLink() {
		manageDocumentsLink = byXpath("//*[@id='my-jh-options']/ul/li[3]/a");
		return manageDocumentsLink;
	}

	protected WebElement getNotificationsLink() {
		notificationsLink = byXpath("//*[@id='my-jh-options']/ul/li[4]/a");
		return notificationsLink;
	}

	protected WebElement getFileOnlineLink() {
		fileOnlineLink = byXpath("//*[@id='my-jh-options']/ul/li[5]/a");
		return fileOnlineLink;
	}

	public WebElement getFacebookElement() {
		facebookElement = byXpath("/html/body/div[5]/img[2]");
		return facebookElement;
	}

	public WebElement getStartNowElement() {
		startNowElement = byXpath("/html/body/div[5]/img[1]");
		return startNowElement;
	}
	
	
}
