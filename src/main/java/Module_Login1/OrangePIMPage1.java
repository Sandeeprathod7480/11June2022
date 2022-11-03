package Module_Login1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangePIMPage1 
{	
	@FindBy(xpath=("//span[@class='oxd-userdropdown-tab']"))    private  WebElement UserName;   
	
	@FindBy(xpath=("//a[text()='Logout']")) 					private  WebElement LogOutBtn;
	

	public OrangePIMPage1(WebDriver    driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getUsername()
	{
		String  ActResult=UserName.getText();
		
		return   ActResult;
	}
	
	public void ClickOnUserName()
	{
		UserName.click();
	}
	
	public void LogOut()
	{
		LogOutBtn.click();
	}
	
	
}
