package verishield300;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class urlVldn {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// Set the path to the ChromeDriver executable

		System.setProperty("webdriver.edge.driver", "C:\\Shriram\\Oct23_Selenium\\msedgedriver.exe");
		

		 

		// Load the Excel file

		try (FileInputStream fis = new FileInputStream("\\E:\\500weblinkss.xlsx\\");

		XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

		// Get the first sheet from the workbook

		XSSFSheet sheet = workbook.getSheetAt(0);

		 

		// Create a new EdgeDriver instance

		EdgeOptions options = new EdgeOptions();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();

		 

		// Iterate over the rows of the sheet

		for (Row row : sheet) {

		Cell linkCell = row.getCell(0);

		if (linkCell == null || linkCell.getCellType() == CellType.BLANK) {

		continue; // Skip empty cells

		}

		String link = linkCell.getStringCellValue();

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		 

		// Extract the data from the webpage

		String data = driver.getTitle();

		 

		// Write the extracted data to the second column of the row

		Cell dataCell = row.createCell(1);

		dataCell.setCellValue(data);

		 

		// Save the changes to the Excel file after reading each link

		try {

		    // Calculate time between opening browser and opening URL

		    long startTime = System.currentTimeMillis();

		    driver.get(link);

		    long endTime = System.currentTimeMillis();

		    long timeElapsed = endTime - startTime;

		 

		    WebElement element1 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/h3"));

		    WebElement element2 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[1]/div/span[2]"));

		    WebElement element3 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[5]/div/span[2]"));

		    WebElement element4 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[8]/div/span[2]"));

		    //WebElement element5 = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/span[1]"));

		 

		    String data1 = element1.getText();

		    String data2 = element2.getText();

		    String data3 = element3.getText();

		    String data4 = element4.getText();

		    //String data5 = element5.getText();

		 



		    Cell dataCell1 = row.createCell(1);

		    dataCell1.setCellValue(data1);

		 

		    Cell dataCell2 = row.createCell(2);

		    dataCell2.setCellValue(data2);

		 

		    Cell dataCell3 = row.createCell(3);

		    dataCell3.setCellValue(data3);

		 

		    Cell dataCell4 = row.createCell(4);

		    dataCell4.setCellValue(data4);

		 

		   // Cell dataCell5 = row.createCell(5);

		   // dataCell5.setCellValue(data5);

		 

		    Cell timeCell = row.createCell(6);

		    timeCell.setCellValue(timeElapsed);

		 

		    try (FileOutputStream fos = new FileOutputStream("\\E:\\500weblinkss.xlsx\\")) {

		        workbook.write(fos);

		}} catch (IOException e) {

		e.printStackTrace();

		}

		}

		}

		}
}
