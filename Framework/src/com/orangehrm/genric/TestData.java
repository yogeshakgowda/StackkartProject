package com.orangehrm.genric;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name = "endtoend")
	public Object[][] getData() {
		
		Object [][]arr= {{"C:\\Users\\HP\\Downloads\\motorola-razr-40-ultra-256-gb-infinite-black-8-gb-ram-.jpg","firstname",
			       "middlename","lastname"}};
		return arr;
	}
}
