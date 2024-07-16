package verishield300;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createProduct {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the WebDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\Shriram\\Oct23_Selenium\\msedgedriver.exe");
        EdgeOptions options = new EdgeOptions();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        try (FileInputStream fis = new FileInputStream("E:\\ACG\\ACG2\\Common_excel_for_l4 1.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            // Assuming the sheet index 11 contains the data (adjust as per your Excel sheet)
            XSSFSheet sheet = workbook.getSheetAt(10);

            // Navigate to the web application login page only once
            driver.get("https://172.16.70.187/login/?redir=index");
            Thread.sleep(3000);
            System.out.println("URL opening");

            WebElement advance = driver.findElement(By.id("details-button"));
            advance.click();
            Thread.sleep(1000);
            WebElement proceed = driver.findElement(By.id("proceed-link"));
            proceed.click();
            Thread.sleep(1000);

            // Perform login
            WebElement username = driver.findElement(By.xpath("//input[@name='email']"));
            username.sendKeys("vaibhav");
            Thread.sleep(1000);

            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("tnt1234");
            Thread.sleep(1000);

            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
            loginButton.click();
            Thread.sleep(3000);

            // Iterate through each row in the sheet (starting from the second row)
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                // Extract data from each cell in the row
                String productName = row.getCell(0).getStringCellValue();
                String productDescription = row.getCell(2).getStringCellValue();
                String manufacturer = row.getCell(3).getStringCellValue();
                String ItemReference = String.valueOf(row.getCell(13).getNumericCellValue());

                WebElement masterDataTab = driver.findElement(By.xpath("//*[@id=\"mainmenutnt\"]/a"));
                masterDataTab.click();
                Thread.sleep(2000);

                WebElement productsTab = driver.findElement(By.xpath("//*[@id=\"datacontenttab_3\"]/a"));
                productsTab.click();
                Thread.sleep(2000);

                WebElement newProductButton = driver.findElement(By.xpath("//*[@id=\"datacontentinner_tab_3\"]/a[1]/i"));
                newProductButton.click();
                Thread.sleep(3000);

                // Fill in product details
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class);

                WebElement productNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='product_name']")));
                productNameField.sendKeys(productName);
                Thread.sleep(1000);

                WebElement productDescField = driver.findElement(By.xpath("//textarea[@id='product_desc']"));
                productDescField.sendKeys(productDescription);
                Thread.sleep(1000);

                WebElement manufacturerDropdown = driver.findElement(By.xpath("//select[@id='manufacturer_id']"));
                Select selectManufacturer = new Select(manufacturerDropdown);
                selectManufacturer.selectByVisibleText(manufacturer);
                Thread.sleep(1000);

                WebElement packaging = driver.findElement(By.xpath("//a[text()='Product packaging']"));
                packaging.click();
                Thread.sleep(2000);

                WebElement ItemReferenceField = driver.findElement(By.xpath("//input[@class='productpackagingitemreference numeric']"));
                ItemReferenceField.sendKeys(ItemReference);
                Thread.sleep(1000);

                // Save the product
                WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"saveproductbutton\"]"));
                saveButton.click();
                Thread.sleep(3000);

                // Handle confirmation dialog (if any)
                WebElement okButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
                okButton.click();
                Thread.sleep(2000);
                
             // Replace WebDriverWait with FluentWait for specific text to be present
                Wait<WebDriver> waitt = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(1))
                        .ignoring(NoSuchElementException.class);

                waitt.until(ExpectedConditions.textToBe(By.xpath("//table[@id='products_table']/tbody/tr[1]/td[2]"), "productName"));

                
                
                WebElement activate=driver.findElement(By.xpath("//table[@id='products_table']/tbody/tr[1]/td[8]/a[@title='Activate product']"));
                activate.click();
                Thread.sleep(2000);
                
                WebElement okbut=driver.findElement(By.xpath("(//span[@class='ui-button-text'])[2]"));
                okbut.click();
                		
            };
            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the WebDriver session
            // driver.quit();
        }
    }
}

