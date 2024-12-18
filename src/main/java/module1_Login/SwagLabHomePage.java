package module1_Login;


import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage {
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement menuBtn;
    @FindBy(xpath="//div[@class='app_logo']")private WebElement logo;
    @FindBy(xpath="//div[@class='inventory_list']/div//div[contains(text(),'Sauce Labs')]") private List<WebElement> l;
	@FindBy(xpath="//button[text()='Add to cart']") private List<WebElement> addToCart_Btn;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement cart_Btn;
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickSwagLabHomePageMenuBtn()
	{
		menuBtn.click();
	}
	
	public String verifySwagLabLogin()
    {
 	   String actText=logo.getText();
 	   return actText;
    }
	public void addToCart_Item(String expected) {

		for(int i=0;i<=l.size();i++) {
			if(l.get(i).getText().equals(expected)) {
				addToCart_Btn.get(i).click();
				break;
			}		

		}
		
	}
	public void click_sauceLab_HomePage_CartButton() {
		cart_Btn.click();
	}
	
}
	

