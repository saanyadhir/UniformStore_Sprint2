package SanityTestPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class adminProductReturn
{
	WebDriver driver;
	By username = By.id("input-username");
	By password = By.id("input-password");
	By loginButton = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button");
	By loginStatus = By.cssSelector("#content > div.page-header > div > h1");
	By navigator = By.xpath("//*[@id=\"button-menu\"]/i");
	By salesButton = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"sale\"]");
	//By returnsButton = By.xpath("//ul[@id=\"menu\"]//parent::li[@id=\"sale\"]//child::a[text()=\"Returns\"]");
	//By returnsButton = By.xpath("//*[@id=\"sale\"]//ul/li[3]/a");
	By returnsLink = By.xpath("//ul[@id=\"menu\"]//descendant::a[contains(@href,\"sale/return\")]");
	
	By returnid= By.id("input-return-id");
	By orderid = By.id("input-order-id");
	By product = By.id("input-product");
	By customer = By.id("input-customer");
	By model=By.id("input-model");
	By dataAdded=By.id("input-date-added");
	By dateModified=By.id("input-date-modified");
	By noresultsmsg=By.xpath("//*[contains(text(),'No results')]");
	//By returnstatus=By.cssSelector("#input-return-status > option:nth-child(2)\"");
	By filterButton=By.id("button-filter");
	
	public adminProductReturn(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void typeUsername(String un)
	{
		driver.findElement(username).sendKeys(un);
	}
	public void typePassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	public boolean isUsernameBoxEnabled()
	{
		if(driver.findElement(username).isEnabled())
			return true;
		else
			return false;
	}
	public boolean isPasswordBoxEnabled()
	{
		if(driver.findElement(password).isEnabled())
			return true;
		else
			return false;
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
	public void clickNavigator()
	{
		driver.findElement(navigator).click();
	}
	
	public void clickSalesButton()
	{
		driver.findElement(salesButton).click();
		//System.out.println(returnsLink.linkText());
	}
	
	public void clickReturnsLink()
	{
		driver.navigate().to("http://uniformm1.upskills.in/admin/index.php?route=sale/return&token=pWRVsjCorcKXvpSeXUS2MsSIws0xZVYy");
	}
	
	public boolean searchByOrderID(String order_id) {
		boolean filterSuccess;
		
		driver.findElement(orderid).sendKeys(order_id);
		driver.findElement(filterButton).click();
		
			//WebElement TableData=driver.findElement(By.xpath("//*[@id=\"form-return\"]/div/table"));
			//List<WebElement> orderid= driver.findElements(By.xpath("//*[contains(text(),"+order_id+")]"));
			
		    java.util.List<WebElement> orderid= driver.findElements(By.xpath("//*[contains(text(),"+order_id+")]"));
		    
			int numorder=orderid.size();
			
			if(numorder>=2) {
				filterSuccess=true;
				Reporter.log("Found Order ID "+order_id);
				System.out.println(numorder);
			}else {
				filterSuccess=true;
				System.out.println("No results are found");
				Reporter.log("No Data Found for Order ID "+order_id);
				System.out.println(numorder);
			}
			
			
			
		return filterSuccess;
	}
}