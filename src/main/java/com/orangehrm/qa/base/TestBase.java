package com.orangehrm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.utils.WebEventListener;
import com.orangehrm.qa.utils.testUtils;

public class TestBase{
	
public static WebDriver driver;
public static Properties prop;
public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
public static Logger logger;

public LoginPage loginpage;


public TestBase() {
	
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/"
				+ "com/orangehrm/qa/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}


@BeforeMethod
public void setup() {
	initialization();
	 logger = Logger.getLogger("OrangeHRMtest");
	PropertyConfigurator.configure("log4j.properties");
	loginpage = new LoginPage();
}

@AfterMethod
public void teardown() {
	driver.quit();
}

@SuppressWarnings("deprecation")
public static void initialization() {
	String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","D:\\Projects\\Selenium\\workspace\\OrangeHRMtest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if(browsername.equals("FireFox")) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "driver" + File.separator + "geckodriver.exe");
		driver = new FirefoxDriver();
	}else {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	e_driver = new EventFiringWebDriver(driver);
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver=e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(testUtils.page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(testUtils.implicit_wait, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}

public void captureScreen(WebDriver driver, String screenshotName) throws IOException {
	String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName+dateName + ".png");	
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}
}
