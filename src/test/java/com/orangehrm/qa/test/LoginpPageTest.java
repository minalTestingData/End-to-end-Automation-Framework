package com.orangehrm.qa.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.HomePage;



public class LoginpPageTest extends TestBase{

	HomePage homepage;

	public LoginpPageTest() {
		super(); // calling constructor of testBase class
	}

	@Test(priority=1)
	public void Verifyloginpannel() {
		boolean flag=loginpage.validateLoginpanel();
		logger.info("Login pannel get verified");
		Assert.assertTrue(flag);
	}

	@Test(priority=2,dataProvider ="LoginCredentials",dataProviderClass = com.orangehrm.qa.utils.DataProviderDetails.class)
	public void Verifylogin(String username, String password) throws IOException{
		//homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage=loginpage.login(username, password);
		//Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/dashboard");	
			

	if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")) {
		loginpage.logout();
		Assert.assertTrue(true);
		logger.info("Login functinallity verified");
	}
	else {
		captureScreen(driver, "Verifylogin");
		Assert.assertTrue(false);
		logger.info("Login functinallity failed");
	}
	}
	
	
}
