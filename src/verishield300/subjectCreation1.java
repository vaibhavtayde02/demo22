package verishield300;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class subjectCreation1 {		
		
		@FindBy(xpath="/html/body/div[4]/div[2]/div[6]/a[1]/i")
		private WebElement subnew;
		
		@FindBy(xpath="//*[@id=\"subjectname\"]")
		private WebElement subname;
		
		@FindBy(xpath="//*[@id=\"subjectgroup_id\"]")
		private WebElement subgrop;
		
		//Select s1=new Select(subgrop);
		
		@FindBy(xpath="//*[@id=\"subject_address\"]")
		private WebElement address;
		
		@FindBy(xpath="//*[@id=\"subject_city\"]")
		private WebElement city;
		
		@FindBy(xpath="//*[@id=\"subject_zip\"]")
		private WebElement zip;
		
		@FindBy(xpath="//*[@id=\"subject_state\"]")
		private WebElement state;
		
		@FindBy(xpath="//*[@id=\"subject_country\"]")
		private WebElement country;
		
		//Select s2=new Select(country);
		
		@FindBy(xpath="//*[@id=\"subjectdesc\"]")
		private WebElement description;
		
		@FindBy(xpath="(//input[@id='property_24'])[2]")
		private WebElement gs1;
		
		
		@FindBy(xpath="/html/body/div[4]/div[2]/div[7]/div[1]/i[1]")
		private WebElement save;
		
		@FindBy(xpath="(//span[@class='ui-button-text'])[2]")
		private WebElement ok;
	
		
		public void clickNewSubject() {
			
			subnew.click();
			
		}
		
	  public void GetName() {
			
		  subname.sendKeys("Dummy");
			
		}
	  
	  public void GetGroup() {
		  
		  subgrop.sendKeys("Manufacturer");
		
	}
	  public void getAddress() {
		  address.sendKeys("Kandivali");
		
	}
	  public void getCity() {
		  city.sendKeys("mumbai");
		
	}
	  public void getZip() {
		zip.sendKeys("234567");
	}
	  public void getState() {
		  state.sendKeys("MH");
		
	}
		public void getCountry() {
			
			//s2.selectByVisibleText("India");
			country.sendKeys("India");
			
		}
		
		public void getDescription() {
			description.sendKeys("automation subject");
		}
	  
		public void getGS1() {

			gs1.sendKeys("5673450");
		}
		public void getSave() {
			save.click();
			
		}
		
		public void clickOnOk() {
			ok.click();
			
		}
		
		public  void NewSubject(WebDriver d5) 
		{
			PageFactory.initElements(d5, this);	
		}
	
	
}
