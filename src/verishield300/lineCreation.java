package verishield300;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class lineCreation {
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		// Set the path to the ChromeDriver executable

		System.setProperty("webdriver.edge.driver", "C:\\Shriram\\Oct23_Selenium\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		
		 try (FileInputStream fis = new FileInputStream("C:\\Shriram\\Oct23_Selenium\\Excelsheets\\ProductList.xlsx");

			        XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			        XSSFSheet sheet = workbook.getSheetAt(0);

			        XSSFRow headerRow = sheet.getRow(0);

			        boolean isFirstRow = true;
					
			        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)
			        {
			        	 XSSFRow dataRow = sheet.getRow(rowIndex);

			             if (isFirstRow) {

			                 

			                driver.get("https://172.16.57.34/login/");

			                Thread.sleep(3000);

			                System.out.println("URL opening");

			                

			                WebElement advance = driver.findElement(By.id("details-button"));

			                advance.click();

			                System.out.println("click on advance option");

			                

			                WebElement proceed = driver.findElement(By.id("proceed-link"));

			                proceed.click();

			                System.out.println("click on procced");



			                WebElement username =driver.findElement(By.xpath("//input[@name='email']"));

			                username.sendKeys("vaibhav");

			                Thread.sleep(3000);

			                System.out.println("username inserted");



			                WebElement password =driver.findElement(By.xpath("//input[@name='password']"));

			                password.sendKeys("Tnt@1234");

			                Thread.sleep(3000);

			                System.out.println("password inserted");



			                WebElement loginButton=driver.findElement(By.xpath( "//input[@value='Login']"));

			                loginButton.click();

			                Thread.sleep(3000);

			                System.out.println("logged in");
			                
			                
			                WebElement master_data=driver.findElement(By.xpath( "//*[@id=\"mainmenutnt\"]/a"));

			                master_data.click();

			                Thread.sleep(30000);

			                System.out.println("Master data tab");

			                

			                WebElement locations=driver.findElement(By.xpath( "//*[@id=\"datacontenttab_5\"]/a"));

			                locations.click();

			                Thread.sleep(3000);

			                System.out.println("Location menu opened");
			                
			                isFirstRow = false;
			                
			                
			                WebElement editLine=driver.findElement(By.xpath( "//*[@id=\"locations_table_row_56\"]/td[10]/a"));

			                editLine.click();

			                Thread.sleep(3000);

			                System.out.println("Line opened");
			                
			                isFirstRow = false;
			                
			                
			                WebElement systems=driver.findElement(By.xpath( "//*[@id=\"ui-id-10\"]"));

			                systems.click();

			                Thread.sleep(3000);

			                System.out.println("Systems opened");
			                
			                isFirstRow = false;
			                
			                
			                WebElement AddSystem=driver.findElement(By.xpath( "//*[@id=\"linemanager\"]/input"));
			                systems.click();
			                Thread.sleep(1000);
			                systems.click();
			                Thread.sleep(1000);
			                System.out.println("Add Systems");
			                
			                isFirstRow = false;
			                
			                
			           
			             }
			     else {

	                 Thread.sleep(30000);

	                 
	                 
		                WebElement newLine=driver.findElement(By.xpath( "//*[@id=\"lineslist\"]/a/i"));

		                newLine.click();

		                Thread.sleep(3000);

		                System.out.println("new line");
		                
		                isFirstRow = false;
		                
			           }
			             for (int columnIndex = 0; columnIndex < dataRow.getLastCellNum(); columnIndex++) {

			                 XSSFCell cell = dataRow.getCell(columnIndex);

			                 String cellValue = "";



			                 if (cell != null) {

			                     CellType cellType = cell.getCellType();

			                     switch (cellType) {

			                     case STRING:

			                         cellValue = cell.getStringCellValue();



			                         break;



			                     case NUMERIC:



			                         cellValue = String.valueOf(cell.getNumericCellValue());



			                         break;



			                     case BOOLEAN:



			                         cellValue = String.valueOf(cell.getBooleanCellValue());



			                         break;



			                     }



			                 }
                      

			                 Thread.sleep(30000);



			                 if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Line name"))
			                 {
			                	 WebElement LineName = driver.findElement(By.xpath("//input[@name='line_name']"));
			                     Thread.sleep(3000);
                                 LineName.sendKeys(cellValue);
			                 }
			                 
			                 else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Location"))
			                 {
			                	 WebElement Locatn = driver.findElement(By.xpath("//*[@id=\"line_location_id\"]/option[16]"));
			                	 Thread.sleep(1000);

		                         Select linename=new Select(Locatn);

		                         linename.selectByVisibleText(cellValue);
                                 }
			                 
			                 else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Line number"))
			                 {
			                	 WebElement LineNo = driver.findElement(By.xpath("//*[@id=\"line_number\"]"));
			                	 Thread.sleep(1000);

		                         Select linenum=new Select(LineNo);

		                         linenum.selectByVisibleText(cellValue);
                                 }
			                 
			                 else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Line number"))
			                 {
			                	 WebElement LineNo = driver.findElement(By.xpath("//*[@id=\"line_number\"]"));
			                	 Thread.sleep(1000);

		                         Select linenum=new Select(LineNo);

		                         linenum.selectByVisibleText(cellValue);
                                 }
			                 
			                 
			                 
			             
			             }}
			             

			             
			        
			        
			        }
		

	

		 }
}