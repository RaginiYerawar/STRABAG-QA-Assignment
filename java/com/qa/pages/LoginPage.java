package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	WebDriverWait wait;

	// Page Factory - OR:
	@FindBy(id = "login-field")
	WebElement username;

	@FindBy(id = "password-field")
	WebElement password;

	@FindBy(id = "login-form-submit")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id='system-holder']/h1")
	WebElement successMessage;

	@FindBy(id = "login-error-msg")
	WebElement errorMessage;

	// initialization:
	public LoginPage() {
		PageFactory.initElements(driver, this);
		// Define an explicit wait
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// actions:

	// login
	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}

	// Login and get actual success message
	public String getSuccessMessage(String un, String pwd) {
		login(un, pwd);

		// Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		String actualMessage = successMessage.getText();
		return actualMessage;
	}

	// Login and get actual error message
	public String getErrorMessage(String un, String pwd) {
		login(un, pwd);

		// Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String actualMessage = errorMessage.getText();
		return actualMessage;
	}

}
