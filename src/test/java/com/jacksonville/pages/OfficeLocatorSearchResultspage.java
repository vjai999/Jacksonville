package com.jacksonville.pages;

import org.openqa.selenium.support.ui.Select;

import com.jacksonville.maps.OfficeLocatorSearchResultsMap;

public class OfficeLocatorSearchResultspage extends OfficeLocatorSearchResultsMap{
	
	Select select = null;
	
//	public OfficeLocatorSearchResultspage(WebDriver driver) {
//		super(driver);
//		select = getSearchFilter();
//	}
	
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
		select = getSearchFilter();
		return select.getFirstSelectedOption().getText();
	}
	
}
