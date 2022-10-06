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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import WebApp.NOC.BaseClass.WebBase;
import WebApp.NOC.Common.CommonMethods;

public class HomePage extends WebBase {
	
	
	public Actions action;
	CommonMethods common;
	public WebDriverWait wait;
	
	// initializing Page objects/WebElements in the Constructor of Page Class
		public HomePage() throws IOException {
			PageFactory.initElements(driver,this); 
			
			wait =new WebDriverWait (driver, 60);    // using explicit wait 
		}
		
		
		
	//Actions of this class OR Page Library :-
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
	
	
}