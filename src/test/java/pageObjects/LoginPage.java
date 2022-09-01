package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
		
	public static WebElement usernameInput(WebDriver driver) {
		
		WebElement usernameInput = driver.findElement(By.id("user-name"));
		return usernameInput;
		
	}

}
