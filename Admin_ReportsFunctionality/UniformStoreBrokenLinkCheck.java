package Util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//How to find Broken Links using Selenium WebDriver?
public class UniformStoreBrokenLinkCheck {
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver","E:\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Maximize page
		driver.manage().window().maximize();
		
		//Implicit wait for 10 secs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Open URL OF app
		driver.get("http://uniformm1.upskills.in/index.php?route=account/register");
		
		//wait
		Thread.sleep(5000);
		
		//capture links from a weebpage
		List <WebElement> links = driver.findElements(By.tagName("a"));
		
		//nUMBER OF LINKS
		System.out.println(links.size());
		
		for(int i=0; i<links.size();i++)
		{
			//by using href attribute we can get url of required link
			
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			
			
			URL link = new URL(url);
			
			//create a connection using url object 'link'
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			//wait time 2 seconds
			Thread.sleep(2000);
			//establish connection
			httpConn.connect();
			
			int rescode = httpConn.getResponseCode();//return response code,if res code is above 400: broken link
			
			if(rescode>=400)
			{
				System.out.println(url +" - "+" is broken link");
			}
			else
			{
				System.out.println(url +" - "+" is valid link");
			}
			
			
			
		}
	
	}
}