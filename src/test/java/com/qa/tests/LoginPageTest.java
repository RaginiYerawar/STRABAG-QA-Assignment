package com.qa.tests;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.utils.ExtentReportListener;
import com.qa.utils.JSONUtils;

@Listeners(ExtentReportListener.class)
public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	JSONObject testData;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, ParseException {
		initialization();
		loginPage = new LoginPage();
		testData = JSONUtils.parseJSONFile("src/main/java/com/qa/testData/testData.json");
	}

	// Verify if user sees “Login successful” message when valid credentials entered
	@Test
	public void verifySuccessMessage() {
		String actualSuccessMessage = loginPage.getSuccessMessage(prop.getProperty("username"),
				prop.getProperty("password"));
		String expectedSuccessMessage = (String) testData.get("expectedSuccessMessage");
		Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message is not as expected");
		
	}

	// Verify if user sees error message when invalid credentials entered
	@Test
	public void verifyErrorMessage() {
		String actualErrorMessage = loginPage.getErrorMessage("incorrectUsername", "incorrectPassword");
		String expectedErrorMessage = (String) testData.get("expectedErrorMessage");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is not as expected");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}