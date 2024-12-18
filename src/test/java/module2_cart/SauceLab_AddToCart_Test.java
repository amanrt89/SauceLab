package module2_cart;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import LibrarryClass.TestBase;
import LibrarryClass.Utility;
import module1_Login.SwagLabHomePage;
import module1_Login.SwagLabLoginPagePF;
import module1_Login.SwagLabMenuPage;



public class SauceLab_AddToCart_Test extends TestBase {

	SwagLabLoginPagePF login;
	SwagLabMenuPage menu;
	SwagLabHomePage home;
	SauceLab_YourCart_Page cart;

	@BeforeClass
	 @Parameters("browser")
	public void openBrrowser(@Optional("chrome")String browser) throws IOException {
		openBrowser(browser);
		login=new SwagLabLoginPagePF(driver);
		menu=new SwagLabMenuPage(driver);
		home=new SwagLabHomePage(driver);	
		cart=new SauceLab_YourCart_Page(driver);
	}

	@BeforeMethod
	public void login() throws IOException {		
		login.enterSwagLabLoginpageUn(Utility.getPFdata("UN"));
		login.enterSwagLabLoginPass(Utility.getPFdata("PASS"));
		login.clickSwagLabLoginbtn();
	}

	@Test
	public void addToCart() throws InterruptedException {
		home.addToCart_Item("Sauce Labs Backpack");
		Thread.sleep(2000);
		home.addToCart_Item("Sauce Labs Bike Light");
		Thread.sleep(2000);

		home.click_sauceLab_HomePage_CartButton();

		try {
			int x=cart.displayed_Quantity();
			int y=cart.actual_sizeOfCart();
			assertEquals(x, y, "Quantity not match");
		}
		catch(Exception e) 
		{
			System.out.println("Cart is empty");
		}
		
		//cart.click_sauceLab_CheckOut_Button();

	}

	@AfterMethod
	public void logout() {
		//home.click_sauceLab_HomePage_MenuButton();

		//menu.click_sauceLab_MenuPageLogoutButton();
	}

	@AfterClass
	public void browserClose() throws InterruptedException {
		Thread.sleep(3000);
		//closeBrowser();
	}

}
