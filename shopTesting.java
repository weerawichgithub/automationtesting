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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shopTesting {
	WebDriver driver;
	WebDriverWait wait;
	ConfigFileReader config = new ConfigFileReader("src/test/java/automationtesting/shop.properties");
	
	private String url = config.getProperties("url");
	private String bookname = config.getProperties("bookname");
	private String bookselected = config.getProperties("bookselected");
	private String bookdesc = config.getProperties("bookdescription");
	private String shop = config.getProperties("shop");
	private String slider = config.getProperties("slider");
	private String filter = config.getProperties("filter");
	private String pricerange = config.getProperties("pricerange");
	private String sortingdropdown = config.getProperties("sortingdropdown");
	private String readmore = config.getProperties("readmore");
	private String outofstock = config.getProperties("outofstock");
	private String productname = config.getProperties("productname");
	private String onsale = config.getProperties("onsale");
	private String saleprice = config.getProperties("saleprice");
	private String addtobasket = config.getProperties("addtobasket");
	private String iteminbasket = config.getProperties("iteminbasket");
	private String viewbasket = config.getProperties("viewbasket");
	private String itemsincartinfo = config.getProperties("itemsincartinfo");
	private String itemsincartlink = config.getProperties("itemsincartlink");
	private String subtotal = config.getProperties("subtotal");
	private String total = config.getProperties("total");
	private String tax = config.getProperties("tax");
	private String roamingtax = config.getProperties("roamingtax");
	private String proceedcheckout = config.getProperties("proceedcheckout");
	private String firstname = config.getProperties("firstname");
	private String fillFirstname = config.getProperties("fill_firstname");
	private String lastname = config.getProperties("lastname");
	private String fillLastname = config.getProperties("fill_lastname");
	private String company = config.getProperties("company");
	private String fillCompany = config.getProperties("fill_company");
	private String email = config.getProperties("email");
	private String fillEmail = config.getProperties("fill_email");
	private String phone = config.getProperties("phone");
	private String fillPhone = config.getProperties("fill_phone");
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
	private String paymenttype = config.getProperties("paymenttype");
	private String orderdetail1 = config.getProperties("orderdetail1");
	private String orderdetail2 = config.getProperties("orderdetail2");
	private String orderreview = config.getProperties("orderreview");
	
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
	}
		
	@Test
	public void testCase1() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 1. Shop-Filter By Price Functionality");
		System.out.println("Expected Result\t: User can view books only between 150 to 450 rps price");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();
		
		String priceRange = driver.findElement(By.xpath(pricerange)).getText();
		System.out.println("Result\t\t: Default " + priceRange);
		
		WebElement filterSlider = driver.findElement(By.xpath(slider));
		Actions action = new Actions(driver);
		action.dragAndDropBy(filterSlider, -28, 0).build().perform();

		driver.findElement(By.xpath(filter)).click();

		WebElement priceFilter = driver.findElement(By.xpath(pricerange));
		Assert.assertTrue(priceFilter.getText().contains("450"));
		
		String priceAdj = priceFilter.getText();
		System.out.println("\t\t: - Adjusted " + priceAdj);
		System.out.println("\t\t: - List of books user can view");
		
		List<WebElement> bookList = driver.findElements(By.xpath(bookname));
		for(WebElement bookDetail : bookList) {
			System.out.println("\t\t:\to " + bookDetail.getText());
		}
 
		if(priceAdj.contains("450")) {
			System.out.println("Test case 1\t: PASSED");
		}else {
			System.out.println("Test case 1\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 1. Shop-Filter By Price Functionality
//		Expected Result	: User can view books only between 150 to 450 rps price
//						: Default Price: ₹150 — ₹500
//						: - Adjusted Price: ₹150 — ₹450
//		Result			: - List of books user can view
//						:	o Android Quick Start Guide
//						:	o Functional Programming in JS
//						:	o HTML5 Forms
//						:	o HTML5 WebApp Develpment
//						:	o JS Data Structures and Algorithm
//						:	o Mastering JavaScript
//						:	o Thinking in HTML
//		Test case 1		: PASSED
		
	}

	@Test
	public void testCase2() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 2. Shop-Product Categories Functionality");
		System.out.println("Expected Result\t: Click any of the product links available in the product category,");
		System.out.println("\t\t: so user can view only that particular product");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();
		
		WebElement book = driver.findElement(By.xpath(bookselected));
		
		System.out.println("Result\t\t: - Clicked > " + book.getText());
		System.out.println("\t\t: - Product Description");
		book.click();

		WebElement bookDescription = driver.findElement(By.xpath(bookdesc));
		Assert.assertTrue(bookDescription.isDisplayed());
		System.out.println("\t\t:   " + bookDescription.getText().substring(0, 45) + "...");
		
		if(bookDescription.isDisplayed()) {
			System.out.println("Test case 2\t: PASSED");
		}else {
			System.out.println("Test case 2\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 2. Shop-Product Categories Functionality
//		Expected Result	: Click any of the product links available in the product category,
//						: so user can view only that particular product
//						: - Clicked > HTML5 Forms
//		Result			: - Product Description
//						:   Web viewers may never know about the bac ...
//		Test case 2		: PASSED
		
	}

	@Test
	public void testCase3() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 3. Shop-Default Sorting Functionality - Sort by Popularity item");
		System.out.println("Expected Result\t: Click on Sort by Popularity item.");
		System.out.println("\t\t: User can view the popular products only");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();

		WebElement sorting = driver.findElement(By.xpath(sortingdropdown));
		Select sortingDropdown = new Select(sorting);
		sortingDropdown.selectByValue("popularity");
		
		System.out.println("Result\t\t: - Sorting by popularity");
		
		List<WebElement> bookList = driver.findElements(By.xpath(bookname));
		for(WebElement bookDetail : bookList) {
			System.out.println("\t\t:\to " + bookDetail.getText());
		}
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL, true);
		if(currentURL.contains("popularity")) {
			System.out.println("Test case 3\t: PASSED");
		}else {
			System.out.println("Test case 3\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 3. Shop-Default Sorting Functionality - Sort by Popularity item
//		Expected Result	: User can view the popular products only
//						: User can view the popular products only
//		Result			: - Sorting by popularity
//						:	o Selenium Ruby
//						:	o Thinking in HTML
//						:	o Mastering JavaScript
//						:	o Android Quick Start Guide
//						:	o Functional Programming in JS
//						:	o HTML5 Forms
//						:	o HTML5 WebApp Develpment
//						:	o JS Data Structures and Algorithm
//		Test case 3		: PASSED
		
	}

	@Test
	public void testCase4() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 4. Shop-Default Sorting Functionality - Sort by Average ratings");
		System.out.println("Expected Result\t: Click on Sort by Average ratings.");
		System.out.println("\t\t: User can view the popular products only");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();

		WebElement sorting = driver.findElement(By.xpath(sortingdropdown));
		Select sortingDropdown = new Select(sorting);
		sortingDropdown.selectByValue("rating");
		
		System.out.println("Result\t\t: - Sorting by average rating");
		
		List<WebElement> bookList = driver.findElements(By.xpath(bookname));
		for(WebElement bookDetail : bookList) {
			System.out.println("\t\t:\to " + bookDetail.getText());
		}
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL, true);
		if(currentURL.contains("rating")) {
			System.out.println("Test case 4\t: PASSED");
		}else {
			System.out.println("Test case 4\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 4. Shop-Default Sorting Functionality - Sort by Average ratings
//		Expected Result	: Click on Sort by Average ratings.
//						: User can view the popular products only
//						:
//		Result			: - Sorting by average rating
//						:	o Selenium Ruby
//						:	o HTML5 WebApp Develpment
//						:	o Functional Programming in JS
//						:	o Mastering JavaScript
//						:	o Thinking in HTML
//						:	o Android Quick Start Guide
//						:	o HTML5 Forms
//						:	o JS Data Structures and Algorithm
//		Test case 4		: PASSED
		
	}
	
	@Test
	public void testCase5() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 5. Shop-Default Sorting Functionality - Sort by Newness ratings");
		System.out.println("Expected Result\t: Click on Sort by Newness ratings.");
		System.out.println("\t\t: User can view the popular products only");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();

		WebElement sorting = driver.findElement(By.xpath(sortingdropdown));
		Select sortingDropdown = new Select(sorting);
		sortingDropdown.selectByValue("date");
		
		System.out.println("Result\t\t: - Sorting by average rating");
		
		List<WebElement> bookList = driver.findElements(By.xpath(bookname));
		for(WebElement bookDetail : bookList) {
			System.out.println("\t\t:\to " + bookDetail.getText());
		}
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL, true);
		if(currentURL.contains("date")) {
			System.out.println("Test case 5\t: PASSED");
		}else {
			System.out.println("Test case 5\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 5. Shop-Default Sorting Functionality - Sort by Newness ratings
//		Expected Result	: Click on Sort by Newness ratings.
//						: User can view the popular products only
//						:
//		Result			: - Sorting by average rating
//						:	o HTML5 WebApp Develpment
//						:	o HTML5 Forms
//						:	o JS Data Structures and Algorithm
//						:	o Functional Programming in JS
//						:	o Android Quick Start Guide
//						:	o Mastering JavaScript
//						:	o Thinking in HTML
//						:	o Selenium Ruby
//		Test case 5		: PASSED
		
	}
	
	@Test
	public void testCase6() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 6. Shop-Default Sorting Functionality - Sort by Low to High");
		System.out.println("Expected Result\t: Click on Sort by Low to High.");
		System.out.println("\t\t: User can view the popular products only");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();

		WebElement sorting = driver.findElement(By.xpath(sortingdropdown));
		Select sortingDropdown = new Select(sorting);
		sortingDropdown.selectByValue("price");
		
		System.out.println("Result\t\t: - Sorting by price:low to high");
		
		List<WebElement> bookList = driver.findElements(By.xpath(bookname));
		for(WebElement bookDetail : bookList) {
			System.out.println("\t\t:\to " + bookDetail.getText());
		}
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL, true);
		if(currentURL.contains("price")) {
			System.out.println("Test case 6\t: PASSED");
		}else {
			System.out.println("Test case 6\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 6. Shop-Default Sorting Functionality - Sort by Low to High
//		Expected Result	: Click on Sort by Low to High.
//						: User can view the popular products only
//						:
//		Result			: - Sorting by price:low to high
//						:	o JS Data Structures and Algorithm
//						:	o HTML5 WebApp Develpment
//						:	o Functional Programming in JS
//						:	o HTML5 Forms
//						:	o Mastering JavaScript
//						:	o Thinking in HTML
//						:	o Android Quick Start Guide
//						:	o Selenium Ruby
//		Test case 6		: PASSED
		
	}

	@Test
	public void testCase7() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 7. Shop-Default Sorting Functionality - Sort by High to Low");
		System.out.println("Expected Result\t: Click on Sort by High to Low .");
		System.out.println("\t\t: User can view the popular products only");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();

		WebElement sorting = driver.findElement(By.xpath(sortingdropdown));
		Select sortingDropdown = new Select(sorting);
		sortingDropdown.selectByValue("price-desc");
		
		System.out.println("Result\t\t: - Sorting by price:high to low");
		
		List<WebElement> bookList = driver.findElements(By.xpath(bookname));
		for(WebElement bookDetail : bookList) {
			System.out.println("\t\t:\to " + bookDetail.getText());
		}
		
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL, true);
		if(currentURL.contains("price-desc")) {
			System.out.println("Test case 7\t: PASSED");
		}else {
			System.out.println("Test case 7\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 7. Shop-Default Sorting Functionality - Sort by High to Low
//		Expected Result	: Click on Sort by High to Low .
//						: User can view the popular products only
//						:
//		Result			: - Sorting by price:high to low
//						:	o Selenium Ruby
//						:	o Android Quick Start Guide
//						:	o Thinking in HTML
//						:	o Mastering JavaScript
//						:	o HTML5 Forms
//						:	o Functional Programming in JS
//						:	o HTML5 WebApp Develpment
//						:	o JS Data Structures and Algorithm
//		Test case 7		: PASSED
		
	}
	
	@Test
	public void testCase8() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 8. Shop-Read More Functionality");
		System.out.println("Expected Result\t: Read More option indicates the Out Of Stock.");
		System.out.println("\t\t: User cannot add the product which has read more option as it was out of stock.");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();
		driver.findElement(By.xpath(readmore)).click();
		
		WebElement outOfStock = driver.findElement(By.xpath(outofstock));
		Assert.assertTrue(outOfStock.isDisplayed());
		
		System.out.println("Result\t\t: " + driver.findElement(By.xpath(productname)).getText());
		System.out.println("\t\t: " + outOfStock.getText());
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL, true);
		if(outOfStock.getText().contains("Out of stock")) {
			System.out.println("Test case 8\t: PASSED");
		}else {
			System.out.println("Test case 8\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 8. Shop-Read More Functionality
//		Expected Result	: Read More option indicates the Out Of Stock.
//						: User cannot add the product which has read more option as it was out of stock.
//						:
//		Result			: Selenium Ruby
//						: Out of stock
//		Test case 8		: PASSED
		
	}
	@Test
	public void testCase9() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 9. Shop-Sale Functionality");
		System.out.println("Expected Result\t: Click on Sale written product in home page.");
		System.out.println("\t\t: User can clearly view the actual price with");
		System.out.println("\t\t: old price striken for the sale written products.");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();
		driver.findElement(By.xpath(onsale)).click();
		
		WebElement salePrice = driver.findElement(By.xpath(saleprice));
		Assert.assertTrue(salePrice.isDisplayed());
		
		System.out.println("Result\t\t: " + driver.findElement(By.xpath(productname)).getText());
		System.out.println("\t\t: " + salePrice.getText());
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL, true);
		if(salePrice.getText().contains("₹600.00 ₹450.00")) {
			System.out.println("Test case 9\t: PASSED");
		}else {
			System.out.println("Test case 9\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case		: 9. Shop-Sale Functionality
//		Expected Result	: Click on Sale written product in home page.
//						: User can clearly view the actual price with
//						: old price striken for the sale written products.
//						:
//		Result			: Android Quick Start Guide
//						: ₹600.00 ₹450.00
//		Test case 9		: PASSED
		
	}
	
	@Test
	public void testCase10() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 10. Shop-Add to Basket-View Basket Functionality");
		System.out.println("Expected Result\t: User can completly place his order.");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();
		driver.findElement(By.xpath(addtobasket)).click();
		System.out.println("Result\t\t: - " + driver.findElement(By.xpath(iteminbasket)).getText() + " was added to basket");

		driver.findElement(By.xpath(viewbasket)).click();
		System.out.println("\t\t: - Click View Basket link");
		System.out.println("\t\t:   " + driver.findElement(By.xpath(itemsincartinfo)).getText());
		System.out.println("\t\t: - Proceed to checkout page's details");
		
		String subTotal = driver.findElement(By.xpath(subtotal)).getText();
		String Total = driver.findElement(By.xpath(total)).getText();

		System.out.println("\t\t:   Subtotal : " + subTotal);
		System.out.println("\t\t:   Total    : " + Total);
		subTotal = subTotal.replaceAll("[^0-9]", "");
		Total = Total.replaceAll("[^0-9]", "");
		double valSubTotal = Double.parseDouble(subTotal)/100;
		double valTotal = Double.parseDouble(Total)/100;
		
		System.out.println("\t\t: - The total always > subtotal because taxes are added in the subtotal");
		Assert.assertTrue(valSubTotal<valTotal);
		System.out.println("\t\t:   Total " + valTotal + " > Subtotal "+ valSubTotal);
 
		driver.findElement(By.xpath(proceedcheckout)).click();
		
		System.out.println("\t\t: - User can fill his details in billing details form");
		System.out.println("\t\t:   and can opt any payment in the payment gateway");
		driver.findElement(By.xpath(firstname)).sendKeys(fillFirstname);
		driver.findElement(By.xpath(lastname)).sendKeys(fillLastname);
		driver.findElement(By.xpath(company)).sendKeys(fillCompany);
		driver.findElement(By.xpath(email)).sendKeys(fillEmail);
		driver.findElement(By.xpath(phone)).sendKeys(fillPhone);
		driver.findElement(By.xpath(country)).click();
		driver.findElement(By.xpath(countrysearch)).sendKeys(fillCountry, Keys.ENTER);
		driver.findElement(By.xpath(address1)).click();
		driver.findElement(By.xpath(address1)).sendKeys(fillAddress1);
		driver.findElement(By.xpath(address2)).sendKeys(fillAddress2);
		driver.findElement(By.xpath(city)).sendKeys(fillCity);
		driver.findElement(By.xpath(state)).click();
		driver.findElement(By.xpath(statesearch)).sendKeys(fillState, Keys.ENTER);
		driver.findElement(By.xpath(postalcode)).sendKeys(fillPostalcode);
		System.out.println("\t\t:   First name  > " + fillFirstname);
		System.out.println("\t\t:   Last name   > " + fillLastname);
		System.out.println("\t\t:   Company     > " + fillCompany);
		System.out.println("\t\t:   Email       > " + fillEmail);
		System.out.println("\t\t:   Phone       > " + fillPhone);
		System.out.println("\t\t:   Country     > " + fillCountry);
		System.out.println("\t\t:   Address1    > " + fillAddress1);
		System.out.println("\t\t:   Address2    > " + fillAddress2);
		System.out.println("\t\t:   City        > " + fillCity);
		System.out.println("\t\t:   State       > " + fillState);
		System.out.println("\t\t:   Postal code > " + fillPostalcode);
		System.out.println("\t\t: - Order detail  ");
		System.out.println("\t\t: "+ driver.findElement(By.xpath(orderdetail1)).getText());
		System.out.println("\t\t: - Payment method  ");
		driver.findElement(By.id("payment_method_cod")).click();
		System.out.println("\t\t: " + driver.findElement(By.xpath(paymenttype)).getText());

		WebElement orderReview = driver.findElement(By.xpath(orderreview));
		Assert.assertTrue(orderReview.isDisplayed());

		driver.findElement(By.id("place_order")).click();
		System.out.println("\t\t: - Order has been placed  ");
		WebElement orderDetails = driver.findElement(By.xpath(orderdetail2));

		Assert.assertTrue(orderDetails.isDisplayed());
		System.out.println("\t\t: Billing details");
		System.out.println("\t\t: " + orderDetails.getText());	
		
		if(orderDetails.isDisplayed()) {
			System.out.println("Test case 10\t: PASSED");
		}else {
			System.out.println("Test case 10\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case	: 10. Shop-Add to Basket-View Basket Functionality
//		Expected Result	: User can completly place his order.
//				:
//				: - Functional Programming in JS was added to basket
//				: - Click View Basket link
//				:   1 Item₹250.00
//				: - Proceed to checkout page's details
//				:   Subtotal : ₹250.00
//				:   Total    : ₹262.50
//				: - The total always > subtotal because taxes are added in the subtotal
//				:   Total 262.5 > Subtotal 250.0
//				: - User can fill his details in billing details form
//				:   and can opt any payment in the payment gateway
//				:   First name  > Weerawich
//				:   Last name   > p
//				:   Company     > Supreme
//				:   Email       > weerawich@gmail.com
//				:   Phone       > 7034889829
//				:   Country     > United States (US)
//				:   Address1    > 13971 metrotech dr
//				:   Address2    > Supreme
//				:   City        > Chantilly
//				:   State       > Virginia
//				:   Postal code > 20151
//				: - Order detail  
//				: Product Total
//		Functional Programming in JS  × 1 ₹250.00
//		Subtotal ₹250.00
//		Roaming Tax ₹12.50
//		Total ₹262.50
//				: - Payment method  
//				: Cash on Delivery
//				: - Order has been placed  
//				: Billing details
//				: ORDER NUMBER:
//		8657
//		DATE:
//		February 25, 2022
//		TOTAL:
//		₹262.50
//		PAYMENT METHOD:
//		Cash on Delivery
//		Test case 10	: PASSED
		
	}
	
	@Test
	public void testCase11() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 11.Shop-Add to Basket-View Basket through Item link");
		System.out.println("Expected Result\t: User can completly place his order.");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();
		driver.findElement(By.xpath(addtobasket)).click();
		System.out.println("Result\t\t: - " + driver.findElement(By.xpath(iteminbasket)).getText() + " was added to basket");

		driver.findElement(By.xpath(itemsincartlink)).click();
		System.out.println("\t\t: - Click item link");
		System.out.println("\t\t:   " + driver.findElement(By.xpath(itemsincartinfo)).getText());
		System.out.println("\t\t: - Proceed to checkout page's details");
		
		String subTotal = driver.findElement(By.xpath(subtotal)).getText();
		String Total = driver.findElement(By.xpath(total)).getText();

		System.out.println("\t\t:   Subtotal : " + subTotal);
		System.out.println("\t\t:   Total    : " + Total);
		subTotal = subTotal.replaceAll("[^0-9]", "");
		Total = Total.replaceAll("[^0-9]", "");
		double valSubTotal = Double.parseDouble(subTotal)/100;
		double valTotal = Double.parseDouble(Total)/100;
 
		System.out.println("\t\t: - The total always > subtotal because taxes are added in the subtotal");
		Assert.assertTrue(valSubTotal<valTotal);
		System.out.println("\t\t:   Total " + valTotal + " > Subtotal "+ valSubTotal );
 
		driver.findElement(By.xpath(proceedcheckout)).click();
		
		System.out.println("\t\t: - User can fill his details in billing details form");
		System.out.println("\t\t:   and can opt any payment in the payment gateway");
		driver.findElement(By.xpath(firstname)).sendKeys(fillFirstname);
		driver.findElement(By.xpath(lastname)).sendKeys(fillLastname);
		driver.findElement(By.xpath(company)).sendKeys(fillCompany);
		driver.findElement(By.xpath(email)).sendKeys(fillEmail);
		driver.findElement(By.xpath(phone)).sendKeys(fillPhone);
		driver.findElement(By.xpath(country)).click();
		driver.findElement(By.xpath(countrysearch)).sendKeys(fillCountry, Keys.ENTER);
		driver.findElement(By.xpath(address1)).click();
		driver.findElement(By.xpath(address1)).sendKeys(fillAddress1);
		driver.findElement(By.xpath(address2)).sendKeys(fillAddress2);
		driver.findElement(By.xpath(city)).sendKeys(fillCity);
		driver.findElement(By.xpath(state)).click();
		driver.findElement(By.xpath(statesearch)).sendKeys(fillState, Keys.ENTER);
		driver.findElement(By.xpath(postalcode)).sendKeys(fillPostalcode);
		System.out.println("\t\t:   First name  > " + fillFirstname);
		System.out.println("\t\t:   Last name   > " + fillLastname);
		System.out.println("\t\t:   Company     > " + fillCompany);
		System.out.println("\t\t:   Email       > " + fillEmail);
		System.out.println("\t\t:   Phone       > " + fillPhone);
		System.out.println("\t\t:   Country     > " + fillCountry);
		System.out.println("\t\t:   Address1    > " + fillAddress1);
		System.out.println("\t\t:   Address2    > " + fillAddress2);
		System.out.println("\t\t:   City        > " + fillCity);
		System.out.println("\t\t:   State       > " + fillState);
		System.out.println("\t\t:   Postal code > " + fillPostalcode);
		System.out.println("\t\t: - Order detail  ");
		System.out.println("\t\t: "+ driver.findElement(By.xpath(orderdetail1)).getText());
		System.out.println("\t\t: - Payment method  ");
		driver.findElement(By.id("payment_method_cod")).click();
		System.out.println("\t\t: " + driver.findElement(By.xpath(paymenttype)).getText());

		WebElement orderReview = driver.findElement(By.xpath(orderreview));
		Assert.assertTrue(orderReview.isDisplayed());

		driver.findElement(By.id("place_order")).click();
		System.out.println("\t\t: - Order has been placed  ");
		WebElement orderDetails = driver.findElement(By.xpath(orderdetail2));

		Assert.assertTrue(orderDetails.isDisplayed());
		System.out.println("\t\t: Billing details");
		System.out.println("\t\t: " + orderDetails.getText());	
		
		if(orderDetails.isDisplayed()) {
			System.out.println("Test case 11\t: PASSED");
		}else {
			System.out.println("Test case 11\t: FAILED");
		}
		driver.close();
		
//		Console will be displayed
//		Shop
//		Test case	: 11. Shop-Add to Basket-View Basket Functionality
//		Expected Result	: User can completly place his order.
//				:
//				: - Functional Programming in JS was added to basket
//				: - Click item link
//				:   1 Item₹250.00
//				: - Proceed to checkout page's details
//				:   Subtotal : ₹250.00
//				:   Total    : ₹262.50
//				: - The total always > subtotal because taxes are added in the subtotal
//				:   Total 262.5 > Subtotal 250.0
//				: - User can fill his details in billing details form
//				:   and can opt any payment in the payment gateway
//				:   First name  > Weerawich
//				:   Last name   > p
//				:   Company     > Supreme
//				:   Email       > weerawich@gmail.com
//				:   Phone       > 7034889829
//				:   Country     > United States (US)
//				:   Address1    > 13971 metrotech dr
//				:   Address2    > Supreme
//				:   City        > Chantilly
//				:   State       > Virginia
//				:   Postal code > 20151
//				: - Order detail  
//				: Product Total
//		Functional Programming in JS  × 1 ₹250.00
//		Subtotal ₹250.00
//		Roaming Tax ₹12.50
//		Total ₹262.50
//				: - Payment method  
//				: Cash on Delivery
//				: - Order has been placed  
//				: Billing details
//				: ORDER NUMBER:
//		8658
//		DATE:
//		February 25, 2022
//		TOTAL:
//		₹262.50
//		PAYMENT METHOD:
//		Cash on Delivery
//		Test case 11		: PASSED
	}
	
	@Test
	public void testCase12() {

		System.out.println("\nShop");
		System.out.println("Test case\t: 12. Shop-Add to Basket-View Basket-Tax Functionality");
		System.out.println("Expected Result\t: Tax rate for indian should be 2% and for abroad it should be 5%.");
		System.out.println("\t\t:");
		driver.get(url);
		driver.findElement(By.xpath(shop)).click();
		driver.findElement(By.xpath(addtobasket)).click();
		System.out.println("Result\t\t: - " + driver.findElement(By.xpath(iteminbasket)).getText() + " was added to basket");

		driver.findElement(By.xpath(itemsincartlink)).click();
		System.out.println("\t\t: - Click item link");
		System.out.println("\t\t:   " + driver.findElement(By.xpath(itemsincartinfo)).getText());
		System.out.println("\t\t: - Proceed to checkout page's details");
		
		String subTotal = driver.findElement(By.xpath(subtotal)).getText();
		String Total = driver.findElement(By.xpath(total)).getText();

		System.out.println("\t\t:   Subtotal : " + subTotal);
		System.out.println("\t\t:   Total    : " + Total);
		subTotal = subTotal.replaceAll("[^0-9]", "");
		Total = Total.replaceAll("[^0-9]", "");
		double valSubTotal = Double.parseDouble(subTotal)/100;
		double valTotal = Double.parseDouble(Total)/100;
 
		System.out.println("\t\t: - The total always > subtotal because taxes are added in the subtotal");
		Assert.assertTrue(valSubTotal<valTotal);
		System.out.println("\t\t:   Total " + valTotal + " > Subtotal "+ valSubTotal );
		
		driver.findElement(By.xpath(proceedcheckout)).click();

		driver.findElement(By.xpath(country)).click();
		int randomCountry = (int)(Math.random() * (251-3+1))+3;
		String selCountry = "//*[@id=\"select2-result-label-"+ randomCountry +"\"]";

		fillCountry = driver.findElement(By.xpath(selCountry)).getText();
		driver.findElement(By.xpath(countrysearch)).sendKeys(fillCountry, Keys.ENTER);
		String strTax = driver.findElement(By.xpath(tax)).getText().replaceAll("₹", "");
		double valTax = Double.parseDouble(strTax);
		double taxRate = (valTax*100) / valSubTotal;
		System.out.println("\t\t: - Tax rate for indian should be 2% and for abroad it should be 5%");
		System.out.println("\t\t:   -> Tax rate for " + fillCountry + " = " + taxRate + " % (random check)" );
		
		fillCountry = "India";
		driver.findElement(By.xpath(country)).click();
		driver.findElement(By.xpath(countrysearch)).sendKeys(fillCountry);
		driver.findElement(By.xpath(countrysearch)).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath(countrysearch)).sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.textToBe(By.xpath(roamingtax),"Tax"));
		
		strTax = driver.findElement(By.xpath(tax)).getText().replaceAll("₹", "");
		valTax = Double.parseDouble(strTax);
		taxRate = (valTax*100) / valSubTotal;
		System.out.println("\t\t:   -> Tax rate for " + fillCountry + " = " + taxRate + " %" );
		Assert.assertTrue(taxRate==2);
		if(fillCountry.equals("India") && taxRate==2) {
			System.out.println("Test case 12\t: PASSED");
		}else {
			System.out.println("Test case 12\t: FAILED");
		}
		driver.close();

//		Console will be displayed
//		Shop
//		Test case		: 12. Shop-Add to Basket-View Basket-Tax Functionality
//		Expected Result	: Tax rate for indian should be 2% and for abroad it should be 5%.
//						:
//						: - Functional Programming in JS was added to basket
//						: - Click item link
//						:   1 Item₹250.00
//						: - Proceed to checkout page's details
//						:   Subtotal : ₹250.00
//						:   Total    : ₹262.50
//						: - The total always > subtotal because taxes are added in the subtotal
//						:   Total 262.5 > Subtotal 250.0
//						: - Tax rate for indian should be 2% and for abroad it should be 5%
//		Result			:   -> Tax rate for British Virgin Islands = 5.0 % (random check)
//						:   -> Tax rate for India = 2.0 %
//		Test case 12	: PASSED
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
