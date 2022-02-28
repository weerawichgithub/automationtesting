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
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myAccountLogin {
	WebDriver driver;
	WebDriverWait wait;
	ConfigFileReader config = new ConfigFileReader("src/test/java/automationtesting/login.properties");
	
	private String url = config.getProperties("url");
	private String myaccountbtn = config.getProperties("myaccountbtn");
	private String email = config.getProperties("email");
	private String fillemail1 = config.getProperties("fillemail1");
	private String fillemail2 = config.getProperties("fillemail2");
	private String password = config.getProperties("password");
	private String fillpassword = config.getProperties("fillpassword");
	private String loginbtn = config.getProperties("loginbtn");
	private String loginmsg = config.getProperties("loginmsg");
	private String loginFailedMsg = config.getProperties("loginfailedmsg");
	private String fillIncorrectEmail = config.getProperties("fillIncorrectEmail");
	private String fillIncorrectPassword = config.getProperties("fillIncorrectPassword");
	private String fillEmptyEmail = config.getProperties("fillemptyemail");
	private String fillEmptyPassword = config.getProperties("fillemptypassword");
	private String fillUppercaseEmail = config.getProperties("filluppercaseemail");
	private String fillUppercasePassword = config.getProperties("filluppercasepassword");
	private String signout = config.getProperties("signout");
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

		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 1. Log-in with valid username and password.");
		System.out.println("Expected Result\t: User must successfully login to the web page.");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(email)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "Hello " + fillemail1 + " (not "+ fillemail1 + "? Sign out)";
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t: - Webpage should be displayed " + expectedMsg + " after user logged in. ");
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 1\t: PASSED");
		}else {
			System.out.println("Test case 1\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		My Account - Login Test case
//		Test case		: 1. Log-in with valid username and password.
//		Expected Result	: User must successfully login to the web page.
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						: - Webpage should be displayed Hello iambot (not iambot? Sign out) after user logged in.
//						:   Hello iambot (not iambot? Sign out)
//		Test case 1		: PASSED

	}
	
	@Test
	public void testCase2() {

		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 2. Log-in with incorrect username and incorrect password.");
		System.out.println("Expected Result\t: Proper error must be displayed(ie Invalid username) and prompt to enter login again.");

		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(email)).sendKeys(fillIncorrectEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillIncorrectPassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "ERROR: Invalid username. Lost your password?";
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + fillIncorrectEmail);
		System.out.println("\t\t:   Password - " + fillIncorrectPassword);
		System.out.println("\t\t: - Webpage should be displayed " + expectedMsg);
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 2\t: PASSED");
		}else {
			System.out.println("Test case 2\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		My Account - Login Test case
//		Test case		: 2. Log-in with incorrect username and incorrect password.
//		Expected Result	: Proper error must be displayed(ie Invalid username) and prompt to enter login again.
//		Result			:   Username - incorrectuser
//						:   Password - password
//						: - Webpage should be displayed ERROR: Invalid username. Lost your password?
//						:   ERROR: Invalid username. Lost your password?
//		Test case 2		: PASSED
		
	}
	
	@Test
	public void testCase3() {
		
		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 3. Log-in with correct username and empty password.");
		System.out.println("Expected Result\t: Proper error must be displayed(ie Invalid username) and prompt to enter login again.");

		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(email)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillEmptyPassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "Error: Password is required.";
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillEmptyPassword);
		System.out.println("\t\t: - Webpage should be displayed " + expectedMsg);
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 3\t: PASSED");
		}else {
			System.out.println("Test case 3\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account - Login Test case
//		Test case		: 3. Log-in with correct username and empty password.
//		Expected Result	: Proper error must be displayed(ie Invalid username) and prompt to enter login again.
//						:   Username - iambot@gmail.com
//						:   Password - 
//						: - Webpage should be displayed Error: Password is required.
//		Result			:   Error: Password is required.
//		Test case 3		: PASSED
		
	}
	
	@Test
	public void testCase4() {
		
		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 4. Log-in with empty username and valid password.");
		System.out.println("Expected Result\t: Proper error must be displayed(ie Invalid username) and prompt to enter login again.");

		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(email)).sendKeys(fillEmptyEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "Error: Username is required.";
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + fillEmptyEmail);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t: - Webpage should be displayed " + expectedMsg);
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 4\t: PASSED");
		}else {
			System.out.println("Test case 4\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed		
//		My Account - Login Test case
//		Test case		: 4. Log-in with empty username and valid password.
//		Expected Result	: Proper error must be displayed(ie Invalid username) and prompt to enter login again.
//						:   Username - 
//						:   Password - IamNotBot!12
//						: - Webpage should be displayed Error: Username is required.
//		Result			:   Error: Username is required.
//		Test case 4		: PASSED
	}
	
	@Test
	public void testCase5() {
		
		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 5. Log-in with empty username and empty password.");
		System.out.println("Expected Result\t: Proper error must be displayed(ie Invalid username) and prompt to enter login again.");

		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(email)).sendKeys(fillEmptyEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillEmptyPassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "Error: Username is required.";
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + fillEmptyEmail);
		System.out.println("\t\t:   Password - " + fillEmptyPassword);
		System.out.println("\t\t: - Webpage should be displayed " + expectedMsg);
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 5\t: PASSED");
		}else {
			System.out.println("Test case 5\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account - Login Test case
//		Test case		: 5. Log-in with empty username and empty password.
//		Expected Result	: Proper error must be displayed(ie Invalid username) and prompt to enter login again.
//						:   Username - 
//						:   Password - 
//						: - Webpage should be displayed Error: Username is required.
//		Result			:   Error: Username is required.
//		Test case 5		: PASSED
		
	}
	
	@Test
	public void testCase6() {
		
		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 6. Log-in -Password should be masked.");
		System.out.println("Expected Result\t: The password field should display the characters in asterisks or ");
		System.out.println("\t\t: bullets such that the password is not visible on the screen");

		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);

		WebElement passwordInput = driver.findElement(By.xpath(password));
		Assert.assertTrue(passwordInput.isEnabled());
		String passwordType = passwordInput.getAttribute("type");

		System.out.println("Result\t\t:   Username - " + fillEmptyEmail);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t: - The <input type=\"password\"> defines a password field (characters are masked). ");
		System.out.println("\t\t:   Password's input type is " + passwordType );
		if(passwordInput.getAttribute("type").equals("password")) {
			System.out.println("Test case 6\t: PASSED");
		}else {
			System.out.println("Test case 6\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account - Login Test case
//		Test case		: 6. Log-in -Password should be masked.
//		Expected Result	: The password field should display the characters in asterisks or 
//						: bullets such that the password is not visible on the screen
//						:   Username - 
//						:   Password - IamNotBot!12
//						: - The <input type="password"> defines a password field (characters are masked). 
//		Result			:   Password input type is password
//		Test case 6		: PASSED
		
	}
	
	@Test
	public void testCase7() {
		
		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 7. Login-Handles case sensitive");
		System.out.println("Expected Result\t: Login must fail saying incorrect username/password.");

		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		
		System.out.println("\t\t: - Enter the case changed username and pasword in textbox");
		driver.findElement(By.xpath(email)).sendKeys(fillUppercaseEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillUppercasePassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginFailedMsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "ERROR: The password you entered for the username " + fillUppercaseEmail + " is incorrect. Lost your password?";
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + fillUppercaseEmail);
		System.out.println("\t\t:   Password - " + fillUppercasePassword);
		
		System.out.println("\t\t: - Login must fail saying incorrect username/password.");
		System.out.println("\t\t:   " + actualMsg);
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("Test case 7\t: PASSED");
		}else {
			System.out.println("Test case 7\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account - Login Test case
//		Test case		: 7. Login-Handles case sensitive
//		Expected Result	: Login must fail saying incorrect username/password.
//						: - Enter the case changed username and pasword in textbox
//		Result			:   Username - IAMBOT
//						:   Password - IAMNOTBOT!12
//						: - Login must fail saying incorrect username/password.
//						   ERROR: The password you entered for the username IAMBOT is incorrect. Lost your password?
//		Test case 7		 PASSED
		
	}
	
	@Test
	public void testCase8() {
		
		System.out.println("\nMy Account - Login Test case");
		System.out.println("Test case\t: 8. Login-Authentication");
		System.out.println("Expected Result\t: Once your are logged in, sign out of the site ");
		System.out.println("\t\t: Now press back button");
		System.out.println("\t\t: User shouldn’t be signed in to his account rather a general webpage must be visible.");

		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		
		System.out.println("\t\t: - Enter the case changed username in username textbox");
		driver.findElement(By.xpath(email)).sendKeys(fillUppercaseEmail);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		String expectedMsg = "Hello " + fillemail1 + " (not "+ fillemail1 + "? Sign out)";
		String actualMsg   = loginResult.getText();
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   ");
		if(expectedMsg.equalsIgnoreCase(actualMsg)) {
			System.out.println("\t\t:   User already logged in.");
		}else {
			System.out.println("\t\t:   User failed to log in.");
		}
		
		System.out.println("\t\t: - Once your are logged in, sign out of the site");
		driver.findElement(By.xpath(signout)).click();
		System.out.println("\t\t:   User already logged out");
		driver.navigate().back();
		System.out.println("\t\t: - Press back button, User shouldn’t be signed in to his account.");

		WebElement loginPage = driver.findElement(By.xpath(afterlogout));
		Assert.assertTrue(loginPage.isDisplayed());
		System.out.println("\t\t:   " + loginPage.getText()+ " page is displayed");
		if(loginPage.isDisplayed()) {
			System.out.println("Test case 8\t: PASSED");
		}else {
			System.out.println("Test case 8\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account - Login Test case
//		Test case		 8. Login-Authentication
//		Expected Result	: Once your are logged in, sign out of the site 
//						: Now press back button
//						: User shouldn’t be signed in to his account rather a general webpage must be visible.
//						: - Enter the case changed username in username textbox
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						:   
//						:   User already logged in.
//						: - Once your are logged in, sign out of the site
//						:   User already logged out
//						: - Press back button, User shouldn’t be signed in to his account.
//						:   Login page is displayed
//		Test case 8		: PASSED
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
