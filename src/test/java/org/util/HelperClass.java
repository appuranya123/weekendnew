package org.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HelperClass {
	// static variable
	public static WebDriver driver;
	public static FileInputStream fi;
	public static Workbook book;

	public static String dataFromExcel(String sheetName, int rowNo, int cellNo) {

		File f = new File("src\\test\\resources\\testdata\\testdata.xlsx");
		try {
			fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
		}

		try {
			book = new XSSFWorkbook(fi);
		} catch (IOException e) {
		}

		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);//111
		int cellType = cell.getCellType();// 1 or 0
		// 1 =String

		String value = null;
//         1==1
		if (cellType == 1) {
			value = cell.getStringCellValue();
		
		}
		//                                     111
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date d = cell.getDateCellValue();

			SimpleDateFormat s = new SimpleDateFormat("\"E, dd/MMM/yyyy HH:mm:ss z\"");
			value = s.format(d);
		} 
		else {
			double numericCellValue = cell.getNumericCellValue();//111.0
			long l = (long) numericCellValue;// 111
			
			value = String.valueOf(l);
			
		}

		return value;
	}
	
	

	public static void edgeBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	public static void passUrl(String url) {
		driver.get(url);
	}

	public static void allElementWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void textpass(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void elementClick(WebElement element) {
		element.click();
	}

	public static void screenShot(String name) {
		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("src\\test\\resources\\screenshot\\" + name + ".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {

		}
	}

	public static void entireBrowserClose() {
		driver.quit();
	}
	
	public static void dateAndTime() {
		Date d= new Date();
		System.out.println(d);
	}
	
	
	public static String fetchTitle() {
		
		String title = driver.getTitle();
		
		return title;
	}
	
	public static String getAttributeValue(WebElement element,String name) {
		String attribute = element.getAttribute(name);
		return attribute;
	}

}
