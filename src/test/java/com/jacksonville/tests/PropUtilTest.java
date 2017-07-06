package com.jacksonville.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PropUtilTest extends BaseTest{
	
	@Test(groups={"regression"})
	private void propUtilTest() {
		try {
			String actualBrow = propUtil.getValue("browser");
			Assert.assertFalse(actualBrow.equals(null));
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
		
	}

	@Test(groups={"regression"})
	private void getBrowserTest() {
		try {
			Assert.assertFalse(driver.equals(null));
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
			e.printStackTrace();
		}
		
	}

	@Test(groups = {"regression"})
	private void screenShotTest() {
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			propUtil.takeScrrenshot(driver, this.getClass().getName()+"_"+filename);
		}
	}

}
