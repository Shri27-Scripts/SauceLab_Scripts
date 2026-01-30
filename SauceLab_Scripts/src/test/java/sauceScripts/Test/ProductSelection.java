package sauceScripts.Test;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sauceDemo.generic.SauceBaseClass;
import sauceElements.pom.HomePage;

@Listeners(sauceDemo.generic.SauceListnerClass.class)

public class ProductSelection extends SauceBaseClass{
	
	@Test
	public void ProductSelection_Script() throws InterruptedException {
		
		Thread.sleep(1500);
		HomePage home = new HomePage(driver);
		home.getproduct_containor().click();
		
		Select select = new Select(home.getproduct_containor());
		select.selectByIndex(3);
		Thread.sleep(1500);
		
		home.getaddToCart().click();
		Thread.sleep(1500);
		home.getcart_Btn().click();
		Thread.sleep(1500);
		home.getcheckout_Btn().click();
		Thread.sleep(1500);
		
		home.getfirstName().sendKeys("Shine");
		Thread.sleep(1500);
		home.getlastName().sendKeys("kitty");
		Thread.sleep(1500);
		home.getpostalCode().sendKeys("560018");
		Thread.sleep(1500);
		
		home.getcontinue_Btn().click();
		Thread.sleep(1500);
		home.getfinish_Btn().click();
		Thread.sleep(1500);
		
		home.getbackToHome().click();
		Thread.sleep(1500);
		
		HomePage home01 = new HomePage(driver);
		home01.getsidebar_Btn().click();
		Thread.sleep(1500);
	}

}