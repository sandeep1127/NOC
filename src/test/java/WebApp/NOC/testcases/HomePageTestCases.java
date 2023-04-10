package WebApp.NOC.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import WebApp.NOC.BaseClass.WebBase;
import WebApp.NOC.Pages.HomePage;
import WebApp.NOC.Pages.LoginPage;
@Listeners(CustomListener.class)
public class HomePageTestCases extends WebBase {
	
	LoginPage loginPage;
	HomePage homepage;

	public HomePageTestCases() throws IOException {
		super();                                                 // STEP 1 : Calling Constructor of BASE class to initialize 'Properties' file. Otherwise it will give null point exception
		
	}
	

	@BeforeMethod
	 public void setUp() throws IOException, InterruptedException{
		 init();                                                 // STEP 2 : Call init() method of BaseClass to open browser+URL
		 loginPage = new LoginPage(); 							 // STEP 3 : Creating Object of LOGINPAGE class to use its methods.
		 homepage= loginPage.validLogin(config.getProperty("username"), config.getProperty("password")); //Step 4:Need to login each time in each Test Cato go to HOMEPAGE screen So , i'm including this in my 'Before Method'.Also, this  method itself is instantiating HOMEPAGE object. 
		 }
	 
	
	
	
	@Test
	public void CreateUrgentAlertsTest() throws InterruptedException{
		//homepage.CreateUrgentAlerts("SMARTACHUB1E1X000169");
		homepage.CreateMultipleUrgentAlerts("SMARTACHUB1E1X000169");
		//homepage.createAlertNitish();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
