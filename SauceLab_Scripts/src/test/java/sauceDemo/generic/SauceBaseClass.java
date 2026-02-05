package sauceDemo.generic;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import sauceElements.pom.HomePage;
import sauceElements.pom.LoginPage;

public class SauceBaseClass {
	
	public static WebDriver driver;
	
	@BeforeClass
	public void OpenBrowser() {
		Reporter.log("open browser", true);
		ChromeOptions options = new ChromeOptions(); 
		
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		
		options.addArguments("--no-first-run");
		options.addArguments("--no-default-browser-check");
		options.addArguments("--disable-features=PasswordManagerEnabled,AutofillServerCommunication,AutofillEnableAccountWalletStorage,PasswordChange,PasswordChangeInSettings");
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-autofill-keyboard-accessory-view");
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--safebrowsing-disable-password-protection");
		options.addArguments("--disable-features=SafeBrowsingEnhancedProtection");

		// use a temporary clean profile so no saved credentials exist
		String tempProfile = System.getProperty("java.io.tmpdir") + "/chrome-temp-" + System.currentTimeMillis();
		options.addArguments("--user-data-dir=" + tempProfile);

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);

		// prevent the “automation” banner
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.setExperimentalOption("useAutomationExtension", false);
		
		WebDriverManager.chromedriver().setup();
	 	 
		 driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		 driver.get("https://www.saucedemo.com/");
	}
	
	@BeforeMethod
	public void Login() throws InterruptedException {
		Reporter.log("login", true);
		
ChromeOptions options = new ChromeOptions(); 
		
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--no-first-run");
		options.addArguments("--no-default-browser-check");
		options.addArguments("--disable-features=PasswordManagerEnabled,AutofillServerCommunication,AutofillEnableAccountWalletStorage,PasswordChange,PasswordChangeInSettings");
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-autofill-keyboard-accessory-view");
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--safebrowsing-disable-password-protection");
		options.addArguments("--disable-features=SafeBrowsingEnhancedProtection");

		// use a temporary clean profile so no saved credentials exist
		String tempProfile = System.getProperty("java.io.tmpdir") + "/chrome-temp-" + System.currentTimeMillis();
		options.addArguments("--user-data-dir=" + tempProfile);

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);

		// prevent the “automation” banner
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		options.setExperimentalOption("useAutomationExtension", false);
		WebDriverManager.chromedriver().setup();
		
		String username = "standard_user";
		String password = "secret_sauce";
		
		Thread.sleep(1500);
		LoginPage login = new LoginPage(driver);
		login.setLogin(username, password);	
	}
	
	@AfterMethod
	public void Logout() throws InterruptedException {
		Reporter.log("logout", true);
		Thread.sleep(1500);
		HomePage logout = new HomePage(driver);
		logout.getlogout_Btn().click();
	}
	
	@AfterClass
	public void CloseBrowser() {	
		Reporter.log("close browser", true);
		driver.close();
	}

} 
