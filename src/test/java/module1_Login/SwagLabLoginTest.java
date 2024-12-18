package module1_Login;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import LibrarryClass.TestBase;
import LibrarryClass.Utility;


public class SwagLabLoginTest extends TestBase
{


	SwagLabLoginPagePF s;
	SwagLabHomePage h;
	SwagLabMenuPage m;
	int TCID;


	@BeforeClass
    @Parameters("browser")
	public void OpenBrowwser(@Optional("chrome")String browser) throws EncryptedDocumentException, IOException
	{

		openBrowser(browser);
		s=new SwagLabLoginPagePF(driver);
		h=new SwagLabHomePage(driver);
		m=new SwagLabMenuPage(driver);

	}

	@BeforeMethod
	public void login() throws InterruptedException, EncryptedDocumentException, IOException {
		String username=Utility.getPFdata("UN");
		s.enterSwagLabLoginpageUn(username);

		String password=Utility.getPFdata("PASS");
		s.enterSwagLabLoginPass(password);


		s.clickSwagLabLoginbtn();
	}

	@Test
	public void homepage() throws InterruptedException, EncryptedDocumentException, IOException {

		TCID=101;
		String expText=Utility.getTD(0, 2);
		String actText=h.verifySwagLabLogin();
		Assert.assertEquals(actText, expText,"Logo Not match");
        Thread.sleep(2000);
		h.clickSwagLabHomePageMenuBtn();
	}

	@AfterMethod
	public void logout(ITestResult s) throws InterruptedException, IOException {

		if(s.getStatus()==ITestResult.FAILURE)
		{
			Utility.getSS(driver,TCID);
		}


		m.clickSwagLabMenuPageaboutBtn();//about 
	

		driver.navigate().back();//go back
		
		h.clickSwagLabHomePageMenuBtn();//click again on  menu 
	

		m.clickSwagLabMenuPageLogoutBtn(); //click on logout

	
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}


}



