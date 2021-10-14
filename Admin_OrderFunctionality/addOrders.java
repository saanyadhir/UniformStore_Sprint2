package com.appname.pages;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


 //This class will store all the locators and methods of Login page
 
public class addOrders {
WebDriver driver;	

By username= By.id("input-username");

By password = By.id("input-password");
By loginbutton = By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button");
By HeaderText = By.xpath("//*[@id=\"content\"]/div[1]/div/h1");

By Shop_list =By.xpath("//*[@id=\"sale\"]/a/i");
By O_list =By.xpath("//*[@id=\"sale\"]/ul/li[1]/a");
By addicon = By.xpath("//*[@id=\"content\"]/div[1]/div/div/a");
By cust_sec= By.xpath("//*[@id=\"order\"]/li[1]/a");
By store = By.id("input-store");

By firstname=By.id("input-firstname");
By lastname= By.id("input-lastname");
By email = By.id("input-email");
By tele =By.id("input-telephone");

By prod_sec =By.xpath("//*[@id=\"tab-cart\"]/ul/li[1]/a");
By choose_prod =By.id("input-product");
By paydet_sec=By.xpath("//*[@id=\"order\"]/li[3]/a");
By p_fname = By.id("input-payment-firstname");
By p_lname = By.id("input-payment-lastname");
By p_addr = By.id("input-payment-address-1");
By p_city = By.id("input-payment-city");
By p_postcode = By.id("input-payment-postcode");
By p_country = By.id("input-payment-country");
By p_state = By.xpath("//*[@id=\"input-payment-zone\"]");
By textarea= By.xpath("//*[@id=\"input-product\"]");

By s_fname = By.id("input-shipping-firstname");
By s_lname = By.id("input-shipping-lastname");
By s_addr = By.id("input-shipping-address-1");
By s_city = By.id("input-shipping-city");
By s_postcode = By.id("input-shipping-postcode");
By s_country = By.id("input-shipping-country");
By s_state = By.xpath("//*[@id=\"input-shipping-zone\"]");
//By btn_addprd= By.id("button-product-add");
//By inputShippingmethod= By.id("input-shipping-method");
//By con_btn =By.xpath("//*[@id=\"button-cart\"]");
By ship_sec=By.xpath("//*[@id=\"order\"]/li[4]/a");
By totalsec=By.xpath("//*[@id=\"tab-total\"]/fieldset/div[1]/label");
By ship_met =By.id("input-shipping-method");
By pay_meth=By.id("input-payment-method");

public addOrders(WebDriver driver)
{
	this.driver =driver;
}



	public void AdminLogin(String un,String pw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		
		//driver.findElement(cust_sec).click();
		//driver.findElement(prod_sec).click();
		
	
	}
	public void func()
	{
		driver.findElement(loginbutton).click();
		driver.findElement(Shop_list).click();
		driver.findElement(O_list).click();
		driver.findElement(addicon).click();
		//driver.findElement(btn_addprd).click();
		//driver.findElement(s_state).click();
		
	}
	

