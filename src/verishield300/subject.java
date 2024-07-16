package verishield300;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class subject {
	public static void main(String[] args) throws InterruptedException, IOException {
		//----------------driver initialization--------------------//
		System.setProperty("webdriver.edge.driver","C:\\Shriram\\Oct23_Selenium\\msedgedriver.exe");
		EdgeOptions options= new EdgeOptions();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize(); 
		//--------------------login---------------------------------------//
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://172.16.70.187/login/?redir=index");
		
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(60));
		
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("vaibhav");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tnt1234");
		driver.findElement(By.xpath("//*[@id=\"loginhoder\"]/input")).click();
		
		//------------------------MasterData tab-----------------//
		
		WebElement masterdata=driver.findElement(By.xpath("//a[text() ='Master data']"));
		masterdata.click();
	
		WebElement sub=driver.findElement(By.xpath("//a[text()='Subjects']"));
		sub.click();
		
		WebElement newsub=driver.findElement(By.xpath("//i[@title='New subject']"));
		newsub.click();
		
		Thread.sleep(2000);
		
		WebElement subname=driver.findElement(By.xpath("//input[@name='subjectname']"));
		subname.sendKeys("Company7 LTD1 (TEST)");
		
		WebElement subgrp=driver.findElement(By.xpath("//select[@id='subjectgroup_id']"));
		Select manf=new Select(subgrp);
		manf.selectByVisibleText("Manufacturer");
		
		WebElement city=driver.findElement(By.xpath("//input[@id='subject_city']"));
		city.sendKeys("Mumbai");
		
		WebElement zip=driver.findElement(By.xpath("//input[@id='subject_zip']"));
		zip.sendKeys("400067");
		
		WebElement state=driver.findElement(By.xpath("//input[@id='subject_state']"));
		state.sendKeys("Maharashtra");
		
		WebElement country=driver.findElement(By.xpath("//select[@id='subject_country']"));
		Select ind=new Select(country);
		ind.selectByVisibleText("India");
		
		Thread.sleep(1000);
		
		WebElement gln=driver.findElement(By.xpath("//input[@id='property_28' and @class='certtitle subjectpropertyvalue ']"));
		gln.sendKeys("1234566018294");
		
		WebElement gcp=driver.findElement(By.xpath("//input[@id='property_24' and @class='certtitle subjectpropertyvalue  numeric']"));
		gcp.sendKeys("1234566");
		
		WebElement sgln=driver.findElement(By.xpath("(//input[@id='property_29'])[2]"));
		sgln.sendKeys("8");
        
		WebElement savesub=driver.findElement(By.xpath("//i[@id='savesubjectbutton']"));
		savesub.click();
		
		WebElement ok=driver.findElement(By.xpath(("(//span[@class='ui-button-text'])[2]")));
        ok.click();
		
		
	}
	
	}	


