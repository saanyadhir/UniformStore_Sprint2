package StepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.UniformStoreAdminLoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UniformAdminLogin {
	static WebDriver driver;
	static UniformStoreAdminLoginPage uAdminlogin; 

	@Before
	public void initdriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ruhi\\Desktop\\sel\\chromedriver_win32\\chromedriver.exe");
    	
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	uAdminlogin=new UniformStoreAdminLoginPage(driver);
    	
	}
	@After
	public void teardown()
	{
		 driver.quit();
	}
	
	
@Given("user is on admin login page")
public void user_is_on_admin_login_page() {
    // Write code here that turns the phrase above into concrete actions

	driver.get("http://uniformm1.upskills.in/admin/index.php?route=common/dashboard&token=GojamxBwtSmLEAaHnCBgb3P8yKe4N2vQ");
	String curTitle = driver.getTitle();
	
	Assert.assertEquals(curTitle, "Administration");
}

@When("user enters correct {string} and {string} and clicks login")
public void user_enters_correct_and_and_clicks_login(String string1, String string2) {
    // Write code here that turns the phrase above into concrete actions
	uAdminlogin.AdminLogin(string1,string2);
}






@Then("Admin homepage should be loaded successfully")
public void admin_homepage_should_be_loaded_successfully() {
    // Write code here that turns the phrase above into concrete actions

	boolean isloginsuccess=uAdminlogin.isHeaderFound();
	Assert.assertEquals(isloginsuccess, true);
	
}


	
	
}
