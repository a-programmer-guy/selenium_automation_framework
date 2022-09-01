package testcase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class LoginTestFW  extends BaseTest{
	
	@Test
	public static void LoginTest() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		String expected = "PRODUCTS";
		String actual = driver.findElement(By.xpath("//*[@id='header_container']/div[2]/span[@class='title']")).getText();
		Assert.assertEquals(actual, expected);
	}
}
