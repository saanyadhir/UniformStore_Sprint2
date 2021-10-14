package com.appname.pages;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 
public class ordereREGEXpage {
	WebDriver driver;	

	By username= By.id("input-username");

	By password = By.id("input-password");
	By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
	By HeaderText = By.xpath("//*[@id=\"content\"]/div[1]/div/h1");
	By Order_id =By.id("input-order-id");
	By Order_status =By.id("input-order-status");
	By Shop_list =By.xpath("//*[@id=\"sale\"]/a/i");
	By O_list =By.xpath("//*[@id=\"sale\"]/ul/li[1]/a");
	//By date_added= By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[1]/div/span/button/i");
	By customer_search =By.id("input-customer");
	By total =By.id("input-total");
	By customerText =By.xpath("//*[@id=\"form-order\"]/div/table/thead/tr/td[3]");
	//By date_modified =By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[2]/div/span/button/i");
	//creating parameterized constructor to initialize WebDriver reference
	public ordereREGEXpage(WebDriver driver)
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
			driver.findElement(Shop_list).click();
			driver.findElement(O_list).click();
			boolean success=this.isHeaderFound();
			
			return success;
			
		
		}

		public String getUSLoginTitle(WebDriver driver) {
			// TODO Auto-generated method stub
			
			System.out.println(driver.getTitle());
			String curTitle = driver.getTitle();
			return curTitle;
			
			
		}
		
		/*public void filter() {
			/*driver.findElement(Order_id).click();
			
			//order id
			String order_id_to_search="111";
			
			 driver.findElement(Order_id).sendKeys(order_id_to_search);
			 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
			 
			WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
			

			String order_idListed=t.getText();//getting the value of the order id listed below
			 if(order_id_to_search.equals(order_idListed))//checking wether the id wch we entered in order id matches to the order id listed below
			 {
				System.out.println("searched for: "+order_id_to_search+" got:"+order_idListed); 
			 }
			 */
			 /*driver.findElement(Order_id).click();
				
				//order id
				String order_id_to_search="566";
				
				 driver.findElement(Order_id).sendKeys(order_id_to_search);
				 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
				try { 
				    WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
				    String order_idListed=t.getText();//getting the value of the order id listed below
				    if(order_id_to_search.equals(order_idListed))//checking wether the id wch we entered in order id matches to the order id listed below
				      {
					    System.out.println("Found"); 
				      }
				  }
			  catch(NoSuchElementException e)
				 {
				 	System.out.println("Not Found");
				 }	
				 
				
		}
		
		/*public void OstatusFilter() {
			
			 driver.findElement(Order_status).click();
				////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
				//order id
				String order_status_to_search="Canceled";
				
				 driver.findElement(Order_status).sendKeys(order_status_to_search);
				 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
				try { 
				    WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
				    String order_statusListed=t.getText();//getting the value of the order id listed below
				    if(order_status_to_search.equals(order_statusListed))//checking wether the id wch we entered in order id matches to the order id listed below
				      {
					    System.out.println("Found"); 
				      }
				  }
			  catch(NoSuchElementException e)
				 {
				 	System.out.println("Not Found");
				 }	
				 
				
		}

		/*public void DateAddedFilter() {
			
			 driver.findElement(date_added).click();
				////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
				//order id
				String order_status_to_search="2021-10-08";
				
				 driver.findElement(date_added).sendKeys(order_status_to_search);
				 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
				try { 
				    WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
				    String order_statusListed=t.getText();//getting the value of the order id listed below
				    if(order_status_to_search.equals(order_statusListed))//checking wether the id wch we entered in order id matches to the order id listed below
				      {
					    System.out.println("Found"); 
				      }
				  }
			  catch(NoSuchElementException e)
				 {
				 	System.out.println("Not Found");
				 }	
				 
				
		}*/

		
		/*public void CustomerFilter() {
			
			 driver.findElement(customer_search).click();
				////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
				//order id
				String order_status_to_search="avengers team";
				
				 driver.findElement(customer_search).sendKeys(order_status_to_search);
				 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
				try { 
				    WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
				    String order_statusListed=t.getText();//getting the value of the order id listed below
				    if(order_status_to_search.equals(order_statusListed))//checking wether the id wch we entered in order id matches to the order id listed below
				      {
					    System.out.println("Found"); 
				      }
				  }
			  catch(NoSuchElementException e)
				 {
				 	System.out.println("Not Found");
				 }	
				 
				
		}
		
		/*public void TotalFilter() {
			
			 driver.findElement(total).click();
				////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
				//order id
				String order_status_to_search="1932";
				
				 driver.findElement(total).sendKeys(order_status_to_search);
				 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
				try { 
				    WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
				    String order_statusListed=t.getText();//getting the value of the order id listed below
				    if(order_status_to_search.equals(order_statusListed))//checking wether the id wch we entered in order id matches to the order id listed below
				      {
					    System.out.println("Found"); 
				      }
				  }
			  catch(NoSuchElementException e)
				 {
				 	System.out.println("Not Found");
				 }	
				 
				
		}*/
		/*public void DateModifiedFilter() {
			
			 driver.findElement(date_modified).click();
				////*[@id="content"]/div[2]/div[3]/div[2]/div[1]/div/div[2]/div[1]/label
				//order id
				String order_status_to_search="2021-10-08";
				
				 driver.findElement(date_modified).sendKeys(order_status_to_search);
				 driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
				try { 
				    WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
				    String order_statusListed=t.getText();//getting the value of the order id listed below
				    if(order_status_to_search.equals(order_statusListed))//checking wether the id wch we entered in order id matches to the order id listed below
				      {
					    System.out.println("Found"); 
				      }
				  }
			  catch(NoSuchElementException e)
				 {
				 	System.out.println("Not Found");
				 }	
				 
				
		}*/
		/*public void fill()
		{
			String order_status_to_search="566" + "Cancelled" + "avengers team" + "1,932";
			driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
			try { 
			    WebElement t= driver.findElement(By.xpath("//*[@id=\"form-order\"]/div/table/tbody/tr/td[2]"));// xpath od the order id listed below after clicking filter
			    String order_statusListed=t.getText();//getting the value of the order id listed below
			    if(order_status_to_search.equals(order_statusListed))//checking wether the id wch we entered in order id matches to the order id listed below
			      {
				    System.out.println("Found"); 
			      }
			  }
		  catch(NoSuchElementException e)
			 {
			 	System.out.println("Not Found");
			 }	
		}*/
		/*public void checkbeginswitha() {
			// TODO Auto-generated method stub
			//String customerText="abc def";
			 driver.findElement(customer_search).click();
		String exampleString = driver.findElement(customerText).getText();
		driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
			//System.out.println("\n"+exampleString);
			// String begins with R
			Pattern p = Pattern.compile("^a.*");
			Matcher m = p.matcher(exampleString);
			boolean b = m.matches();
			System.out.println("String begins with a is "+b);
			 
			
		}*/
		
		public String checkbeginswitha()
		{
			 driver.findElement(customer_search).click();
			 
			//String txt=driver.findElement(By.xpath("//*[@id=\"input-customer\"]")).getText();
			String cust_name_begins_with_a="a";
			
			 driver.findElement(customer_search).sendKeys(cust_name_begins_with_a);
			driver.findElement(By.xpath("//*[@id=\"button-filter\"]")).click();
			return cust_name_begins_with_a;
			
		}

	}





