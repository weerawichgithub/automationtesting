package automationtesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class myAccount {
	WebDriver driver;
	WebDriverWait wait;
	ConfigFileReader config = new ConfigFileReader("src/test/java/automationtesting/myaccount.properties");
	
	private String url = config.getProperties("url");
	private String myaccountbtn = config.getProperties("myaccountbtn");
	private String emailusername = config.getProperties("emailusername");
	private String fillemail1 = config.getProperties("fillemail1");
	private String fillemail2 = config.getProperties("fillemail2");
	private String password = config.getProperties("password");
	private String fillpassword = config.getProperties("fillpassword");
	private String loginbtn = config.getProperties("loginbtn");
	private String loginmsg = config.getProperties("loginmsg");
	private String myaccountlink = config.getProperties("myaccountlink");
	private String orderslink = config.getProperties("orderslink");
	private String orderlist = config.getProperties("orderlist");
	private String orderstatus = config.getProperties("orderstatus");
	private String orderdetail = config.getProperties("orderdetail");
	private String orderdetailheader = config.getProperties("orderdetailheader");
	private String customerdetail = config.getProperties("customerdetail");
	private String billingaddress = config.getProperties("billingaddress");
	private String addresseslink = config.getProperties("addresseslink");
	private String viewbutton = config.getProperties("viewbutton");
	private String shippingedit = config.getProperties("shippingedit");
	private String billing = config.getProperties("billing");
	private String shipping = config.getProperties("shipping");
	private String firstname = config.getProperties("firstname");
	private String fillFirstname = config.getProperties("fill_firstname");
	private String lastname = config.getProperties("lastname");
	private String fillLastname = config.getProperties("fill_lastname");
	private String company = config.getProperties("company");
	private String fillCompany = config.getProperties("fill_company");
	private String country = config.getProperties("country");
	private String countrysearch = config.getProperties("countrysearch");
	private String fillCountry = config.getProperties("fill_country");
	private String address1 = config.getProperties("address1");
	private String fillAddress1 = config.getProperties("fill_address1");
	private String address2 = config.getProperties("address2");
	private String fillAddress2 = config.getProperties("fill_address2");
	private String city = config.getProperties("city");
	private String fillCity = config.getProperties("fill_city");
	private String state = config.getProperties("state");
	private String statesearch = config.getProperties("statesearch");
	private String fillState = config.getProperties("fill_state");
	private String postalcode = config.getProperties("postalcode");
	private String fillPostalcode = config.getProperties("fill_postalcode");
	private String saveaddressbtn = config.getProperties("saveaddressbtn");
	private String savemsg = config.getProperties("savemsg");
	private String accountdetailslink = config.getProperties("accountdetailslink");
	private String accountfirstname = config.getProperties("accountfirstname");
	private String accountlastname = config.getProperties("accountlastname");
	private String accountsavebtn = config.getProperties("accountsavebtn");
	private String accountmsg = config.getProperties("accountmsg");
	private String logoutlink = config.getProperties("logoutlink");
	private String loginpage = config.getProperties("loginpage");

	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
	}
		
	@Test
	public void testCase1() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 1. My Accounts-Dashboard");
		System.out.println("Expected Result\t: User must view Dashboard of the site");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());

		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		driver.findElement(By.xpath(myaccountlink)).click();
		
		List<WebElement> dashboardList = driver.findElements(By.xpath("//li[contains(@class,'navigation-link')]"));
		System.out.println("\t\t: - Dashboard of the site");
		for(WebElement dashboardLink : dashboardList) {
			System.out.println("\t\t:  o " + dashboardLink.getText());
		}
		
		if(dashboardList.size() > 0) {
			System.out.println("Test case 1\t: PASSED");
		}else {
			System.out.println("Test case 1\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account
//		Test case		: 1. My Accounts-Dashboard
//		Expected Result	: User must view Dashboard of the site
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						: - Webpage should be displayed Hello iambot (not iambot? Sign out) after user logged in. 
//						:  Hello iambot (not iambot? Sign out)
//						: - Dashboard of the site
//						:  o Dashboard
//						:  o Orders
//						:  o Downloads
//						:  o Addresses
//						:  o Account Details
//						:  o Logout
//		Test case 1		: PASSED
		
	}
	
	@Test
	public void testCase2() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 2. My Accounts-Orders");
		System.out.println("Expected Result\t: User must view their orders on clicking orders link");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		
		driver.findElement(By.xpath(myaccountlink)).click();
		driver.findElement(By.xpath(orderslink)).click();
		System.out.println("\t\t: - Click on Orders link, user can view their orders.  ");
		
		List<WebElement> orderList = driver.findElements(By.xpath(orderlist));
		for(WebElement order : orderList) {
			System.out.println("\t\t: " + order.getText() );
		}
		if(orderList.size()>0) {
			System.out.println("Test case 2\t: PASSED");
		}else {
			System.out.println("Test case 2\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account
//		Test case		: 2. My Accounts-Orders
//		Expected Result	: User must view their orders on clicking orders link
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						:   Hello iambot (not iambot? Sign out)
//						: - Click on Orders link, user can view their orders.  
//						: #8684 February 26, 2022 On Hold ₹525.00 for 2 items VIEW
//						: #8683 February 26, 2022 On Hold ₹472.50 for 1 item VIEW
//						: #8681 February 26, 2022 On Hold ₹1,050.00 for 4 items VIEW
//		Test case 2		: PASSED
		
	}
	
	@Test
	public void testCase3() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 3. My Accounts-Orders");
		System.out.println("Expected Result\t: User must view their orders on clicking orders link");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		
		driver.findElement(By.xpath(myaccountlink)).click();
		driver.findElement(By.xpath(orderslink)).click();
		System.out.println("\t\t: - Click on View button, user can view order details");
		driver.findElement(By.xpath(viewbutton)).click();
		System.out.println("\t\t: Order Details");
		System.out.println(driver.findElement(By.xpath(orderdetail)).getText());
		
		System.out.println("\t\t: Customer Details");
		System.out.println(driver.findElement(By.xpath(customerdetail)).getText());
		
		System.out.println("\t\t: Billing Address");
		System.out.println(driver.findElement(By.xpath(billingaddress)).getText());
		
		WebElement orderDetailHeader = driver.findElement(By.xpath(orderdetailheader));
		Assert.assertTrue(orderDetailHeader.isDisplayed());
		if(orderDetailHeader.isDisplayed()) {
			System.out.println("Test case 3\t: PASSED");
		}else {
			System.out.println("Test case 3\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		My Account
//		Test case		: 3. My Accounts-Orders
//		Expected Result	: User must view their orders on clicking orders link
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						:   Hello iambot (not iambot? Sign out)
//						: - Click on View button, user can view order details
//						: Order Details
//		Product Total
//		Functional Programming in JS × 2 ₹500.00
//		Mastering JavaScript × 1 ₹350.00
//		JS Data Structures and Algorithm × 1 ₹150.00
//		Subtotal: ₹1,000.00
//		Roaming Tax: ₹50.00
//		Payment Method: Cash on Delivery
//		Total: ₹1,050.00
//				: Customer Details
//		Email: weerawich@gmail.com
//		Telephone: 7034889829
//				: Billing Address
//		Weerawich P
//		13971 Metrotech dr
//		Centreville, VA 20151
//		United States (US)
//		Test case 3	: PASSED
		
	}
	
	@Test
	public void testCase4() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 4. My Accounts-Orders");
		System.out.println("Expected Result\t: User must view Order Number Ordered date ");
		System.out.println("\t\t: and Status of the order on clicking view button");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		
		driver.findElement(By.xpath(myaccountlink)).click();
		driver.findElement(By.xpath(orderslink)).click();
		System.out.println("\t\t: - Click on View button, user can view order details");
		driver.findElement(By.xpath(viewbutton)).click();
		
		System.out.println("\t\t: Order Status");
		System.out.println("\t\t: " + driver.findElement(By.xpath(orderstatus)).getText());

		WebElement orderDetailHeader = driver.findElement(By.xpath(orderdetailheader));
		Assert.assertTrue(orderDetailHeader.isDisplayed());
		if(orderDetailHeader.isDisplayed()) {
			System.out.println("Test case 4\t: PASSED");
		}else {
			System.out.println("Test case 4\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		My Account
//		Test case		: 4. My Accounts-Orders
//		Expected Result	: User must view Order Number Ordered date 
//						: and Status of the order on clicking view button
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						:   Hello iambot (not iambot? Sign out)
//						: - Click on View button, user can view order details
//						: Order Status
//						: Order #8681 was placed on February 26, 2022 and is currently On Hold.
//		Test case 4		: PASSED
		
	}
	@Test
	public void testCase5() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 5. My Accounts-Address Functionality");
		System.out.println("Expected Result\t: User must view billing address and ship address");
		System.out.println("\t\t: and Status of the order on clicking view button");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		
		driver.findElement(By.xpath(myaccountlink)).click();
		driver.findElement(By.xpath(addresseslink)).click();
		System.out.println("\t\t: - Click on Address link, user can view billing address and ship address.");

		
		WebElement billingAddress = driver.findElement(By.xpath(billing));
		Assert.assertTrue(billingAddress.isDisplayed());
		
		System.out.println(billingAddress.getText().replaceAll("Edit", ""));
		System.out.println("\n");
		System.out.println(driver.findElement(By.xpath(shipping)).getText().replaceAll("Edit", ""));
		System.out.println("\n");
		if(billingAddress.isDisplayed()) {
			System.out.println("Test case 5\t: PASSED");
		}else {
			System.out.println("Test case 5\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		My Account
//		Test case		: 5. My Accounts-Address Functionality
//		Expected Result	: User must view billing address and ship address
//						: and Status of the order on clicking view button
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						:   Hello iambot (not iambot? Sign out)
//						: - Click on Address link, user can view billing address and ship address.
//		Billing Address
// 
//		Weerawich P
//		13971 Metrotech dr
//		Centreville, VA 20151
//		United States (US)
//
//
//		Shipping Address
// 
//		You have not set up this type of address yet.
//
//		Test case 5		: PASSED
		

	}
	@Test
	public void testCase6() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 6. My Accounts-Address Functionality");
		System.out.println("Expected Result\t: User can Edit Shipping address");
		System.out.println("\t\t: ");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		
		driver.findElement(By.xpath(myaccountlink)).click();
		driver.findElement(By.xpath(addresseslink)).click();
		System.out.println("\t\t: - Click on Address link, user can view billing address and ship address.");

		WebElement shippingAddress = driver.findElement(By.xpath(shipping));
		Assert.assertTrue(shippingAddress.isDisplayed());
		
		System.out.println(shippingAddress.getText().replaceAll("Edit", ""));
		System.out.println("\t\t:");
		System.out.println("\t\t: - Click edit on Shipping address ");
		driver.findElement(By.xpath(shippingedit)).click();
		System.out.println("\t\t:");
		System.out.println("\t\t: - User edit Shipping address.");
		driver.findElement(By.xpath(firstname)).clear();
		driver.findElement(By.xpath(firstname)).sendKeys(fillFirstname);
		driver.findElement(By.xpath(lastname)).clear();
		driver.findElement(By.xpath(lastname)).sendKeys(fillLastname);
		driver.findElement(By.xpath(company)).clear();
		driver.findElement(By.xpath(company)).sendKeys(fillCompany);
		driver.findElement(By.xpath(country)).click();
		driver.findElement(By.xpath(countrysearch)).sendKeys(fillCountry, Keys.ENTER);
		driver.findElement(By.xpath(address1)).clear();
		driver.findElement(By.xpath(address1)).sendKeys(fillAddress1);
		driver.findElement(By.xpath(address2)).clear();
		driver.findElement(By.xpath(address2)).sendKeys(fillAddress2);
		driver.findElement(By.xpath(city)).clear();
		driver.findElement(By.xpath(city)).sendKeys(fillCity);
		driver.findElement(By.xpath(state)).click();
		driver.findElement(By.xpath(statesearch)).sendKeys(fillState, Keys.ENTER);
		driver.findElement(By.xpath(postalcode)).clear();
		driver.findElement(By.xpath(postalcode)).sendKeys(fillPostalcode);
		System.out.println("\t\t:   First name  > " + fillFirstname);
		System.out.println("\t\t:   Last name   > " + fillLastname);
		System.out.println("\t\t:   Company     > " + fillCompany);
		System.out.println("\t\t:   Country     > " + fillCountry);
		System.out.println("\t\t:   Address1    > " + fillAddress1);
		System.out.println("\t\t:   Address2    > " + fillAddress2);
		System.out.println("\t\t:   City        > " + fillCity);
		System.out.println("\t\t:   State       > " + fillState);
		System.out.println("\t\t:   Postal code > " + fillPostalcode);
		
		WebElement saveAddressBtn = driver.findElement(By.xpath(saveaddressbtn));
		Assert.assertTrue(saveAddressBtn.isEnabled());
		
		saveAddressBtn.click();
		
		wait.until(ExpectedConditions.urlToBe("http://practice.automationtesting.in/my-account/"));
		WebElement saveMsg = driver.findElement(By.xpath(savemsg));
		Assert.assertTrue(saveMsg.isDisplayed());
		System.out.println("\t\t: " + saveMsg.getText());

		if(saveMsg.getText().equals("Address changed successfully.")) {
			System.out.println("Test case 6\t: PASSED");
		}else {
			System.out.println("Test case 6\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		My Account
//		Test case		: 6. My Accounts-Address Functionality
//		Expected Result	: User can Edit Shipping address
//						: 
//		Result			:   Username - iambot@gmail.com
//						:   Password - IamNotBot!12
//						:   Hello iambot (not iambot? Sign out)
//						: - Click on Address link, user can view billing address and ship address.
//		Shipping Address
//
//		You have not set up this type of address yet.
//						:
//						: - Click edit on Shipping address 
//						:
//						: - User edit Shipping address.
//						:   First name  > Weerawich
//						:   Last name   > p
//						:   Company     > Supreme
//						:   Country     > United States (US)
//						:   Address1    > 13971 metrotech dr
//						:   Address2    > Supreme
//						:   City        > Chantilly
//						:   State       > Virginia
//						:   Postal code > 20151
//						: Address changed successfully.
//	Test case 6			: PASSED

	}

	@Test
	public void testCase7() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 7. My Accounts-Account Details");
		System.out.println("Expected Result\t: User can view account details where he can change his password.");
		System.out.println("\t\t: ");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		
		driver.findElement(By.xpath(myaccountlink)).click();
		driver.findElement(By.xpath(accountdetailslink)).click();
		System.out.println("\t\t: - Click on Account details link,");
		System.out.println("\t\t:   User can view account details and change password.");

		WebElement accountSaveBtn = driver.findElement(By.xpath(accountsavebtn));
		Assert.assertTrue(accountSaveBtn.isEnabled());
		
		driver.findElement(By.xpath(accountfirstname)).clear();
		driver.findElement(By.xpath(accountfirstname)).sendKeys(fillFirstname);
		driver.findElement(By.xpath(accountlastname)).clear();
		driver.findElement(By.xpath(accountlastname)).sendKeys(fillLastname);
		accountSaveBtn.click();
		
		System.out.println("\t\t:   First name  > " + fillFirstname);
		System.out.println("\t\t:   Last name   > " + fillLastname);
		
		wait.until(ExpectedConditions.urlToBe("http://practice.automationtesting.in/my-account/"));
		WebElement saveMsg = driver.findElement(By.xpath(accountmsg));
		Assert.assertTrue(saveMsg.isDisplayed());
		System.out.println("\t\t: " + saveMsg.getText());

		if(saveMsg.getText().equals("Account details changed successfully.")) {
			System.out.println("Test case 7\t: PASSED");
		}else {
			System.out.println("Test case 7\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		My Account
//		Test case	: 7. My Accounts-Account Details
//		Expected Result	: User can view account details where he can change his password.
//					: 
//		Result		:   Username - iambot@gmail.com
//					:   Password - IamNotBot!12
//					:   Hello iambot (not iambot? Sign out)
//					: - Click on Account details link,
//					:   User can view account details and change password.
//					:   First name  > Weerawich
//					:   Last name   > p
//					: Account details changed successfully.
//		Test case 7	: PASSED

	}
	
	@Test
	public void testCase8() {

		System.out.println("\nMy Account");
		System.out.println("Test case\t: 8. My Accounts-Log-Out");
		System.out.println("Expected Result\t: On clicking logout,User successfully comes out from the site.");
		System.out.println("\t\t: ");
		driver.get(url);
		driver.findElement(By.xpath(myaccountbtn)).click();
		driver.findElement(By.xpath(emailusername)).sendKeys(fillemail1 + fillemail2);
		driver.findElement(By.xpath(password)).sendKeys(fillpassword);
		driver.findElement(By.xpath(loginbtn)).click();
		
		WebElement loginResult = driver.findElement(By.xpath(loginmsg));
		Assert.assertTrue(loginResult.isDisplayed());
		
		System.out.println("Result\t\t:   Username - " + fillemail1 + fillemail2);
		System.out.println("\t\t:   Password - " + fillpassword);
		System.out.println("\t\t:   " + loginResult.getText());
		System.out.println("\t\t: - Click on logout link, User successfully comes out from the site.");
		driver.findElement(By.xpath(logoutlink)).click();
		
		wait.until(ExpectedConditions.urlToBe("http://practice.automationtesting.in/my-account/"));
		WebElement loginPage = driver.findElement(By.xpath(loginpage));
		Assert.assertTrue(loginPage.isDisplayed());
		System.out.println("\t\t:   Webpage navigates back to " + loginPage.getText());

		if(loginPage.getText().equalsIgnoreCase("Login")) {
			System.out.println("Test case 8\t: PASSED");
		}else {
			System.out.println("Test case 8\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		My Account
//		Test case	: 8. My Accounts-Log-Out
//		Expected Result	: On clicking logout,User successfully comes out from the site.
//					: 
//		Result		:   Username - iambot@gmail.com
//					:   Password - IamNotBot!12
//					:   Hello iambot (not iambot? Sign out)
//					: - Click on logout link, User successfully comes out from the site.
//					:   Webpage navigates back to Login
//		Test case 8	: PASSED

	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
