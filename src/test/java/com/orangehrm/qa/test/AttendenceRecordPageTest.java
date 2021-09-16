package com.orangehrm.qa.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.AttendenceRecordPage;
import com.orangehrm.qa.pages.EmployeeTimesheetPage;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.addUserPage;

public class AttendenceRecordPageTest extends TestBase {

	HomePage homepage;
	EmployeeTimesheetPage Timesheetpage;
	AttendenceRecordPage attendencerecordpage;
	
	public AttendenceRecordPageTest() {
		super();
	}
	
	@BeforeMethod
	public void beforesetup() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		addUserPage ap = new addUserPage();
		homepage.clickTimeLink();
		Timesheetpage = new EmployeeTimesheetPage();
		Timesheetpage.viewAttendanceRecord();
		attendencerecordpage = new AttendenceRecordPage();
	}


	//@Test
	public void viewRecordwithDateTest() {
		attendencerecordpage.viewRecordwithDate("Aug", "2020", "3");
	}
	
	@Test
	public void verifyLogo() {
		Assert.assertTrue(attendencerecordpage.logodisplay());
	}
}
