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
	
	@FindBy(xpath=" //div[text()=' Email account does not exist. ']")
	public WebElement invalidEmailTxt;
	
	@FindBy(xpath="//div[text()=' Password is incorrect. ']")
	public WebElement invalidPwdTxt;
	
	@FindBy(xpath="//a[contains(text(),' Forgot password? ') and  @class='l-forgot-button']")
	public WebElement forgotpasswordMsg;
	
	@FindBy(xpath="//input[@id='email' and @class='e-input']")
	public WebElement forgotEmailTxtBox;
	
	@FindBy(xpath="//button[@class='send-btn']")
	public WebElement resetPasswordBtn;
	
	//@FindBy(xpath="//div[text()='There is no user with that id']")
	//public WebElement wrongEmailAddressText;
	@FindBy(xpath="//div[@class='error-message']")
	  public WebElement wrongEmailAddressText;
	
	
	
	public Actions action;
	public CommonMethods common;
	public WebDriverWait wait;
		
	
   public LoginPage() throws IOException{               // constructor of Class where we are initializing Page objects	
		//this.driver=driver;
		PageFactory.initElements(driver, this);        // 'this' means initializing current class objects with driver of base class i.e @FindBy ones.Instead of 'this' You can also write  'LoginPage.class'
		wait =new WebDriverWait (driver, 120);        // creating explicit wait object
		
	}
	
 
 
	//    Methods/Actions for LoginPage  :-
   
   public String verifyLoginPageTitle(){
		  return  driver.getTitle();  
	  }
	  
	
	public HomePage validLogin(String un, String pwd) throws IOException, InterruptedException{
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
			username.sendKeys(un);
		} catch (Exception e) {
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
			username.sendKeys(un);
		}
		
		
		wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
		password.sendKeys(pwd);
		
		wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
		
		return new HomePage();
	}
	
	
	public boolean invalidEmailLogin(String pwd){
		
		wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
		username.sendKeys("sandeep1.chaudhary@smartac.com");
		
		wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
		password.sendKeys(pwd);
		
		wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
		
		boolean isInvalidEmailTxtVisible = invalidEmailTxt.isDisplayed();
		return isInvalidEmailTxtVisible;
	}
	
  public boolean invalidPasswordLogin(String un ) throws InterruptedException{
		
	wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
	username.sendKeys(un);
		
	wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
	password.sendKeys("password1234");  // its giving IllegalArgumentException:. WHY ?????
   //  password.sendKeys(pwd);
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
		Thread.sleep(2000);
		boolean isInvalidPasswrdTxtVisible = invalidPwdTxt.isDisplayed();
		return isInvalidPasswrdTxtVisible;
	}
	
	
  
  
  public String verifyForgotPasswordErrorMsg(){
	  forgotpasswordMsg.click();
	  forgotEmailTxtBox.sendKeys("xyz@gmail.com");
	  resetPasswordBtn.click();
	  String value= wrongEmailAddressText.getText();
	  //boolean flag =wrongEmailAddressText.isDisplayed();
	  return value;
  }
	
	
	
	
	
	
	
	
	
	
}
