package com.jacksonville.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OfficeLocatorSearchResultsMap extends BaseCommands/*extends BaseCommands*/{
	
	protected Select filterBy = null;
	protected Select searchFilter = null;
	
	protected Select getSearchFilter() {
		WebElement searchFilterElement = byXpath("//*[@id='searchfilter']");
		searchFilter = getSelectDropdown(searchFilterElement);
		return searchFilter;
	}
	
	
}
