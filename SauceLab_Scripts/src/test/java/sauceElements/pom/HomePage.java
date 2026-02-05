package sauceElements.pom; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(id = "react-burger-menu-btn")
	private WebElement sidebar_Btn;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logout_Btn;
	
	@FindBy(xpath = "//select[@class='product_sort_container']")
	private WebElement product_containor;
	
	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cart_Btn;
	
	@FindBy(id = "checkout")
	private WebElement checkout_Btn;
	
	@FindBy(id = "first-name")
	private WebElement firstName;
	
	@FindBy(id = "last-name")
	private WebElement lastName;
	
	@FindBy(id = "postal-code")
	private WebElement postalCode;
	
	@FindBy(id = "continue")
	private WebElement continue_Btn;
	
	@FindBy(id = "finish")
	private WebElement finish_Btn;
	
	@FindBy(id = "back-to-products")
	private WebElement backToHome;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getsidebar_Btn() {
		return sidebar_Btn;
	}
	public WebElement getlogout_Btn() {
		return logout_Btn;
	}
	public WebElement getproduct_containor() {
		return product_containor;
	}
	public WebElement getaddToCart() {
		return addToCart;
	}
	public WebElement getcart_Btn() {
		return cart_Btn; 
	}
	public WebElement getcheckout_Btn() {
		return checkout_Btn;
	}
	public WebElement getfirstName() {
		return firstName;
	}
	public WebElement getlastName() {
		return lastName;
	}
	public WebElement getpostalCode() {
		return postalCode;
	}
	public WebElement getcontinue_Btn() {
		return continue_Btn;
	}
	public WebElement getfinish_Btn() {
		return finish_Btn;
	}
	public WebElement getbackToHome() {
		return backToHome; 
	}
}
