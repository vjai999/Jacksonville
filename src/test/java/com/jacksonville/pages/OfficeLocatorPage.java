package com.jacksonville.pages;

import org.openqa.selenium.support.ui.Select;

import com.jacksonville.maps.OfficeLocatorMap;

public class OfficeLocatorPage extends OfficeLocatorMap {
	
	Select select = null;
	
	public void sendTextIntoCityStateZipField(String text) {
		if (null != getCityStateZipField()) {
			getCityStateZipField().sendKeys(text);
		}
	}

	public void selectSearchFilterByIndex(int index) {
		select = getSearchFilter();
		select.selectByIndex(index);
	}
	
	public void selectSearchFilterByText(String text) {
		select = getSearchFilter();
		select.selectByVisibleText(text);
	}
	
	public void selectSearchFilterByValue(String value) {
		select = getSearchFilter();
		select.selectByValue(value);
	}
	
	public String getVisibleTextOfSearchFilterDropDown() {
		return select.getFirstSelectedOption().getText();
	}
	
	public void clickLbSearch() {
		if(null != getLbSearch()){
			getLbSearch().click();
		}
	}
}
