package verishield300;


import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.its.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class inProduction 
{
	public static void main(String[] args) 
	{		
		
		try
		{

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACGi QA\\eclipse-workspace\\Automation Poject_Selenium\\Driver server\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		           
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://172.16.70.125/login/?redir=index");
			
			//WebDriverWait wait=new WebDriverWait(driver, 10);
			
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(60));
			
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.id("proceed-link")).click();
			
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("mukesh");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tnt1234");
			driver.findElement(By.xpath("//*[@id=\"loginhoder\"]/input")).click();
			
			String po_name = "POINPROD005";
			
           		
			
			//---------------------------------------------------------------------------------------------------------
			
			for(int i=1; i<=49; i++)
			{
				WebElement production_order=driver.findElement(By.xpath( "//*[@id=\"datacontenttab_2\"]/a"));
                production_order.click();
 
                Thread.sleep(10000);
 
 
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='productionorders_list_table']/tbody/tr[1]/td[11]/a[2]"))).click();
                po_name = po_name+i;
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='po_name']"))).click();
				
				driver.findElement(By.xpath("//input[@id='po_name']")).clear();
			    driver.findElement(By.xpath("//input[@id='po_name']")).sendKeys(po_name);
			
			    Thread.sleep(2000);
				
				driver.findElement(By.xpath("//*[@id='saveproductionbutton']")).click();
				
				
				driver.findElement(By.xpath("/html/body/div[11]/div[3]/div[1]/button[2]/span")).click();
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[2]/div[4]/table[1]/tbody/tr[1]/td[11]/a[1]"))).click();
				
				
				driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div[1]/i[3]")).click();
			
				
				driver.findElement(By.xpath("/html/body/div[11]/div[3]/div[1]/button[2]")).click();
				Thread.sleep(2000);
				
			}
                	
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		
		           
	}
}

