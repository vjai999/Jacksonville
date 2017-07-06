package com.jacksonville.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jacksonville.pages.Homepage;

public class HomepageTests extends BaseTest{
	
	Homepage homepage = null;
	
	@Test(groups={"regression"})
	public void titleAndUrlTest() {
		try {
			String actualTitle = driver.getTitle();
			Assert.assertFalse(actualTitle.equals(null));
			Assert.assertFalse(driver.getCurrentUrl().equals(null));
			Assert.assertEquals(propUtil.getValue("homepagetitle"), actualTitle);
			Assert.assertTrue(driver.getCurrentUrl().equals(propUtil.getValue("url")));
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
	}
	
	@Test(groups={"regression"})
	public void getPageSourceTest() {
		try {
			propUtil.getPageSourceFile(driver);
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}	
	}
	
	@Test(groups={"regression"})
	public void linksCountTest() {
		try {
			homepage = new Homepage();
			Assert.assertEquals(homepage.getLinksCount(), Integer.parseInt(propUtil.getValue("homepagelinkscount")));
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
	}
	
	
	@Test(groups={"regression"})
	public void dropdownAuthLinkTest() {
		try {
			homepage = new Homepage();
			Assert.assertEquals(homepage.getTagsCount("a", "id", "dropdownAuthLink"), 1);
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
	}
	
	@Test(groups={"regression"})
	public void click4ThLinkGetInformed() {
		try {
			homepage = new Homepage();
			homepage.clickNThLink("a", 3);
			Assert.assertEquals(propUtil.getValue("getinformedpagetitle"),driver.getTitle());
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
	}
	
}
