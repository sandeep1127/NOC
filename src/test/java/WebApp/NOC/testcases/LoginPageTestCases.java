package WebApp.NOC.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import WebApp.NOC.BaseClass.WebBase;
import WebApp.NOC.testcases.CustomListener;
import WebApp.NOC.Pages.HomePage;
import WebApp.NOC.Pages.LoginPage;

@Listeners(CustomListener.class)
public class LoginPageTestCases extends WebBase {

	
	LoginPage loginPage;
	HomePage homePage;  // FYI : we initialized object of HomePage through 'validLoginTest' Test case. 
	
	
	                                        
	
		public LoginPageTestCases() throws IOException {
			super();                                                   // STEP 1 : Calling Constructor of BASE class to initialize Properties file. Otherwise it will give null point exception
			
		}
	
		@BeforeMethod
		 public void setUp() throws IOException{
			 init();                                                 // STEP 2 : Call init() method of BaseClass to open browser+URL
			loginPage = new LoginPage(); 							 // STEP 3 : Creating Object of LOGINPAGE class to use its methods.
			
		}
		 
		/*     IMP Keywords :-  
		 
		   a) "dependsOnMethods" : When some test case depends on other test case eg homepage will open only if login happens , so use keyword 'dependsOnMethods="testcaseName"'
			   eg @Test(dependsOnMethods="validLoginTest")    > Here it means, if  'validLogintest()' test case fails, then automatically this test case will be skipped.
			   eg public void homepage(){} 
		   b) "invocationCount=10" : When you want to run some test case multiple times, we use keyword 'invocationCount = [no of time u want test case to run]
		       eg @Test(invocationCount=10) : here it will run automatically 10 times.
		*/
		 
		
		
		 
		// Step 4 : Creating Test Cases
		
		@Test(priority=1)
		public void verifyLoginPageTitleTest(){
			Assert.assertEquals(loginPage.verifyLoginPageTitle(), "SmartAC.com | Dashboard Login" ,"The Title does not match"); 
		}
	
		
		@Test(priority=2)
		public void validLoginTest() throws IOException, InterruptedException{
			homePage= loginPage.validLogin(config.getProperty("username"), config.getProperty("password"));   // Here, 'homePage' object gets initialized
			// Above line basically means> homePage = new HomePage();
			Assert.assertTrue(homePage.settingsIcon.isDisplayed());
		
		}
		
		@Test(priority=3)
		public void invalidEmailLoginTest() {
			loginPage.invalidEmailLogin(config.getProperty("password"));
			Assert.assertTrue(loginPage.invalidEmailTxt.isDisplayed());
		}
		
		
		@Test(priority=4)
		public void invalidPasswordLoginTest() throws InterruptedException {
			loginPage.invalidPasswordLogin(config.getProperty("username"));
			Assert.assertTrue(loginPage.invalidPwdTxt.isDisplayed());
		}
		
		@Test(priority=5)
		public void verifyForgotPasswordErrorMsgTest(){
			SoftAssert softAssert1 = new SoftAssert();   // Creating SoftAssert Object at each Test case level (We did not create Single Object at Global level because in that case in all test cases results of all cases will be shown so better to create a new Object in each class).(Always use method "softAssert.assertAll(); in each Test Case for SoftAssert to work)
			
			softAssert1.assertEquals(loginPage.verifyForgotPasswordErrorMsg(),"There is no user with that id" );
			softAssert1.assertAll();                      // we always need to add this method if we use SoftAssert, otherwise failed test case also will be shown as Passed.
			
		}
		
		
}
