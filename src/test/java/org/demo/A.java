package org.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.util.HelperClass;

public class A  extends HelperClass {
	
	
	@Test(priority = 2,enabled = false)
	public void test1() {
		driver.findElement(By.name("login")).click();
	}
	
	
	@Test(priority=-1)
	public void test2() {
		passUrl("https://www.facebook.com/");
	}
	
	
	@Test(priority=-3)
	public void test3() {
		edgeBrowser();
	}
	
	
	@Test
	public void test4() {
		Assert.assertTrue(false);
		driver.findElement(By.name("email")).sendKeys("demo");
		driver.findElement(By.id("pass")).sendKeys("123");
	}

}
