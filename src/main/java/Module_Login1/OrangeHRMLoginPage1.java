package Module_Login1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage1 
{		
	@FindBy(xpath=("//input[@name='username']"))	private WebElement UN;
	
	@FindBy(xpath=("//input[@name='password']"))	private WebElement PSW;
	
	@FindBy(xpath=("//button[text()=' Login ']"))	private WebElement LoginBtn;
	
	
	public OrangeHRMLoginPage1(WebDriver  driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void EnterUsername(String username)
	{
		UN.sendKeys(username);
	}
	
	public void EnterPassword(String password)
	{
		PSW.sendKeys(password);
	}
	
	public void ClickLoginBtn()
	{
		LoginBtn.click();
	}
	
}
