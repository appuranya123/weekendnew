package org.demo;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.util.HelperClass;

public class Execusion extends HelperClass {
	
	
	@Parameters({"valdusername","validpassword"})
	@Test()
	private void test1(@Optional("dummy") String username,@Optional("dummy") String password) {
		edgeBrowser();
		passUrl("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
	//	driver.findElement(By.name("login")).click();

	}

	
}
