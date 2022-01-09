package org.test;

import org.BaseClasses.WebDriverGlobal;
import org.pageFactory.BookHotelPage;
import org.pageFactory.BookingConfirmPage;
import org.pageFactory.LoginPage;
import org.pageFactory.SearchHotelPage;
import org.pageFactory.SelectHotelPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdactinUsingTestNg extends WebDriverGlobal {

	@BeforeClass
	private void beforeClass() {
		launchBrowser("chrome");
		loadUrl("http://adactinhotelapp.com/");
	}

	@Test(priority = 1)
	private void testLoginPage() {
		LoginPage loginPage=new LoginPage();
		loginPage.Login("balag123", "bala@123");

	}
	
	@Test(priority = 2)
	private void testSearchHotelPage() {
		SearchHotelPage searchHotelPage=new SearchHotelPage();
		searchHotelPage.searchHotel("London", "Hotel Sunshine", "Super Deluxe", "1 - One", "05/01/2022", "07/01/2022", "1 - One", "0 - None");
	}
	
	@Test(priority = 3)
	private void testSelectHotelPage() {
		SelectHotelPage selectHotelPage=new SelectHotelPage();
		selectHotelPage.selectHotel();
	}
	
	@Test(priority = 4)
	private void testBookHotelPage() {
		BookHotelPage bookHotelPage=new BookHotelPage();
		bookHotelPage.bookHotel("bala", "g", "Coimbatore", "9876543210012340", "VISA", "December", "2022", "123");
	}
	
	@Test(priority = 5)
	private void testBookingConfirmPage() throws InterruptedException {
		Thread.sleep(5000);
		BookingConfirmPage bookingConfirmPage=new BookingConfirmPage();
		bookingConfirmPage.bookingConfirm();
		
	}

}
