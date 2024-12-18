package LibrarryClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase 
{
	
//
				
	public WebDriver driver;
	
	@Parameters("browser")
   
	public void openBrowser(String browser) throws IOException
	{   
//				WebDriverManager.chromedriver().setup();
//			
//				driver=new ChromeDriver();
//				driver.get(Utility.getPFdata("URL"));
//				driver.manage().window().maximize();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		if(browser==null|| browser.equalsIgnoreCase("chrome")) {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(Utility.getPFdata("URL"));
		
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(Utility.getPFdata("URL"));

		}
		else if(browser.equalsIgnoreCase("edge"))
		{
	
		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(Utility.getPFdata("URL"));
		
		}
	
	     else 
	    {
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get(Utility.getPFdata("URL"));
	}
	
}




