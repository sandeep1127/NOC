package WebApp.NOC.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import WebApp.NOC.BaseClass.WebBase;
import WebApp.NOC.Common.CommonMethods;

public class HomePage extends WebBase {
	
	// Object Repository :-
	@FindBy(xpath="//img[@class='small-img']")
	public WebElement settingsIcon;
	
	@FindBy(xpath="//img[@class='test-img']")
	public WebElement manageTestAlertsIcon;
	
	@FindBy(xpath="//div[text()=' Clear Alerts ']")
	public WebElement clearAlertsTab;
	
	@FindBy(xpath="//input[@id='uid']")
	public WebElement uidTextBox;
	
	@FindBy(xpath="//button[@class='ca-button']")
	public WebElement clearAlertBtn;
	
	@FindBy(xpath="//div[@class='message']")
	public WebElement alertSuccessMsg;
	
	@FindBy(xpath="	//div[@class='sac-dropdown cs-createAlertType']")
	public WebElement alertDropDown;

	
	
	public Actions action;
	CommonMethods common;
	public WebDriverWait wait;
	
	// initializing Page objects/WebElements in the Constructor of Page Class
		public HomePage() throws IOException {
			PageFactory.initElements(driver,this); 
			wait =new WebDriverWait (driver, 60);    // using explicit wait & instantiating it in Constructor itself.
		}
		
		
		
	//Actions of this class OR Page Library :-
	
		public String verifyHomePageTitle(){
			  return  driver.getTitle();  
		  }
		
		
		public void CreateUrgentAlerts(String UIDsOfUser) throws InterruptedException{   // we will use DATA PROVIDER for this method in TEST class
			//driver.findElement(By.xpath("//img[@class='logo']")).click(); // we don't this as by default its being clicked.
			manageTestAlertsIcon.click();
		    //Thread.sleep(3000);
			//wait.until(ExpectedConditions.elementToBeClickable(uidTextBox)).clear();      // THIS line FAILS the Test Case. Not sure why?
			Thread.sleep(1000);
                                     //Using JAVASCRIPTEXECUTOR Class to enter the UID
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].value='SMARTACHUB1E1X000169'",uidTextBox);             // WHY ITS NOT TAKING value from Method's argument ??
			
			
			
			uidTextBox.sendKeys(UIDsOfUser);
			Thread.sleep(3000);
			clearAlertBtn.click();
			Thread.sleep(1000);
			
			String toastMsg= alertSuccessMsg.getText();  // THIS IS CALLED 'TOAST MESSAGE'
			
			System.out.println("Title of toater is" + toastMsg);
		}
		
		// Filling ALERTS UID's via EXCEL
			public void CreateMultipleUrgentAlerts(String UIDsOfUser) throws InterruptedException{
				manageTestAlertsIcon.click();
				
				
				WebElement uidTextBox = driver.findElement(By.xpath(".//div[@id='sac-input-container']/input[@placeholder='Enter UID']"));	
				
				//js.executeScript("document.getElementById('uid').value='SMARTACHUB1E1X000169'");   // 1st way of using sendkeys via JS Executor when using Path created by CONSOLE locators  [we went to CONSOLE panel and used[document.get.....]   Here "document.getElementById('uid')" is the locator of Element we created in console
                //js.executeScript("arguments[0].value='xyz';",uidText);                               //2nd way of using sendkeys via JS Executor [we used arguments in place of document [we used this when we wanna use xpath]]  .value='' works same as .sendkeys()  in JSE. Xpath i.e "uidTextBox" of element will replace "arguments[0]" when run.
				                                                                         // WAY to CLICK using JSE >  js.executeScript("arguments[0].click();", button);   
				
				//js.executeScript("arguments[0].value='SMARTACHUB1E1X000169';",uidTextBox);
				CommonMethods.sendKeysUsingJSE(driver, uidTextBox, UIDsOfUser);  //Used this pre made method instead of using above line OR using ACTIONS Class.
	       
    /*
     Actions action = new Actions(driver); 
     action.sendKeys(uidTextBox,UIDsOfUser).build().perform();   // we can use this code to type UID in Text box
   */
				Thread.sleep(2000);
				//Select select =new Select(alertDropDown);   // Can't use SELECT class as alert dropdown is not using SELECT Tag. So have to use BOOTSTRAP
				
				WebElement alertDropDown1 = driver.findElement(By.xpath("//div[@class='sac-arrow-container']//*[name()='svg']"));	
				JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", alertDropDown1);            // Explain : Element takes the place of "arguments[0]" when its run
				
				Thread.sleep(7000);
				
			}                                                                   
		
			
			
	/*	
	 public  void createAlertNitish() throws InterruptedException{                   
			manageTestAlertsIcon.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(uidTextBox)).clear();
			WebElement uid = driver.findElement(By.xpath(".//div[@id='sac-input-container']/input[@placeholder='Enter UID']"));
			Thread.sleep(4000);
                                     //Using JAVASCRIPTEXECUTOR Class [It worked]
			JavascriptExecutor js= (JavascriptExecutor)driver;
			//js.executeScript("arguments[1].value = arguments[0]; ", "SMARTACHUB1E1X000169", uid);   // THIS was NITISH's line
			js.executeScript("arguments[0].value='SMARTACHUB1E1X000169'",uid);                        // I(SANDEEP) used this Instead
			Thread.sleep(5000);
		                            //using ACTIONS Class [It worked]
			Actions action = new Actions(driver); 
			action.sendKeys(uid,"SMARTACHUB1E1X000169").build().perform();
			
		}		
		*/
		
		
		
		
		
		
		
		
}
		
	

