package com.jacksonville.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jacksonville.pages.Homepage;

public class HomepageHoverTest extends BaseTest {

	Homepage homepage = null;

	@Test(groups = {"regression"})
	public void hoverDownArrowTest() {
		try {
			homepage = new Homepage();
			WebElement hoverElement = homepage.getHoverElement();
			Actions action = new Actions(driver);
			action.moveToElement(hoverElement).build().perform();
			Assert.assertEquals(hoverElement.getCssValue("color"), propUtil.getValue("hoverelementcolor"));
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName() + "_" + filename);
			e.printStackTrace();
		}
	}

	@Test(groups = {"functionalTests"})
	public void clickHoverElementLinksTest() {
		try {
			homepage = new Homepage();
			homepage.clickLearnAboutMyJHLink();
			driver.navigate().back();
			homepage.clickCheckStatusLink();
			driver.navigate().back();
			homepage.clickManageDocumentsLink();
			driver.navigate().back();
			homepage.clickManageDocumentsLink();
			driver.navigate().back();
			homepage.clickNotificationsLink();
			driver.navigate().back();
			Assert.assertEquals(driver.getCurrentUrl(), propUtil.getValue("url"));
			Assert.assertEquals(driver.getTitle(), propUtil.getValue("homepagetitle"));
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName() + "_" + filename);
			e.printStackTrace();
		}
	}

	@Test(groups = {"regression"})
	public void hoverFBElementTest() {
		try {
			homepage = new Homepage();
			homepage.hoverFacebookElement();
			Assert.assertEquals(true, homepage.startNowElementIsDisplayed());
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName() + "_" + filename);
			e.printStackTrace();
		}
	}
}
