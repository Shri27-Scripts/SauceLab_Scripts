package sauceScripts.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class InvalidLogin {
	
	public static WebDriver driver;
	@Test
	public void InvalidLoginScript() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(1500);
		
		String InvalidUsername = "invalid_user";
		String InvalidPassword = "invalid_pass";
		
		WebElement Username = driver.findElement(By.id("user-name"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		
		Thread.sleep(1500);
		
		Username.sendKeys(InvalidUsername);
		Thread.sleep(1500);
		Password.sendKeys(InvalidPassword);
		Thread.sleep(1500);
		LoginButton.click();
		Thread.sleep(1500);
		
		WebElement HomePage = driver.findElement(By.id("react-burger-menu-btn"));
		if(HomePage.isDisplayed()) {
			System.out.println("Login and Logout Successful - Test Failed");
			driver.findElement(By.id("logout_sidebar_link")).click();
			driver.quit();
		} else {
			System.out.println("Login Unsuccessful - Test Passed");
			driver.quit();
		}
	}
}
