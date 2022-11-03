package Module1_Login_Test_class;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Class.Base_Class;
import Library_Class.Utility_Class;
import Module_Login1.OrangeHRMLoginPage1;
import Module_Login1.OrangePIMPage1;

public class OrangeHRM_TestNG_Test_Class extends Base_Class
{	
	//WebDriver driver;
	//InitializeBrowser()
		OrangeHRMLoginPage1  Login1;
		OrangePIMPage1    PIMpage1;
		
	int	TestCaseID;
	
	@BeforeClass
	public void OpenBrowser() throws InterruptedException
	{
		InitializeBrowser();
		
		//Object of POM 1
		 Login1=new      OrangeHRMLoginPage1(driver);
		 
		//Object of POM 2
		PIMpage1=new      OrangePIMPage1(driver);
		 
	}
	
	@BeforeMethod
	public void Login() throws IOException
	{
		Login1.EnterUsername(Utility_Class.GetDatafromPF("UN"));
		
		Login1.EnterPassword(Utility_Class.GetDatafromPF("PSW"));
		
		Login1.ClickLoginBtn();
		
	}
	
	
	
	@Test
	public void VerifyUsername() throws EncryptedDocumentException, IOException
	{
		TestCaseID=100;
		
	String	ActualUserName=PIMpage1.getUsername();
	
	String	ExpectedUserName=Utility_Class.getDataFromExcel(0, 0);

	Assert.assertEquals(ActualUserName, ExpectedUserName);
	}
	
	@Test
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{
		TestCaseID=200;
	String	ActualTitle=driver.getTitle();
	
	String ExpectedTitle=Utility_Class.getDataFromExcel(0, 1);
	
	Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	
	
	@AfterMethod
	public void LogOut(ITestResult  Result) throws IOException
	{			//FAil					Fail
		if (Result.getStatus()==ITestResult.FAILURE)	
		{
			Utility_Class.CaptureScreenShot(driver, TestCaseID);
		}
		
		PIMpage1.ClickOnUserName();
		
		PIMpage1.LogOut();
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	

}
