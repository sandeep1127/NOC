package WebApp.NOC.Common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebApp.NOC.BaseClass.WebBase;

public class CommonMethods extends WebBase{

	
	
	public CommonMethods() throws IOException {
		super();
		
	}
	
	public static JavascriptExecutor js;
	public static String TESTDATA_SHEET_PATH ="E:\\SandeepJavaWorkspace\\NOC\\TestData\\NOCData.xlsx";
	static Workbook book;
	public static org.apache.poi.ss.usermodel.Sheet sheet;

	
	
	
	// METHOD >> To Scroll to a Particular Web element and click it via Java Script Executor
	public static void scrollToElementClick(WebElement webElementXpath) throws InterruptedException{
		js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", webElementXpath); 
		Thread.sleep(500); 
		webElementXpath.click();
		
		
	}
	
	
	//METHOD >> To Explicitly Wait for any Web Element for SEND KEYS
	
	
	public static void sendkeys(WebDriver driver , WebElement element, int timeout, String value){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	//METHOD >> To Explicitly Wait for any Web Element for CLICKING
	
	public static void clickOn(WebDriver driver , WebElement element, int timeout){
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	
	// METHOD : To add current time Stamp
    public static String addDateTimeStamp(){
		
		SimpleDateFormat df=new SimpleDateFormat("dd_MMM_yyyy_HH_MM_SS");   // Here we created object of SimpleDateFormat Class where we passed our desired date format in which we want the current date with time.
		Date date=new Date();                                              // Here, object is created to get the current time from our System.
		String currentTime= df.format(date);								// Here , we are using the method to format/convert the System time into our desired format.
		return currentTime;
		
		// System.out.println(System.currentTimeMillis());   we can also use simply this method directly as well , but it wont give the time in our desired format
	}
	
 // Method >> To use DataProvider to fetch data from Excel:- ( NAVEEN's CODE)
	
    public static Object[][] getTestData(String sheetName) {
   		FileInputStream file = null;
   		try {
   			file = new FileInputStream(TESTDATA_SHEET_PATH);
   		} catch (FileNotFoundException e) {
   			e.printStackTrace();
   		}
   		try {
   			book = WorkbookFactory.create(file);
   		} catch (InvalidFormatException e) {
   			e.printStackTrace();
   		} catch (IOException e) {
   			e.printStackTrace();
   		}
   		sheet= book.getSheet(sheetName);
   		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
   		// System.out.println(sheet.getLastRowNum() + "--------" +
   		// sheet.getRow(0).getLastCellNum());
   		for (int i = 0; i < sheet.getLastRowNum(); i++) {
   			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
   				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
   				// System.out.println(data[i][k]);
   			}
   		}
   		return data;
   	
   	
    }
    

   }
