package org.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSample {
	
	@DataProvider(name="res")
	@Test
	private Object[][] data() {
		Object obj[][]=new Object[][]{{"bala@gmail.com","bala@123"},{"balag123","bala@123"}};
		return obj;
	}

}
