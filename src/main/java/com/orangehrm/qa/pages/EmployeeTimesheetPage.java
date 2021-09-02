package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;

public class EmployeeTimesheetPage extends TestBase{
	
	@FindBy(id="menu_attendance_Attendance")
	WebElement attendence;
	
	@FindBy(id="menu_attendance_viewAttendanceRecord")
	WebElement employeeRecord;
	
	
	public EmployeeTimesheetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AttendenceRecordPage viewAttendanceRecord() {
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(attendence).click(employeeRecord).build().perform();
		return new AttendenceRecordPage();
	}

}
