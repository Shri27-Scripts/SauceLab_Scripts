package sauceScripts.Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sauceDemo.generic.SauceBaseClass;
import sauceElements.pom.HomePage;

@Listeners(sauceDemo.generic.SauceListnerClass.class)

public class LoginLogout extends SauceBaseClass{
	
	@Test
	public void LoginAndLogoutScript() throws InterruptedException {
		
		Thread.sleep(1500);
		HomePage home = new HomePage(driver);
		home.getsidebar_Btn().click();
		Thread.sleep(1500);
		
	}

}