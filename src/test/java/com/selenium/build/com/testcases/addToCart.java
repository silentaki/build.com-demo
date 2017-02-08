package com.selenium.build.com.testcases;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.build.com.base.baseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class addToCart extends baseTest{
	@BeforeClass
	public void initialize() throws Exception{
		//initialize the properties
	init();	
	test = rep.startTest("addToCart");
	test.log(LogStatus.INFO, "Starting the doaddToCart test");
	}
	@Test
	public void doaddToCartTest() throws Exception {
		test.log(LogStatus.INFO, "Open the Browser");
		openBrowser();
		test.log(LogStatus.INFO, "Navigate to the site : http://www.build.com");
		navigate("build.com_url");
		//add item 
		test.log(LogStatus.INFO, "add the first item : Kohler K 6626 6U");
		type("searchTextBox_xpath","Item1");
		click("searchBtnClick_xpath");
		click("img1_xpath");
		click("addToCart_xpath");
		
		//add item
		test.log(LogStatus.INFO, "add the second item : Kohler K 6626 6U");
		type("searchTextBox_xpath","Item2");
		click("searchBtnClick_xpath");
		click("img1_xpath");
		click("addToCart_xpath");
		
		//add item
		test.log(LogStatus.INFO, "add the first item : Kohler K-5180-ST");
		type("searchTextBox_xpath","Item3");
		click("searchBtnClick_xpath");
		click("selectValue_xpath");
		clearText("selectValue_xpath");
		type("selectValue_xpath","value");
		selectText("selectValue_xpath");
		click("addToCart_xpath");
		click("cart_xpath");
		
		//check out
		
		test.log(LogStatus.INFO, "check out the items");
		click("checkout_xpath");
		test.log(LogStatus.INFO, "check out as guest");
		click("checkout_as_guest_xpath");				
		
		//user details
		test.log(LogStatus.INFO, "Enter the First name " + prop.getProperty("Fname"));
		type("firstName_xpath","Fname");
		test.log(LogStatus.INFO, "Enter the last name " + prop.getProperty("Lname"));
		type("lastName_xpath","Lname");
		test.log(LogStatus.INFO, "Enter the Street name " + prop.getProperty("Street"));
		type("streetAddress_xpath","Street");
		test.log(LogStatus.INFO, "Enter the zipcode " + prop.getProperty("zipcode"));
		type("zipcode_xpath","zipcode");
		test.log(LogStatus.INFO, "Enter the city name " + prop.getProperty("city"));
		type("city_xpath","city");
		test.log(LogStatus.INFO, "Enter the phone number " + prop.getProperty("phonenumber"));
		type("phoneNumber_xpath","phonenumber");
		test.log(LogStatus.INFO, "Enter the email " + prop.getProperty("email"));
		type("email_xpath","email");
		
		//card details
		test.log(LogStatus.INFO, "Enter the cardnumber " + prop.getProperty("cardnumber"));
		type("cardNumber_xpath","cardnumber");
		click("expireMonth_xpath");
		click("expireYear_xpath");
		test.log(LogStatus.INFO, "Enter the name " + prop.getProperty("name"));
		type("creditCardName_xpath","name");
		test.log(LogStatus.INFO, "Enter the cvv " + prop.getProperty("cvv"));
		type("cvv_xpath","cvv");
		test.log(LogStatus.INFO, "click on review order");
		click("reviewOrder_xpath");
		takeScreenShot();
		
		//To check tax
		try{
		String actual_result_tax = "$0.00";
		String Expected_result_tax = driver.findElement(By.xpath("//*[@id='taxAmount']")).getText();
		System.out.println(Expected_result_tax);
		assertThat(actual_result_tax).isEqualToIgnoringCase(Expected_result_tax);
		}catch(Exception e){
			e.printStackTrace();
		}
		//To check Grand Total
		try{
		String actual_result_GrandTotal = "$1,250.44";
		String Expected_result_GrandTotal = driver.findElement(By.xpath("//*[@id='grandtotalamount']")).getText();
		System.out.println(Expected_result_GrandTotal);
		assertThat(actual_result_GrandTotal).isEqualToIgnoringCase(Expected_result_GrandTotal);
		test.log(LogStatus.PASS, "Passed");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		rep.endTest(test);
		rep.flush();
	    driver.quit();
		
	}
}
