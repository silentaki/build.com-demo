package com.selenium.build.com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class baseTest {
	 public static WebDriver driver;
	 public ExtentReports rep = ExtentManager.getInstance();
	 public ExtentTest test;
	 public static Properties prop;
	 //initialize the property
	 public static void init() throws Exception{
	    prop = new Properties();
	    
			try {
				FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//configfolder//config.properties");
					prop.load(fs);
				} catch (IOException e) {
				
					e.printStackTrace();
				}
	 }
	 //Browser properties
			public void openBrowser() throws Exception{
				//driver = new FirefoxDriver();
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);			
			}
			
			//navigate to the site	
			public void navigate(String url_xpath){
				driver.get(prop.getProperty(url_xpath));
			}
			
			//click properties
			public void click(String webElement_xpath){
			driver.findElement(By.xpath(prop.getProperty(webElement_xpath))).click();
			}
			
             //type properties
			public void type(String webElement_xpath ,String data){
				driver.findElement(By.xpath((prop.getProperty(webElement_xpath)))).sendKeys(prop.getProperty(data));
			}
			//clear text
			public void clearText(String webElement_xpath){
				WebElement a = driver.findElement(By.xpath(prop.getProperty(webElement_xpath)));
				a.sendKeys(Keys.CONTROL + "a");
				a.sendKeys(Keys.DELETE);
				}
			public void selectText(String webElement_xpath){
				WebElement a = driver.findElement(By.xpath(prop.getProperty(webElement_xpath)));
				a.sendKeys(Keys.CONTROL + "a");

			}
			
			public void takeScreenShot(){
				Date d = new Date();
				String filename = d.toString().replace(":","_").replace(" ","_")+".png";
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try
				{
				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+filename));
				}
				catch(Exception e)
				{
					
				}
				
				test.log(LogStatus.INFO,"Screenshot->"+test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+filename));
			
}
}
			
			
			
			
			
			


