package testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

/*
locators are created in the BaseTest Class and they are defined in the 
locators.properties file - utilizing externalized data in properties files
*/
	public class LoginTestFW  extends BaseTest{
	
	@Test
	public static void LoginTest() throws InterruptedException {
		driver.findElement(By.id(locators.getProperty("username_input"))).sendKeys("standard_user");
		driver.findElement(By.id(locators.getProperty("password_input"))).sendKeys("secret_sauce");
		driver.findElement(By.xpath(locators.getProperty("login_btn"))).click();
		Thread.sleep(3000);
		String expected = "PRODUCTS";
		String actual = driver.findElement(By.xpath(locators.getProperty("header_span_text"))).getText();
		AssertJUnit.assertEquals(actual, expected);
	}
}
