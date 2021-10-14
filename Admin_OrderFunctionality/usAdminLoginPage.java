package com.appname.pages;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


 //This class will store all the locators and methods of Login page
 
public class usAdminLoginPage {
WebDriver driver;	

//login
By username= By.id("input-username");
By password = By.id("input-password");
By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
By HeaderText = By.xpath("//*[@id=\"content\"]/div[1]/div/h1");

//Filter Product
By order_id=By.id("input-order-id");
//By order_status=By.id("input-order-status");
By cust_name=By.id("input-customer");
By totals=By.id("input-total");
By Assert=By.xpath("//*[@id=\"form-order\"]/div/table/thead/tr/td[2]/a");
By filter=By.xpath("//*[@id=\"button-filter\"]");
By shop_cart=By.xpath("//*[@id=\"sale\"]/a/i");
By Order_sec=By.xpath("//*[@id=\"sale\"]/ul/li[1]/a");
By order_status=By.id("input-order-status");
//By Disabled=By.xpath("//*[@id=\"input-status\"]/option[3]");


//creating parameterized constructor to initialize WebDriver reference
public usAdminLoginPage(WebDriver driver)
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
		driver.findElement(shop_cart).click();
		driver.findElement(Order_sec).click();
		
		boolean success=this.isHeaderFound();
		return success;
	
	}

	public String getUSLoginTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		
		System.out.println(driver.getTitle());
		String curTitle = driver.getTitle();
		return curTitle;	
	}
	
//FILTER PRODUCT
	public boolean filter(String orderid,String custname, String total , String Status) {
		boolean status=true;
		try {
		StringBuffer pname=new StringBuffer(orderid);
        
		driver.findElement(order_id).click();
		 driver.findElement(order_id).sendKeys(orderid);
		 driver.findElement(cust_name).click();
		 driver.findElement(cust_name).sendKeys(custname);
		 driver.findElement(totals).click();
		 driver.findElement(totals).sendKeys(total);
		 driver.findElement(order_status).click();
		 driver.findElement(order_status).sendKeys(Status);
		 
		 Select slc = new Select(driver.findElement(order_status));
			slc.selectByValue("2");
			
		 driver.findElement(order_status).click();
		 /*driver.findElement(enabled).click();
		 String txt=driver.findElement(enabled).getText();
		System.out.println(txt);*/
		driver.findElement(filter).click();
			WebElement assertDataEle=driver.findElement(Assert);
			String assertData=assertDataEle.getText();
			StringBuffer datamatch=new StringBuffer(assertData);
		    if(datamatch.substring(0).equals(pname.substring(0)))
		     {
			System.out.println("Matching Product Found for the  keyword: "+order_id+"  is: "+assertData);
			 status=true;
		     }
		   
		   
		   }
	catch(NoSuchElementException e)
		{
			System.out.println("Not Found");
			status=true;
		}	
		return status;
		
	}
	
	


	}
	


