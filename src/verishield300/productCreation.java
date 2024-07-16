package verishield300;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class productCreation {

	public static void main(String[] args) throws InterruptedException {
		
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

                 

                driver.get("https://172.16.70.187/login/?redir=index");

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

                password.sendKeys("tnt1234");

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

                

                WebElement products=driver.findElement(By.xpath( "//*[@id=\"datacontenttab_3\"]/a"));

                products.click();

                Thread.sleep(3000);

                System.out.println("Products opened");

                

                isFirstRow = false;



            }

             else {

                 Thread.sleep(30000);

                 

                 WebElement newPO=driver.findElement(By.xpath( "/html/body/div[4]/div[2]/div[2]/a[1]/i"));

                 newPO.click();

                 Thread.sleep(3000);

                 System.out.println("New PO");

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



                if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("PO order name")) {

                   

                    WebElement ProductionorderName = driver.findElement(By.xpath("//input[@name='po_name']"));

                    Thread.sleep(3000);

                    ProductionorderName.sendKeys(cellValue);



                }



                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Serial numbers provider")) {



                         WebElement SerialNumber = driver.findElement(By.xpath("//*[@id=\"production_provider_id\"]/option[12]"));

                         Thread.sleep(1000);

                         Select serialprovi=new Select(SerialNumber);

                         serialprovi.selectByVisibleText(cellValue);



                }



                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Product")) {

                    

                         WebElement product = driver.findElement(By.xpath("//select[@name='packaging_product_id']"));

                         Thread.sleep(1000);

                         Select prodsel=new Select(product);

                         prodsel.selectByVisibleText(cellValue);



                }



              else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Packaging version")) {



                       WebElement pkgver = driver.findElement(By.xpath("//select[@name='packaging_product_version_id']"));



                       Thread.sleep(1000);



                       Select selectVersi = new Select(pkgver);



                       selectVersi.selectByVisibleText(cellValue);



                }



                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Lot/Batch number")) {



                         WebElement lotno = driver.findElement(By.xpath("//*[@id=\"production_lot\"]"));

                         Thread.sleep(1000);

                         lotno.sendKeys(cellValue);



                }



                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("MFG date")) {



                        WebElement mfcdate = driver.findElement(By.xpath("//input[@name='manufacturedate']"));

                        Thread.sleep(1000);

                       // mfcdate.click();

                        //mfcdate.clear();

                        mfcdate.sendKeys(cellValue);



                   }

                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Expiration date")) {



                        WebElement expdate = driver.findElement(By.xpath("//input[@name='expirationdate']"));

                        Thread.sleep(1000);

                        //expdate.click();

                        // expdate.clear();

                        expdate.sendKeys(cellValue);



               }

              else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Regulation")) {



                        WebElement regul = driver.findElement(By.xpath("//*[@id=\"po_standard_id\"]"));

                        Thread.sleep(1000);

                        Select regulset=new Select(regul);

                        regulset.selectByVisibleText(cellValue);



                }

              else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Manufacturing location")) {



                       WebElement manuloc =driver.findElement(By.xpath("//select[@id='location_id']"));

                      Thread.sleep(1000);

                      Select manulocsel=new Select(manuloc);

                      manulocsel.selectByVisibleText(cellValue);



                }

              else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Production line")) {

                      

                      Thread.sleep(1000);

                      WebElement linepo = driver.findElement(By.xpath("//*[@id=\"location_line_id\"]"));

                      Select polineSel=new Select(linepo);

                      polineSel.selectByVisibleText(cellValue);

                  

              }                      

              else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("QUANTITY")) {



                      WebElement quan = driver.findElement(By.xpath("//*[@id=\"prodorder_form\"]/div/div[3]/div/table/tbody/tr[2]/td[2]/input"));

                      Thread.sleep(1000);

                      quan.sendKeys(cellValue);

                     

                   }



                }

                //driver.switchTo().frame(0);

                

                WebElement source= driver.findElement(By.xpath("//div[@class='qp_line_system ui-draggable']"));

                WebElement target= driver.findElement(By.xpath("//div[@class='packdrop ui-droppable']"));

                // dragAndDrop() method for dragging the element from source to //destination

                Actions a = new Actions(driver);

                Thread.sleep(5000);

                a.dragAndDrop(source, target).build().perform();



                WebElement saveButton = driver.findElement(By.xpath("//i[@id='saveproductionbutton']"));

                saveButton.click();

                

                Thread.sleep(1000);



                WebElement ok=driver.findElement(By.xpath(("//button[@type='button'][2]")));

                ok.click();

                

                Thread.sleep(1000);

                



        }

 } catch (IOException e) {



     e.printStackTrace();

					 e.printStackTrace();

				 	}
	}
	
}
