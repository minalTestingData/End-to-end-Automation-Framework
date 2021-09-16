package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.utils.testUtils;

public class AttendenceRecordPage extends TestBase{

	@FindBy(name="attendance[employeeName][empName]")
	WebElement empname;

	@FindBy(id="attendance_date")
	WebElement date;

	@FindBy(id="btView")
	WebElement view;



	public AttendenceRecordPage() {
		PageFactory.initElements(driver, this);
	}

	public void viewRecordwithDate(String month, String year, String check_date) {
		date.click();
		testUtils.selectClassGeneric(By.xpath("//div[@id=\"ui-datepicker-div\"]//div//div//select[contains(@class,'ui-datepicker-month')]")).selectByVisibleText(month);
		testUtils.selectClassGeneric(By.xpath("//div[@id=\"ui-datepicker-div\"]//div//div//select[contains(@class,'ui-datepicker-year')]")).selectByVisibleText(year);
		driver.findElement(By.xpath("//div[@id=\"ui-datepicker-div\"]//table//tbody//tr//td//a[text()='"+check_date+"']")).click();
		view.click();
	}
	
	public boolean logodisplay() {
		//return LoginPage.image.isDisplayed();
		return addUserPage.image.isDisplayed();
	}

}
