package com.appname.pages;


	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


	 //This class will store all the locators and methods of Login page
	 
	public class US_ShippingPages {
	WebDriver driver;	

	By username= By.id("input-username");

	By password = By.id("input-password");
	By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");

	By HeaderText = By.xpath("//*[@id=\"content\"]/div[1]/div/h1");

    By Reportspath=By.xpath("//*[@id=\"reports\"]/a");
    By Salesspath=By.xpath("//*[@id=\"reports\"]/ul/li[1]/a");
    By Shippingspath=By.xpath("//*[@id=\"reports\"]/ul/li[1]/ul/li[3]/a");
    
    
    
	By datestart= By.id("input-date-start");
	By dateend = By.id("input-date-end");
	By groupby= By.xpath("//*[@id=\"input-group\"]");
	By Orderstatus = By.xpath("//*[@id=\"input-status\"]");
	By buttonfilter = By.xpath("//*[@id=\"button-filter\"]");
	

	//creating parameterized constructor to initialize WebDriver reference
	public US_ShippingPages(WebDriver driver)
	{
		this.driver =driver;
	}

	public boolean isHeaderFound()

	{
		
		boolean found=false;
		try {
			
		
			
			//Dashboard header present in page?
			found=driver.findElement(HeaderText).isDisplayed();
		}
		
		catch (NoSuchElementException e)
		{
			found=false;
		}
		
		return found;
		
	}	
		

		public boolean AdminLogin(String un,String pw)
		{
			driver.findElement(username).sendKeys(un);
			driver.findElement(password).sendKeys(pw);
			driver.findElement(loginbutton).click();
			
	        
			
			driver.findElement(Reportspath).click();
			driver.findElement( Salesspath).click();
			driver.findElement(Shippingspath).click();
			
			
			
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			
			
			boolean success=this.isHeaderFound();
			
			return success;
			
			
		
		}

		public String getUSLoginTitle(WebDriver driver) {
			// TODO Auto-generated method stub
			
			System.out.println(driver.getTitle());
			String curTitle = driver.getTitle();
			return curTitle;
			
			
		}
		
		public void SstatusFilter() {
		
		 driver.findElement(datestart).click();
			////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
			//order id
			String order_status_to_search="2019-06-24";
			
			 driver.findElement(datestart).sendKeys(order_status_to_search);
			 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
			try { 
			    WebElement t= driver.findElement(By.xpath("//*[@id=\"input-date-start\"]"));// xpath of the startdate after clicking filter
			    String order_statusListed=t.getText();//getting the value
			    if(order_status_to_search.equals(order_statusListed))//checking weather the date which we entered matches 
			      {
				    System.out.println("Found"); 
			      }
			  }
		  catch(NoSuchElementException e)
			 {
			 	System.out.println("Not Found");
			 }	
			 
			
	}
	public void SstatusFilterend() {
		
		 driver.findElement(dateend).click();
			////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
			//order id
			String order_status_to_search="2019-06-28";
			
			 driver.findElement(dateend).sendKeys(order_status_to_search);
			 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
			try { 
			    WebElement t= driver.findElement(By.xpath("//*[@id=\"input-date-end\"]"));// xpath of the enddate after clicking filter
			    String order_statusListed=t.getText();//getting the value 
			    if(order_status_to_search.equals(order_statusListed))//checking weather the date which we entered matches 
			      {
				    System.out.println("Found"); 
			      }
			  }
		  catch(NoSuchElementException e)
			 {
			 	System.out.println("Not Found");
			 }	
			 
			
	}
	
	public void SstatusFiltergroup() {
		
		 driver.findElement(groupby).click();
			////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
			//order id
			String shipping_status_to_search="Weeks";
			
			 driver.findElement(groupby).sendKeys(shipping_status_to_search);
			/*try { 
			    WebElement t= driver.findElement(By.xpath("//*[@id=\"input-group\"]/option[3]"));// xpath of the group after clicking filter
			    String shipping_statusListed=t.getText();//getting the value 
			    if(shipping_status_to_search.equals(shipping_statusListed))//checking weather the group which we entered matches 
			      {
				    System.out.println("Found"); 
			      }
			  }
		  catch(NoSuchElementException e)
			 {
			 	System.out.println("Not Found");
			 }*/	
	}
	public void SstatusFilterstatus() {
		
		 driver.findElement(Orderstatus).click();
			////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
			//order id
			String order_status_to_search="All Statuses";
			
			 driver.findElement(Orderstatus).sendKeys(order_status_to_search);
			 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
			/*try { 
			    WebElement t= driver.findElement(By.xpath("//*[@id=\"input-status\"]/option[1]"));// xpath of the orderstatus after clicking filter
			    String order_statusListed=t.getText();//getting the value 
			    if(order_status_to_search.equals(order_statusListed))//checking weather the order which we entered matches 
			      {
				    System.out.println("Found"); 
			      }
			  }
		  catch(NoSuchElementException e)
			 {
			 	System.out.println("Not Found");
			 }*/	
			 
			
	}
		
	}

