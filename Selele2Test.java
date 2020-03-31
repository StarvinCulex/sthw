package st;

import org.junit.Test;
import org.junit.Before;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public class Selele2Test {
  private WebDriver driver;
  private Map<String, Object> vars;
  private Workbook workbook;
  JavascriptExecutor js;
  private final String path = "F:\\documents\\Javaproj\\st";
  @Before
  public void setUp() throws FileNotFoundException, IOException {
	System.out.println(path + File.separator + "geckodriver.exe");
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "geckodriver.exe");
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
	File excelFile = new File(path +  File.separator +"Selenium+Lab2020.xlsx");
	workbook = new XSSFWorkbook(new FileInputStream(excelFile));
  }
  @After
  public void tearDown() throws IOException {
	workbook.close();
    driver.quit();
  }
  @Test
  public void seleTest() throws FileNotFoundException, IOException {
	Sheet sheet = workbook.getSheetAt(0);
    driver.get("http://103.120.226.190/selenium-demo/git-repo");
    for (Row row : sheet) {
    	if (row.getCell(1).getStringCellValue().equals("")) {
    		break;
    	}
	    driver.findElement(By.name("user_number")).click();
	    driver.findElement(By.name("user_number")).sendKeys(row.getCell(1).getStringCellValue());
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys(row.getCell(2).getStringCellValue());
	    driver.findElement(By.cssSelector(".btn")).click();
	    assertThat(driver.findElement(By.xpath("//div[5]/code")).getText(), is(row.getCell(2).getStringCellValue()));
    }
  }
}
