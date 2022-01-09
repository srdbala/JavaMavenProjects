package org.test;

import org.BaseClasses.WebDriverGlobal;
import org.pageFactory.BookHotelPage;
import org.pageFactory.BookingConfirmPage;
import org.pageFactory.LoginPage;
import org.pageFactory.SearchHotelPage;
import org.pageFactory.SelectHotelPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AdactinUsingTestingXML extends WebDriverGlobal {

	@Parameters({ "browser", "url" })
	@Test(priority=1)
	private void testLaunch(String browser, String url) {
		launchBrowser(browser);
		loadUrl(url);
	}

	@Parameters({ "username", "password" })
	@Test(priority=2)
	private void testLoginPage(String username, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.Login(username, password);
	}

	@Parameters({ "location", "hotel", "roomType", "numOfRooms", "datePickIn", "datePickOut", "adults", "child" })
	@Test(priority=3)
	private void testSearchHotelPage(String location, String hotel, String roomType, String numOfRooms,
			String datePickIn, String datePickOut, String adults, String child) {
		SearchHotelPage searchHotelPage = new SearchHotelPage();
		searchHotelPage.searchHotel(location, hotel, roomType, numOfRooms, datePickIn, datePickOut, adults, child);

	}

	@Test(priority=4)
	private void testSelectHotelPage() {
		SelectHotelPage selectHotelPage = new SelectHotelPage();
		selectHotelPage.selectHotel();
	}

	@Parameters({ "firstname", "lastname", "address", "cardNum", "cardType", "expMonth", "expYear", "cvv" })
	@Test(priority=5)
	private void testBookHotelPage(String firstname, String lastname, String address, String cardNum, String cardType,
			String expMonth, String expYear, String cvv) {
		BookHotelPage bookHotelPage = new BookHotelPage();
		bookHotelPage.bookHotel(firstname, lastname, address, cardNum, cardType, expMonth, expYear, cvv);
	}
	
	@Test(priority=6)
	private void testBookingConfirmPage() {
		BookingConfirmPage bookingConfirmPage=new BookingConfirmPage();
		bookingConfirmPage.bookingConfirm();
	}

}
