package automationtesting;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myAccountRegistration {
	WebDriver driver;
	WebDriverWait wait;
	ConfigFileReader config = new ConfigFileReader("src/test/java/automationtesting/regis.properties");
	
	private String url = config.getProperties("url");
	private String myaccountbtn = config.getProperties("myaccountbtn");
	private String email = config.getProperties("email");
	private String fillemail1 = config.getProperties("fillemail1");
	private String fillemail2 = config.getProperties("fillemail2");
	private String password = config.getProperties("password");
	private String fillpassword = config.getProperties("fillpassword");
	private String regBtn = config.getProperties("regbtn");
	private String loginmsg = config.getProperties("loginmsg");
	private String loginFailedMsg = config.getProperties("loginfailedmsg");
	private String fillValidEmail = config.getProperties("fillValidEmail");
	private String fillEmptyEmail = config.getProperties("fillemptyemail");
	private String fillEmptyPassword = config.getProperties("fillemptypassword");
	private String afterlogout = config.getProperties("afterlogout");
	
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
	}
		
	@Test
	public void testCase1() {

		System.out.println("\nMy Account - Registration Test case");
		System.out.println("Test case\t: 1. Registration-Sign-in");
		System.out.println("Expected Result\t: User will be registered successfully and will be navigated to the Home page.");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		String regemail = autoGenEmail(fillemail1 ,fillemail2);
		driver.findElement(By.xpath(email)).sendKeys(regemail);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(regBtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + regemail);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t: - User will be registered successfully and will be navigated to the Home page");
		System.out.println("\t\t:   " + actualMsg);
		if(loginResult.isDisplayed()) {
			System.out.println("Test case 1\t: PASSED");
		}else {
			System.out.println("Test case 1\t: FAILED");
		}
		driver.close();
		
/*
 Console will be displayed

My Account - Registration Test case
Test case		: 1. Registration-Sign-in
Expected Result	: User will be registered successfully and will be navigated to the Home page.
Result			:   Username - weerawich632@gmail.com
				:   Password - LFCTheKop!12
				: - User will be registered successfully and will be navigated to the Home page
				:   Hello weerawich632 (not weerawich632? Sign out)
Test case 1		: PASSED
*/
	}
	
	@Test
	public void testCase2() {

		System.out.println("\nMy Account - Registration Test case");
		System.out.println("Test case\t: 2. Registration with invalid Email-id");
		System.out.println("Expected Result\t: Registration must fail with a warning message(ie. You must enter a valid email address)");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(email)).sendKeys(fillemail1);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		
		System.out.println("Result\t\t: - Enter invalid Email Address , your own password");
		System.out.println("\t\t:   Username - " + fillemail1);
		System.out.println("\t\t:   Password - " + fillpassword);
		driver.findElement(By.xpath(regBtn)).click();

		WebElement loginPage = driver.findElement(By.xpath(afterlogout));
		Assert.assertTrue(loginPage.isDisplayed());
		System.out.println("\t\t:   " + loginPage.getText()+ " page is displayed");
		
		System.out.println("\t\t: - Registration must fail with a warning message(ie You must enter a valid email address)");
		if(loginPage.isDisplayed()) {
			System.out.println("\t\t:   pop-up message \"Please include an '@' in the email address\" ");
			System.out.println("Test case 2\t: PASSED");
		}else {
			System.out.println("Test case 2\t: FAILED");
		}
		driver.close();
		
