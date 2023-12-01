package com.orangehrm.genric;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.elementrepo.Login_repo;

public class Base_class implements Framework_Constants{

	public WebDriver driver;
	public WebDriverWait wait;
	public Login_repo login;
	@BeforeClass
	public void openApp() {
		System.setProperty(GECKO_KEY,GECKO_VALUE );
		driver=new ChromeDriver();
		driver.get(URL);
		wait=new WebDriverWait(driver, TIME_OUT);
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException {
		String user = GenericGetDataFromProperty.getData("username");
		String pass = GenericGetDataFromProperty.getData("password");
		login=new Login_repo(driver);
		Thread.sleep(2000);
		login.getUser_name().sendKeys(user);
		login.getpass_word().sendKeys(pass);
		login.getLogin_button().click();
	}
	
	@AfterMethod
	public void logout() {
		login.getlogout_drop().click();
		login.getlogout_btn().click();
	}
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
}
