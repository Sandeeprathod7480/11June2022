package Library_Class;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class 
{
	
		public WebDriver driver;
		
	public void InitializeBrowser() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Sandeep Rathod\\eclipse-workspace\\11_June_Maven\\Browser_folder\\chromedriver.exe");
		
	     driver=new      ChromeDriver();
		
		Thread.sleep(2000);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
