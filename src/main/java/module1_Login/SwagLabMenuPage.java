package module1_Login;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabMenuPage {
	@FindBy(xpath="//a[@id='logout_sidebar_link']")private WebElement logOut;
	@FindBy(xpath="//a[@id='about_sidebar_link']")private WebElement about;

	
	public SwagLabMenuPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickSwagLabMenuPageaboutBtn()
	{ 
	      about.click();
	}
	public void clickSwagLabMenuPageLogoutBtn()
	{
		logOut.click();
	}
	
}
