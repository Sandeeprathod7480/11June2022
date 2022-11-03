package Library_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility_Class 
{	
	//Automation TE=
	//Day
	//Date
	//Fetch
	
	@Test
	public static String GetDatafromPF(String      key) throws IOException
	{
		FileInputStream   file=new		FileInputStream("C:\\Users\\Sandeep Rathod\\eclipse-workspace\\11_June_Maven\\Pro1.properties");
	
		Properties      prop=new      Properties();
	
		prop.load(file);
										//UN
		String	Value1=prop.getProperty(key);
		
		return Value1;
		
	}
	
		//Automation TE=
		//Day
		//Date
		//Fetch
	
	@Test
	public static String getDataFromExcel(  int RowIndex,  int CellIndex ) throws EncryptedDocumentException, IOException
	{
		FileInputStream  	file=new    FileInputStream("C:\\Users\\Sandeep Rathod\\eclipse-workspace\\11_June_Maven\\Testdata\\11_June_Morning.xlsx");
		
		Sheet	Sh=WorkbookFactory.create(file).getSheet("Sheet7");
		
		String	Value2=Sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		
		return Value2;
	}
	
		
	//Automation TE=
			//Day
			//Date
			//Fetch
	
	@Test
	public static void CaptureScreenShot(WebDriver driver, int TestCaseID) throws IOException
	{
		File	Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		System.out.println(Source);
		
		File    Destination=new     File("C:\\Users\\Sandeep Rathod\\eclipse-workspace\\11_June_Maven\\Screenshot\\."+TestCaseID+".jpg");
		
		FileHandler.copy(Source,Destination );
	}
	
	
	

}
