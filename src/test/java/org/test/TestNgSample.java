package org.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgSample {
	
	WebDriver driver;
	
	@BeforeClass
	private void beforeClass() {		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://adactinhotelapp.com/");
	}
	
	@BeforeMethod
	private void startTime() {
		Date d=new Date();
		System.out.println(d);
	}
	
	@Test
	private void login() {
		WebElement txtUsername = driver.findElement(By.id("username"));
		txtUsername.sendKeys("balag123");
		
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("bala@123");
		
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}
	
	@Test
	private void searchAHotel() {
		
		WebElement ddLocation = driver.findElement(By.id("location"));
		Select sLocation=new Select(ddLocation);
		sLocation.selectByValue("Paris");
		
		WebElement ddHotels = driver.findElement(By.id("hotels"));
		Select sHotels=new Select(ddHotels);
		sHotels.selectByIndex(1);
		
		WebElement ddRoomType = driver.findElement(By.id("room_type"));
		Select sRoomType=new Select(ddRoomType);
		sRoomType.selectByIndex(3);
		
		WebElement ddRooms = driver.findElement(By.id("room_nos"));
		Select sRooms=new Select(ddRooms);
		sRooms.selectByIndex(4);
		
		WebElement txtCheckIn = driver.findElement(By.id("datepick_in"));
		txtCheckIn.sendKeys("25/12/2021");
		
		WebElement txtCheckOut = driver.findElement(By.id("datepick_out"));
		txtCheckOut.sendKeys("27/12/2021");
		
		WebElement ddAdult = driver.findElement(By.id("adult_room"));
		Select sAdult=new Select(ddAdult);
		sAdult.selectByIndex(1);
		
		WebElement ddChild = driver.findElement(By.id("child_room"));
		Select sChild=new Select(ddChild);
		sChild.selectByIndex(1);
		
		WebElement btnSearch = driver.findElement(By.id("Submit"));
		btnSearch.click();

	}
	
	@Test
	private void selectAHotel() {
		WebElement btnRadio = driver.findElement(By.id("radiobutton_0"));
		btnRadio.click();
		
		WebElement btnContinue = driver.findElement(By.id("continue"));
		btnContinue.click();
	}
	
	@Test
	private void bookAHotel() {
		
		WebElement txtFirstName = driver.findElement(By.id("first_name"));
		txtFirstName.sendKeys("bala");
		
		WebElement txtLastname = driver.findElement(By.id("last_name"));
		txtLastname.sendKeys("g");
		
		WebElement txtAddress = driver.findElement(By.id("address"));
		txtAddress.sendKeys("coimbatore");
		
		WebElement txtCreditCard = driver.findElement(By.id("cc_num"));
		txtCreditCard.sendKeys("9876543210012345");
		
		WebElement ddCardType = driver.findElement(By.id("cc_type"));
		Select sCardType=new Select(ddCardType);
		sCardType.selectByIndex(1);
		
		WebElement ddExpMonth = driver.findElement(By.id("cc_exp_month"));
		Select sExpMonth=new Select(ddExpMonth);
		sExpMonth.selectByIndex(11);
		
		WebElement ddExpYear = driver.findElement(By.id("cc_exp_year"));
		Select sExpYear=new Select(ddExpYear);
		sExpYear.selectByIndex(11);
		
		WebElement txtCvv = driver.findElement(By.id("cc_cvv"));
		txtCvv.sendKeys("123");

		WebElement btnBookNow = driver.findElement(By.id("book_now"));
		btnBookNow.click();
	}
	
	@Test
	private void getOrderID() {
		WebElement txtOrderNo = driver.findElement(By.id("order_no"));
		String attribute = txtOrderNo.getAttribute("value");
		System.out.println("Order no : "+attribute);
	}
	
	
	@AfterMethod
	private void endTime() {
		Date d=new Date();
		System.out.println(d);
	}
	
	@AfterClass
	private void afterClass() {
		driver.quit();
	}

}
