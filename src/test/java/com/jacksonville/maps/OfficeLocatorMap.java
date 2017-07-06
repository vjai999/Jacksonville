package com.jacksonville.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OfficeLocatorMap extends BaseCommands{
	
	protected WebElement cityStateZipField = null;
	protected Select searchFilter = null;
	protected WebElement lbSearch = null;

	
	protected WebElement getCityStateZipField() {
		
		cityStateZipField = byXpath("//*[@id='txtZip']");
		return cityStateZipField;
	}
	
	protected Select getSearchFilter() {
		WebElement searchFilterElement = byXpath("//*[@id='searchfilter']");
		searchFilter = getSelectDropdown(searchFilterElement);
		return searchFilter;
	}

	public WebElement getLbSearch() {
		
		lbSearch = byXpath("//*[@id='lbSearch']");
		return lbSearch;
	}

	
}
