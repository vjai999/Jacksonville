package com.jacksonville.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jacksonville.pages.Homepage;
import com.jacksonville.pages.OfficeLocatorPage;
import com.jacksonville.pages.OfficeLocatorSearchResultspage;

public class OfficeLocatorTests extends BaseTest{
	
	Homepage homepage = null;
	OfficeLocatorPage olp = null;
	
	
	@Test(groups={"functionalTests"})
	public void filterByOpenYourRoundTest() {	
		try {
			homepage = new Homepage();
			homepage.clickFindAnOffice();
			OfficeLocatorPage olp = new OfficeLocatorPage();
			olp.selectSearchFilterByIndex(1);
			olp.sendTextIntoCityStateZipField("38021");
			olp.clickLbSearch();
			
			OfficeLocatorSearchResultspage olsrp = new OfficeLocatorSearchResultspage();
			Assert.assertEquals(driver.getCurrentUrl(), propUtil.getValue("openyearroundurl"));
			Assert.assertEquals(propUtil.getValue("openyearround"), olsrp.getVisibleTextOfSearchFilterDropDown());
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
	
		
	}
	
	@Test(groups={"functionalTests"})
	public void filterByAllTest() {
		try {
			homepage = new Homepage();
			homepage.clickFindAnOffice();
			OfficeLocatorPage olp = new OfficeLocatorPage();
			olp.selectSearchFilterByText("All");
			olp.sendTextIntoCityStateZipField("38021");
			olp.clickLbSearch();
			
			OfficeLocatorSearchResultspage olsrp = new OfficeLocatorSearchResultspage();
			Assert.assertEquals(driver.getCurrentUrl(), propUtil.getValue("allurl"));
			Assert.assertEquals(propUtil.getValue("all"), olsrp.getVisibleTextOfSearchFilterDropDown());
			
		}catch(Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
		
	}
	

	@Test(groups={"functionalTests"})
	public void filterByWallmartTest() {
		try {

			homepage = new Homepage();
			homepage.clickFindAnOffice();
			OfficeLocatorPage olp = new OfficeLocatorPage();
			olp.selectSearchFilterByValue("w");
			olp.sendTextIntoCityStateZipField("38021");
			olp.clickLbSearch();
			
			OfficeLocatorSearchResultspage olsrp = new OfficeLocatorSearchResultspage();
			Assert.assertEquals(driver.getCurrentUrl(), propUtil.getValue("wallmarturl"));
			Assert.assertEquals(propUtil.getValue("wallmart"), olsrp.getVisibleTextOfSearchFilterDropDown());
			
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
	}
}
