package sauceElements.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id = "user-name")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setLogin(String userId, String passId) {
		username.sendKeys(userId);
		password.sendKeys(passId);
		loginButton.click();
	}

}