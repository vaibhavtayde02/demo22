package verishield300;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class login {
public static void main(String[] args) throws InterruptedException {
		
	System.setProperty("webdriver.edge.driver", "C:\\Shriram\\Oct23_Selenium\\msedgedriver.exe");
	EdgeOptions options = new EdgeOptions();
	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	
		System.out.println("Browser opening");
		Thread.sleep(3000);
		
		driver.get("https://172.16.70.119/login/?redir=index");
		Thread.sleep(3000);
		System.out.println("URL opening");
		
		WebElement advance = driver.findElement(By.id("details-button"));
		advance.click();
		System.out.println("click on advance option");
		
		WebElement proceed = driver.findElement(By.id("proceed-link"));
		proceed.click();
		System.out.println("click on procced");

		
	    WebElement username = driver.findElement(By.name("email"));
	    username.sendKeys("vaibhav");	
		Thread.sleep(3000);
	    System.out.println("user name");
	    
	    
	    WebElement password = driver.findElement(By.name("password"));
	    password.sendKeys("tnt1234");
		Thread.sleep(3000);
	    System.out.println("password");
	    
	    WebElement loginbutton = driver.findElement(By.id("loginhoder"));
	    loginbutton.click();
		Thread.sleep(3000);
	    System.out.println("login done");

}
}


