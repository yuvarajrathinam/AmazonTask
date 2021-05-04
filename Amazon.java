package com.task;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	
	static WebDriver driver;
	
	
	@BeforeClass
	private void driver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
	
}
	@Test
	public void lunchbroswer() {
			
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
}
	@Test
	public void doProductSearch() {
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sony Tv",Keys.ENTER);
		
		 driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")).click();
		 
	}
	@Test
	public void addToCart() {
	driver.findElement(By.xpath("//a[@title='Add to Shopping Cart']")).click();

	}
	@Test
	public void selectAdressAndPaymentOption() {
		driver.findElement(By.xpath("//input[@name='proceedToRetailCheckout']")).click();
		
		//Select Adress
		driver.findElement(By.xpath("(//a[@class='a-declarative a-button-text '])[1]")).click();
		//select payment option
		driver.findElement(By.xpath("(//input[@class='a-button-text'])[1]")).click();
		
		
	}
	@Test
	public void removeTheCart() {
		// Remove the product from the cart
		driver.navigate().to("(//a[@class='a-declarative a-button-text '])[1]");
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]")).click();

	}
	@AfterClass
	public void endSession() {
		driver.quit();
	}
}