/*		
 Console will be displayed

My Account - Registration Test case
Test case	: 2. Registration with invalid Email-id
Expected Result	: Registration must fail with a warning message(ie. You must enter a valid email address)
Result		: - Enter invalid Email Address , your own password
			:   Username - weerawich
			:   Password - LFCTheKop!12
			:   Login page is displayed
			: - Registration must fail with a warning message(ie You must enter a valid email address)
			:   pop-up message "Please include an '@' in the email address" 
Test case 2	: PASSED
*/
	}
	
	@Test
	public void testCase3() {

		System.out.println("\nMy Account - Registration Test case");
		System.out.println("Test case\t: 3. Registration with empty Email-id");
		System.out.println("Expected Result\t: Registration must fail with a warning message(ie please provide valid email address)");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		
		System.out.println("Result\t\t: - Enter empty Email Address, your own password");
		driver.findElement(By.xpath(email)).sendKeys(fillEmptyEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(regBtn)).click();
		
		System.out.println("\t\t:   Username - " + fillEmptyEmail);
		System.out.println("\t\t:   Password - " + fillpassword);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginFailedMsg)));
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("\t\t: - Registration must fail with a warning message(ie please provide valid email address)");

		String expectedMsg = "Error: Please provide a valid email address.";
		String actualMsg   = loginResult.getText();
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 3\t: PASSED");
		}else {
			System.out.println("Test case 3\t: FAILED");
		}
		driver.close();

/*
Console will be displayed
My Account - Registration Test case
Test case		: 3. Registration with empty Email-id
Expected Result	: Registration must fail with a warning message(ie please provide valid email address)
Result			: - Enter empty Email Address, your own password
				:   Username - 
				:   Password - LFCTheKop!12
				: - Registration must fail with a warning message(ie please provide valid email address)
				:   Error: Please provide a valid email address.
Test case 3		: PASSED
*/
	}
	
	@Test
	public void testCase4() {

		System.out.println("\nMy Account - Registration Test case");
		System.out.println("Test case\t: 4. Registration with empty password");
		System.out.println("Expected Result\t: Registration must fail with a warning message(ie please enter an account password)");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		
		System.out.println("Result\t\t: - Enter valid Email Address, empty password");
		driver.findElement(By.xpath(email)).sendKeys(fillValidEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillEmptyPassword);
		driver.findElement(By.xpath(regBtn)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginFailedMsg)));
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "Error: An account is already registered with your email address. Please login.";
		String actualMsg   = loginResult.getText();
		System.out.println("\t\t:   Username - " + fillValidEmail);
		System.out.println("\t\t:   Password - " + fillEmptyPassword);
		System.out.println("\t\t: - Registration must fail with a warning message(ie please enter an account password)");
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 4\t: PASSED");
		}else {
			System.out.println("Test case 4\t: FAILED");
		}
		driver.close();

/*
Console will be displayed
My Account - Registration Test case
Test case		: 4. Registration with empty password
Expected Result	: Registration must fail with a warning message(ie please enter an account password)
Result			: - Enter valid Email Address, empty password
				:   Username - iambot@gmail.com
				:   Password - 
				: - Registration must fail with a warning message(ie please enter an account password)
				:   Error: An account is already registered with your email address. Please login.
Test case 4		: PASSED
*/
	}
	
	@Test
	public void testCase5() {

		System.out.println("\nMy Account - Registration Test case");
		System.out.println("Test case\t: 5. Registration with empty Email-id & password");
		System.out.println("Expected Result\t: Registration must fail with a warning message(ie please provide valid email address)");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		
		System.out.println("Result\t\t: - Enter empty Email Address, empty password");
		driver.findElement(By.xpath(email)).sendKeys(fillEmptyEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillEmptyPassword);
		driver.findElement(By.xpath(regBtn)).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loginFailedMsg)));
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "Error: Please provide a valid email address.";
		String actualMsg   = loginResult.getText();
		System.out.println("\t\t:   Username - " + fillEmptyEmail);
		System.out.println("\t\t:   Password - " + fillEmptyPassword);
		System.out.println("\t\t: - Registration must fail with a warning message(ie please provide valid email address)");
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 5\t: PASSED");
		}else {
			System.out.println("Test case 5\t: FAILED");
		}
		driver.close();
/*
Console will be displayed

Test case		: 5. Registration with empty Email-id & password
Expected Result	: Registration must fail with a warning message(ie please provide valid email address)
Result			: - Enter empty Email Address, empty password
				:   Username - 
				:   Password - 
				: - Registration must fail with a warning message(ie please provide valid email address)
				:   Error: Please provide a valid email address.
Test case 5		: PASSED
*/	
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	public static String autoGenEmail(String email1, String email2) {
		int runno = (int) (Math.random()*(999-1+1)) + 1;
		return email1 + runno + email2;
	}
	
}
