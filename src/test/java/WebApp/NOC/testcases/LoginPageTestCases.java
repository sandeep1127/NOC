package WebApp.NOC.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import WebApp.NOC.BaseClass.WebBase;
import WebApp.NOC.testcases.CustomListener;
import WebApp.NOC.Pages.HomePage;
import WebApp.NOC.Pages.LoginPage;

@Listeners(CustomListener.class)
public class LoginPageTestCases extends WebBase {

	
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	// constructor of this Class which calls Constructor of its Parent class to initialize 'properties' file
		public LoginPageTestCases() throws IOException {
			super();                                                   // STEP 1 : Call Constructor of BASE class to initialize Properties file. Otherwise it will give null point exception
			
		}
	
	
	
	
		@BeforeMethod
		 public void setUp() throws IOException{
			 init();                                                 // STEP 2 : Call init() method of BaseClass to open browser+URL
			 loginPage = new LoginPage(); 							 // STEP 3 : Creating Object of LOGINPAGE class to use its methods.
			 }
		 
		 
		 
		// Step 4 : Creating Test Cases
	
		@Test
		public void validLoginTest() throws IOException, InterruptedException{
			loginPage.validLogin(config.getProperty("username"), config.getProperty("password"));
			
			
		/*IMP Keywords :  
		 * a) dependsOnMethods : When some test case depends on other test case eg homepage will open only if login happens , so use keyword 'dependsOnMethods="testcaseName"'
			   eg @Test(dependsOnMethods="validLoginTest")    > Here it means, if  'validLogintest()' test case fails, then automatically this test case will be skipped.
			   eg public void homepage(){} 
		   b) invocationCount=10 : When you want to run some test case multiple times, we use keyword 'invocationCount = [no of time u want test case to run]
		       eg @Test(invocationCount=10) : here it will run automatically 10 times.
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}	
		
}
