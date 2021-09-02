package com.orangehrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.AttendenceRecordPage;
import com.orangehrm.qa.pages.EmployeeTimesheetPage;
import com.orangehrm.qa.pages.HomePage;


public class EmployeeTimesheetPageTest extends TestBase{

	HomePage homepage;
	EmployeeTimesheetPage Timesheetpage;
	AttendenceRecordPage attendencerecordpage;
	
	public EmployeeTimesheetPageTest() {
		super();
	}
	
	@BeforeMethod
	public void beforesetup() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickTimeLink();
		Timesheetpage = new EmployeeTimesheetPage();
	}
	
	@Test
	public void viewAttendanceRecordTest() {
		attendencerecordpage = Timesheetpage.viewAttendanceRecord();
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/index.php/attendance/viewAttendanceRecord");
	}
}
