package WebApp.NOC.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import WebApp.NOC.BaseClass.WebBase;
import WebApp.NOC.Common.CommonMethods;

public class LoginPage extends WebBase {

	// Object Repository :-
	
	@FindBy(id="email")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement signInButton;
	
	
	
	

	public Actions action;
	CommonMethods common;
	public WebDriverWait wait;
	
	
	
 public LoginPage() throws IOException{               // constructor of Class where we are initializing Page objects	
		//this.driver=driver;
		PageFactory.initElements(driver, this);        // 'this' means initializing current class objects i.e @FindBy ones
		wait =new WebDriverWait (driver, 120);    // using explicit wait 
	}
	
 
 
	// Methods for LoginPage OR Actions :-
	
	public HomePage validLogin(String un, String pwd) throws IOException, InterruptedException{
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
			username.sendKeys(un);
		} catch (Exception e) {
			Thread.sleep(40000);
			wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
			username.sendKeys(un);
		}
		
		
		wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
		password.sendKeys(pwd);
		
		wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
