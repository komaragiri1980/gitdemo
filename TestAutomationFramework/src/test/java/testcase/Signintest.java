package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.Basetest;
import utilities.Readtestdata;

public class Signintest extends Basetest {
	
	
	@Test(dataProviderClass=Readtestdata.class,dataProvider="testdata")
	
	public void logintest(String username, String password) {
		
		driver.findElement(By.linkText(loc.getProperty("Sign in"))).click();
		driver.findElement(By.id(loc.getProperty("usernamefield"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("nextbtn"))).click();
		driver.findElement(By.id(loc.getProperty("password"))).sendKeys(password);
		driver.findElement(By.id(loc.getProperty("nextbtn"))).click();
		
	}

}
