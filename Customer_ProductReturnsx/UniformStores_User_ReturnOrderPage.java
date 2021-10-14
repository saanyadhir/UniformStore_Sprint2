package UniformPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UniformStores_User_ReturnOrderPage {
WebDriver driver;
//By orderid = By.xpath("//table/tbody/descendant::td[contains (text(),\"#555\")]/following-sibling::td[6]/a");


public UniformStores_User_ReturnOrderPage(WebDriver driver)
{
	this.driver = driver;
	
}
By status = By.xpath("//*[@id=\"content\"]/h1");
/**
 * Find radio button using Xpath, Validate isDisplayed and click to select
 */
public void movetoOrderHistory() {
	// TODO Auto-generated method stub
	driver.findElement(By.cssSelector("#content > ul:nth-child(6) > li:nth-child(1) > a")).click();
	//HomePage home=new HomePage(driver);
}

public void clickordereditem() 
{
	driver.findElement(By.cssSelector("#content > div.table-responsive > table > tbody > tr:nth-child(1) > td:nth-child(7) > a")).click();
}

/*{
	 //int orderid = 557;
	 String exp= "#content > div.table-responsive > table > tbody > tr:nth-child(1) > td:nth-child(7) > a";
	 String act;
	 int num = driver.findElements(By.className("btn btn-info")).size();
		
		for(int i =0; i<num-1; i++)
		{
			act = driver.findElements(By.className("btn btn-info")).get(i).getAttribute("#content > div.table-responsive > table > tbody > tr:nth-child(1) > td:nth-child(7) > a");
			
  
        // print result
        if (act.equals(exp))
        {
			driver.findElements(By.className("btn btn-info")).get(i).click();
			break;
		}
        
		}
	}*/

public void clickreturnbtn()
{
	driver.findElement(By.cssSelector("#content > div.table-responsive > table > tbody > tr:nth-child(1) > td:nth-child(6) > a.btn.btn-danger > i")).click();
}

public void reasonforreturn()
{
	String exp = "1";
	String act;
	System.out.println("size of return radio button "+driver.findElements(By.name("return_reason_id")).size());
    int num = driver.findElements(By.name("return_reason_id")).size();
	
	for(int i =0; i<num-1; i++)
	{
		act = driver.findElements(By.name("return_reason_id")).get(i).getAttribute("value");
		System.out.println("\nSelected value is "+act);
		if(act.equalsIgnoreCase(exp))
		{
			driver.findElements(By.name("return_reason_id")).get(i).click();
			break;
		}
	}
	driver.findElement(By.cssSelector("#content > form > div > div.pull-right > input[type=checkbox]:nth-child(2)")).click();
}

public void clickSubmitButton() {
	// TODO Auto-generated method stub
	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input[2]")).click();
	//HomePage home=new HomePage(driver);
}

public String getreturnstatus()
{
	System.out.println(driver.findElement(status).getText());
	return driver.findElement(status).getText();
}
}

	


