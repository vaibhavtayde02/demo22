package verishield300;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class prodCretnn {
	private static final WebDriver WebDriver = null;

	public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "C:\\Shriram\\Oct23_Selenium\\msedgedriver.exe");
		EdgeOptions options = new EdgeOptions();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();

    try (FileInputStream fis = new FileInputStream("E:\\ACG\\ACG2\\Common_excel_for_l4 1.xlsx");

        		XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
                XSSFSheet sheet = workbook.getSheetAt(10);
                XSSFRow headerRow = sheet.getRow(0);
 
    boolean isFirstRow = true;

        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++)

            {
                Row dataRow = sheet.getRow(rowIndex);

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
                    System.out.println("username taken");

                    WebElement password =driver.findElement(By.xpath("//input[@name='password']"));
                    password.sendKeys("tnt1234");
                    Thread.sleep(3000);
                    System.out.println("password taken");

                    WebElement loginButton=driver.findElement(By.xpath( "//input[@value='Login']"));
                    loginButton.click();
                    Thread.sleep(3000);
                    System.out.println("login done ");

                    WebElement masterdata=driver.findElement(By.xpath( "//*[@id=\"mainmenutnt\"]/a"));
                    masterdata.click();
                    Thread.sleep(3000);
                    System.out.println("masterdata tab ");

                    WebElement Products=driver.findElement(By.xpath( "//*[@id=\"datacontenttab_3\"]/a"));
                    Products.click();
                    Thread.sleep(3000);
                    System.out.println("Product Tab ");

                    WebElement newProduct=driver.findElement(By.xpath("//*[@id=\"datacontentinner_tab_3\"]/a[1]/i"));
                    newProduct.click();
                    Thread.sleep(3000);
                    System.out.println("New product tab open");

               isFirstRow = false;

             }

         else {
                  Thread.sleep(30000);

                   WebElement newProduct=driver.findElement(By.xpath("//*[@id=\"datacontentinner_tab_3\"]/a[1]/i"));
                   newProduct.click();
                   Thread.sleep(3000);
                   System.out.println("New product tab open");
              }

             for (int columnIndex = 0; columnIndex < dataRow.getLastCellNum(); columnIndex++) {

                    Cell cell = dataRow.getCell(columnIndex);
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
                if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("ProductName")) {
                        
                    	WebElement productName = driver.findElement(By.xpath("//input[@id='product_name']"));
                        productName.sendKeys(cellValue);
                        }

           //       else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("ProductCode")) {

             //           WebElement productCode = driver.findElement(By.xpath("//select[@id='product_group_id']"));
              //          productCode.sendKeys(cellValue);
               //         } 

                  else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("ProductDescription")) {

                        WebElement productDescription = driver.findElement(By.xpath("//textarea[@id='product_desc']"));
                        productDescription.sendKeys(cellValue);
                        }

                  else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Manufacturer")) {

                        WebElement manufacturer = driver.findElement(By.xpath("//select[@id='manufacturer_id']"));
                        Select selectManufacturer = new Select(manufacturer);
                        selectManufacturer.selectByVisibleText(cellValue);
                        }

                 else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("ProductGroup")) {

                        WebElement productGroup = driver.findElement(By.xpath("//*[@id=\"product_group_id\"]"));
                        Select selectProductGroup = new Select(productGroup);
                        selectProductGroup.selectByVisibleText(cellValue);
                        }

                 else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("UnitPrice")) {

                        WebElement unitPrice = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/input"));
                        unitPrice.sendKeys(cellValue);
                        }

                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("GenericName")) {

                        WebElement genericName = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div[3]/div[2]/div[1]/table/tbody/tr[5]/td[2]/input"));
                        genericName.sendKeys(cellValue);
                        }

                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("Licensenumber")) {

                        WebElement licenseNumber = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[3]/div[3]/div[2]/div[1]/table/tbody/tr[12]/td[2]/input"));
                        licenseNumber.sendKeys(cellValue);
                        }

               else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("LevelIndicator")) {

                        WebElement packging =driver.findElement(By.xpath("//*[@id=\"editproductinner\"]/div[2]/ul/li[4]"));
                        packging.click();

                        WebElement LevelIndicator = driver.findElement(By.xpath("//*[@id=\"productpackaging_table\"]/tbody/tr[3]/td[5]/select"));
                        LevelIndicator.sendKeys(cellValue);

                        Select ss1=new Select(LevelIndicator);//*[@id="productpackaging_table"]/tbody/tr[3]/td[5]/select
                        ss1.selectByValue("1");
                        }
                    
                else if (headerRow.getCell(columnIndex).getStringCellValue().equalsIgnoreCase("ItemReference")) {

                        Thread.sleep(1000);
                        WebElement itemReference = driver.findElement(By.cssSelector("#productpackaging_table > tbody > tr.packagingcontainer > td.productpackagingitemreference_holder > input"));
                        itemReference.sendKeys(cellValue);
                        }
                    }

                        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"saveproductbutton\"]"));
                        saveButton.click();

                        WebElement ok=driver.findElement(By.xpath(("(//button[@type='button'])[2]")));
                        ok.click();
                 }
            } 
    catch (IOException e) {
                 e.printStackTrace();
                 }
    // Close the browser
          driver.quit();
          }
}