	public String getUSLoginTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		
		System.out.println(driver.getTitle());
		String curTitle = driver.getTitle();
		return curTitle;
		
		
	}
	
		
	
	
	public void selectCust()
	{
		 driver.findElement(firstname).click();
		 driver.findElement(cust_sec).click();
			
			String order_id_to_search2="Myadmin";
			String order_id_to_search3="smith";
			String order_id_to_search4="my@gmail.com";
			String order_id_to_search5="999888777";
		
			
			
			 
			 driver.findElement(firstname).sendKeys(order_id_to_search2);
			 driver.findElement(lastname).sendKeys(order_id_to_search3);
			 driver.findElement(email).sendKeys(order_id_to_search4);
			 driver.findElement(tele).sendKeys(order_id_to_search5);
			 
			 
			 
			 
			 
			 driver.findElement(By.xpath("//*[@id=\"button-customer\"]")).click();
			 
			
			 
			
	}
	public void product_type()
	{
		driver.findElement(prod_sec).click();
		
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/img"));
		//String order_id_to_search="RED raincoat";#tab-product > fieldset > div:nth-child(2) > div > ul > li > a
		 //driver.findElement(choose_prod).sendKeys(order_id_to_search);
		String value = "RED r";
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"tab-product\"]/fieldset/div[1]/div/ul"));
		
		driver.findElement(textarea).sendKeys(value);// assuming you have to click the "dropdown" to open it
		dropdown.click();
		//dropdown.findElement(By.cssSelector("#tab-product > fieldset > div:nth-child(2) > div > ul")).click();
		/*WebElement countryUL= driver.findElement(By.xpath("//*[@id=\"input-product\"]"));
		List<WebElement> countriesList=countryUL.findElements(By.tagName("a href"));
		for (WebElement li : countriesList) {
		if (li.getText().equals("RED raincoat")) {
		li.click();
		}
		}*/
		 //driver.findElement(By.id("button-product-add")).click();
		driver.findElement(By.id("button-product-add")).click();
		 driver.findElement(By.id("button-cart")).click();
		 try { 
			    WebElement t= driver.findElement(By.xpath("//*[@id=\"tab-cart\"]/div[1]/table/thead/tr/td[1]"));// xpath od the order id listed below after clicking filter
			    String order_idListed=t.getText();//getting the value of the order id listed below
			    if(value.equals(order_idListed))//checking wether the id wch we entered in order id matches to the order id listed below
			      {
				    System.out.println("Found"); 
			      }
			  }
		  catch(NoSuchElementException e)
			 {
			 	System.out.println("Not Found");
			 }	
	}
	
	public void pay_det()
	{
		driver.findElement(paydet_sec).click();
		driver.findElement(p_fname).click();
		driver.findElement(p_lname).click();
		driver.findElement(p_addr).click();
		driver.findElement(p_city).click();
		driver.findElement(p_postcode).click();
		driver.findElement(p_country).click();
		//driver.findElement(p_state).click();
		
		String order_id_to_search="myhost";
		String order_id_to_search1="local";
		String order_id_to_search2="near HO";
		String order_id_to_search3="Banglore";
		String order_id_to_search4="987098";
		String order_id_to_search5="India";
		//String order_id_to_search6="Kerala";
		
		String value = "Karnataka";
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]"));
		
		driver.findElement(p_state).sendKeys(value);// assuming you have to click the "dropdown" to open it
		dropdown.click();
		
		 driver.findElement(p_fname).sendKeys(order_id_to_search);
		 driver.findElement(p_lname).sendKeys(order_id_to_search1);
		 driver.findElement(p_addr).sendKeys(order_id_to_search2);
		 driver.findElement(p_city).sendKeys(order_id_to_search3);
		 driver.findElement(p_postcode).sendKeys(order_id_to_search4);
		 driver.findElement(p_country).sendKeys(order_id_to_search5);
		 //driver.findElement(p_state).sendKeys(order_id_to_search6);
		 
		 
		 driver.findElement(By.id("button-payment-address")).click();
		
	}
	
	public void ship_det()
	{
		driver.findElement(ship_sec).click();
		driver.findElement(s_fname).click();
		driver.findElement(s_lname).click();
		driver.findElement(s_addr).click();
		driver.findElement(s_city).click();
		driver.findElement(s_postcode).click();
		driver.findElement(s_country).click();
		//driver.findElement(s_state).click();
		
		String order_id_to_search="myhostss";
		String order_id_to_search1="locals";
		String order_id_to_search2="near HO";
		String order_id_to_search3="Banglore";
		String order_id_to_search4="987098";
		String order_id_to_search5="India";
		String order_id_to_search6="Jammu and Kashmir";
		String value = "Jammu and Kashmir";
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"input-shipping-zone\"]"));
		
		driver.findElement(s_state).sendKeys(value);// assuming you have to click the "dropdown" to open it
		dropdown.click();
		
		 driver.findElement(s_fname).sendKeys(order_id_to_search);
		 driver.findElement(s_lname).sendKeys(order_id_to_search1);
		 driver.findElement(s_addr).sendKeys(order_id_to_search2);
		 driver.findElement(s_city).sendKeys(order_id_to_search3);
		 driver.findElement(s_postcode).sendKeys(order_id_to_search4);
		 driver.findElement(s_country).sendKeys(order_id_to_search5);
		 //driver.findElement(s_state).sendKeys(order_id_to_search6);
		 
		 
		 driver.findElement(By.id("button-shipping-address")).click();
	}
	public void total_shipmeth()
	{
		driver.findElement(ship_met).click();
		String value = "Free Shipping -";
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"input-shipping-method\"]/optgroup/option"));
		
		driver.findElement(ship_met).sendKeys(value);// assuming you have to click the "dropdown" to open it
		dropdown.click();
		driver.findElement(By.id("button-shipping-method"));
		//driver.findElement(pay_meth).click();
		
	}
	public void total_paymeth()
	{
		driver.findElement(pay_meth).click();
		String value = "Cash On ";
		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"input-payment-method\"]/option[2]"));
		
		driver.findElement(pay_meth).sendKeys(value);// assuming you have to click the "dropdown" to open it
		dropdown.click();
		driver.findElement(By.id("button-payment-method"));
		driver.findElement(By.id("button-save")).click();
		
	}
	
	
}