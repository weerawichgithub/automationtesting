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

public class homepageTesting {
	WebDriver driver;
	WebDriverWait wait;
	ConfigFileReader config = new ConfigFileReader("src/test/java/automationtesting/homepage.properties");

	private String url = config.getProperties("url");
	private String shopMenu = config.getProperties("shopMenu");
	private String homeButton = config.getProperties("homeButton");
	private String slidersCount = config.getProperties("sliders");
	private String arrivalsCount = config.getProperties("arrivals");
	private String arrivalImg = config.getProperties("arrivalImg");
	private String addToBasket = config.getProperties("addCartButton");
	private String descriptionTab = config.getProperties("descriptionTab");
	private String bookDescription = config.getProperties("bookDescription");
	private String reviewTab = config.getProperties("reviewTab");
	private String comments = config.getProperties("comments");
	private String itemInput = config.getProperties("itemInput");
	private String proceedCheckout = config.getProperties("proceedCheckout");
	private String itemsTopButton = config.getProperties("itemsTopButton");
	private String couponInput = config.getProperties("couponInput");
	private String couponCode = config.getProperties("couponCode");
	private String couponMsg = config.getProperties("couponMsg");
	private String total = config.getProperties("total");
	private String subtotal = config.getProperties("subtotal");
	private String totalgrid = config.getProperties("totalgrid");
	private String applyCouponButton = config.getProperties("applyCouponButton");
	private String qty = config.getProperties("qtyInput");
	private String qty165 = config.getProperties("qtyInput165");
	private String updBasket = config.getProperties("updBasket");
	private String removeItem = config.getProperties("removeItem");
	private String removeMsg = config.getProperties("removeMessage");
	private String checkoutbtn = config.getProperties("checkoutbtn");
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
	private String paymentdesc = config.getProperties("paymentdesc");
	private String couponlink = config.getProperties("couponlink");
	private String couponinput = config.getProperties("couponinput");
	private String couponapply = config.getProperties("couponapply");
	private String coupondesc = config.getProperties("coupondesc");
	private String orderreview = config.getProperties("orderreview");
	private String placeorderbtn = config.getProperties("placeorderbtn");
	private String orderdetail = config.getProperties("orderdetail");
	private String orderreceive = config.getProperties("orderreceive");
	
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,10);
	}
	
	@Test
	public void testCase1() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 1. Home Page with three Sliders only");
		System.out.println("Expected Result\t: The Home page must contains only three sliders");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
		
		List<WebElement> sliders = driver.findElements(By.xpath(slidersCount));

        int numberOfSliders = sliders.size();
        Assert.assertEquals(numberOfSliders,3);
        
        System.out.println("\t\t: - Number of sliders = " + numberOfSliders);
        if(numberOfSliders==3) {
            System.out.println("Test case 1\t: PASSED");
        }else {
            System.out.println("Test case 1\t: FAILED");
        }
        driver.close();
/*
 Console will be displayed :
 
Home page
Test case		: 1. Home Page with three Sliders only
Expected Result	: The Home page must contains only three sliders
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: - Number of sliders = 3
Test case 1		: PASSED

 */
	}
	
	@Test
	public void testCase2() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 2. Home page with three Arrivals only");
		System.out.println("Expected Result\t: The Home page must contains only three Arrivals");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t: New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);
		
		if(arrivals.size()==3) {
			System.out.println("Test case 2\t: PASSED");
		}else {
			System.out.println("Test case 2\t: FAILED");
		}
		
		driver.close();
/*
 Console will be displayed :

Home page
Test case		: 2. Home page with three Arrivals only
Expected Result	: The Home page must contains only three Arrivals
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
Test case 2		: PASSED
*/      
	}
	
	@Test
	public void testCase3() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 3. Home page - Images in Arrivals should navigate");
		System.out.println("Expected Result\t: Image should be clickable and shoul navigate to next page ");
		System.out.println("\t\t: where user can add that book to his basket");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t: New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		
		if(addCartButton.isDisplayed()) {
			System.out.println("Test case 3\t: PASSED");
		}else {
			System.out.println("Test case 3\t: FAILED");
		}
		
		driver.close();
/*
Console will be displayed :

Home page
Test case		: 3. Home page - Images in Arrivals should navigate
Expected Result	: Image should be clickable and shoul navigate to next page 
				: where user can add that book to his basket
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
Test case 3		: PASSED
*/
	}
	
	@Test
	public void testCase4() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 4. Home page - Arrivals-Images-Description");
		System.out.println("Expected Result\t: There should be a description regarding that book the user clicked on");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		
		System.out.println("\t\t: - Click on Description tab");
		driver.findElement(By.xpath(descriptionTab)).click();
		WebElement bookDesc = driver.findElement(By.xpath(bookDescription));
		System.out.println("\t\t:   Product Description : ");
		System.out.println("\t\t:\t" + bookDesc.getText().substring(0,60));
		System.out.println("\t\t:\t" + bookDesc.getText().substring(61,118) + " ...");
		
		Assert.assertTrue(bookDesc.isDisplayed());
		if(bookDesc.isDisplayed()) {
			System.out.println("Test case 4\t: PASSED");
		}else {
			System.out.println("Test case 4\t: FAILED");
		}
		
		driver.close();
		
/*
Console will be displayed :

Home page
Test case		: 4. Home page - Arrivals-Images-Description
Expected Result	: There should be a description regarding that book the user clicked on
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on Description tab
				:   Product Description : 
				:		It would seem that everything that needs to be written about
				:		JavaScript has been written. Frankly, it is difficult to  ...
Test case 4		: PASSED
 */
	}

	@Test
	public void testCase5() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 5. Home page - Arrivals-Images-Reviews");
		System.out.println("Expected Result\t: There should be a Reviews regarding that book the user clicked on");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click  Reviews tab");
		driver.findElement(By.xpath(reviewTab)).click();
		
		WebElement review = driver.findElement(By.xpath(comments));
		System.out.println("\t\t:   Reviews : ");
		System.out.println("\t\t:\t" + review.getText()+ " ...");
		
		Assert.assertTrue(review.isDisplayed());	
		if(review.isDisplayed()) {
			System.out.println("Test case 5\t: PASSED");
		}else {
			System.out.println("Test case 5\t: FAILED");
		}
		
		driver.close();
/*
Console will be displayed :

Home page
Test case		: 5. Home page - Arrivals-Images-Reviews
Expected Result	: There should be a Reviews regarding that book the user clicked on
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click  Reviews tab
				:   Reviews : 
				:	There are no reviews yet. ...
Test case 5		: PASSED
 */
	}

	@Test
	public void testCase6() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 6. Home page - Arrivals-Images-Add to Basket");
		System.out.println("Expected Result\t: User can add a book by clicking on Add To Basket button which adds that book in to his Basket");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		if(chkViewPrice.isDisplayed()) {
			System.out.println("Test case 6\t: PASSED");
		}else {
			System.out.println("Test case 6\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 6. Home page - Arrivals-Images-Add to Basket
Expected Result	: User can add a book by clicking on Add To Basket button which adds that book in to his Basket
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
Test case 6 	: PASSED
 */
	}

	@Test
	public void testCase7() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 7. Home page - Arrivals-Add to Basket with more books");
		System.out.println("Expected Result\t: Select more books than the books in stock.");
		System.out.println("\t\t: it will throw an error prompt like you must enter a value between 1 and 20");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());

		System.out.println("\t\t: - Select more books than the books in stock.");
		WebElement itemBox = driver.findElement(By.xpath(itemInput));
		String chkStock = itemBox.getAttribute("max");
		System.out.println("\t\t:   There were "+ chkStock + " in stock.");
		int addOverStock = Integer.parseInt(chkStock) + 1;
		chkStock = addOverStock + "";
		System.out.println("\t\t:   Try to add " + chkStock + " to basket.");
		itemBox.sendKeys(chkStock);
		
		boolean canAddOverStock;
		try{
			addCartButton.click();
			canAddOverStock = true;
		}catch(Exception e) {
			System.out.println("\t\t:   Over stock !!, can not add items to basket");
			canAddOverStock = false;
		}
		
		Assert.assertFalse(canAddOverStock);
		if(canAddOverStock==false) {
			System.out.println("Test case 7\t: PASSED");
		}else {
			System.out.println("Test case 7\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 7. Home page - Arrivals-Add to Basket with more books
Expected Result	: Select more books than the books in stock.
				: it will throw an error prompt like you must enter a value between 1 and 20
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Select more books than the books in stock.
				:   There were 7226 in stock.
				:   Try to add 7227 to basket.
				:   Over stock !!, can not add items to basket
Test case 7 	: PASSED

 */
	}
	
	@Test
	public void testCase8() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 8. Home-Arrivals-Add to Basket-Items");
		System.out.println("Expected Result\t: User can click on the Item link in menu item after adding the book in");
		System.out.println("\t\t: to the basket which leads to the check out page");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());

		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();
		
		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   "+ proceedCheckoutBtn.getText() + " button is enabled.");
		if(proceedCheckoutBtn.isEnabled()) {
			System.out.println("Test case 8\t: PASSED");
		}else {
			System.out.println("Test case 8\t: FAILED");
		}
		
		driver.close();
/*
Console will be displayed :

Home page
Test case		: 8. Home-Arrivals-Add to Basket-Items
Expected Result	: User can click on the Item link in menu item after adding the book in
				: to the basket which leads to the check out page
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   User was in Check out page.
Test case 8 	: PASSED
 */
	}
	
	@Test
	public void testCase9() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 9. Home-Arrivals-Add to Basket-Items-Coupon");
		System.out.println("Expected Result\t: User can apply coupon by entering ‘krishnasakinala’ ");
		System.out.println("\t\t: in the coupon textbox which give 50rps off on the total price.");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		driver.findElement(By.xpath(qty165)).clear();
		driver.findElement(By.xpath(qty165)).sendKeys("2");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   "+ proceedCheckoutBtn.getText() + " button is enabled.");
		
		System.out.println("\t\t: - Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.");
//		String totalPriceStrBefore;
//		String totalPriceStrAfter;
 
//		totalPriceStrBefore = driver.findElement(By.xpath(totalPrice)).getText();
//		System.out.println("\t\t:   Total price before discount : " + totalPriceStrBefore);
		
		WebElement couponCodeInput = driver.findElement(By.xpath(couponInput));
		couponCodeInput.click();
		couponCodeInput.sendKeys(couponCode);
		driver.findElement(By.xpath(applyCouponButton)).click();

		WebElement couponMessage =driver.findElement(By.xpath(couponMsg));
		Assert.assertTrue(couponMessage.isDisplayed());
		System.out.println("\t\t:   " + couponMessage.getText());
		if (couponMessage.isDisplayed()) {
			System.out.println("Test case 9\t: PASSED");
		} else {
			System.out.println("Test case 9\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 9. Home-Arrivals-Add to Basket-Items-Coupon
Expected Result	: User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox				: to the basket which leads to the check out page
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   2 Items₹700.00
				: - Click on Item link which navigates to proceed to check out page.
				:   PROCEED TO CHECKOUT button is enabled.
				: - Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
				:   Coupon usage limit has been reached.
Test case 9		: PASSED
 */
	}
	
	@Test
	public void testCase10() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t:  10. Home-Arrivals-Add to Basket-Items-Coupon value<450");
		System.out.println("Expected Result\t: User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox");
		System.out.println("\t\t: because the coupon is applicable for the book price > 450 rps");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   "+ proceedCheckoutBtn.getText() + " button is enabled.");
		
		System.out.println("\t\t: - Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.");
	
		WebElement couponCodeInput = driver.findElement(By.xpath(couponInput));
		couponCodeInput.click();
		couponCodeInput.sendKeys(couponCode);
		driver.findElement(By.xpath(applyCouponButton)).click();

		WebElement couponMessage =driver.findElement(By.xpath(couponMsg));
		Assert.assertTrue(couponMessage.isDisplayed());
		System.out.println("\t\t:   " + couponMessage.getText());
		if (couponMessage.isDisplayed()) {
			System.out.println("\t\t:   The minimum spend for this coupon is ₹450.00.");
			System.out.println("Test case 10\t: PASSED");
		} else {
			System.out.println("Test case 10\t: FAILED");
		}
		
		driver.close();
		
/*
Console will be displayed :

Home page
Test case		: 10. Home-Arrivals-Add to Basket-Items-Coupon value<450
Expected Result	: User can click on the Item link in menu item after adding the book in
				: to the basket which leads to the check out page
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   PROCEED TO CHECKOUT button is enabled.
				: - Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
				:   Coupon usage limit has been reached.
				:   The minimum spend for this coupon is ₹450.00.
Test case 10	: PASSED
 */
	}

	@Test
	public void testCase11() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 11. Home-Arrivals-Add to Basket-Items-Remove book");
		System.out.println("Expected Result\t: User has the feasibility to remove the book at the time of check out also");
		System.out.println("\t\t: ");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:  "+ proceedCheckoutBtn.getText() + " button is enabled.");
		
		System.out.println("\t\t: - Click on Remove icon in Check out page which removes that book from the grid.");
	
		WebElement removeItemBtn = driver.findElement(By.xpath(removeItem));
		removeItemBtn.click();

		wait.until(ExpectedConditions.titleIs("Basket – Automation Practice Site"));
		WebElement basketEmpty = driver.findElement(By.xpath(removeMsg));
		Assert.assertTrue(basketEmpty.isDisplayed());
		System.out.println("\t\t:   " + basketEmpty.getText());
		if (basketEmpty.isDisplayed()) {
			System.out.println("Test case 11\t: PASSED");
		} else {
			System.out.println("Test case 11\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 11. Home-Arrivals-Add to Basket-Items-Remove book
Expected Result	: User has the feasibility to remove the book at the time of check out also
				: 
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				: New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   PROCEED TO CHECKOUT button is enabled.
				: -  Click on Remove icon in Check out page which removes that book from the grid.
				:   Your basket is currently empty.
Test case 11	: PASSED 
*/
	}
	
	@Test
	public void testCase12() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 12. Home-Arrivals-Add to Basket-Items-Add book");
		System.out.println("Expected Result\t: User has the feasibility to Update Basket at the time of check out.");
		System.out.println("\t\t: ");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   "+ proceedCheckoutBtn.getText() + " button is enabled.");
		
		System.out.println("\t\t: - Click on textbox value under quantity in Check out page to add or subtract books");
		WebElement totalGrid1 = driver.findElement(By.xpath(totalgrid));
		String beforeUpdQty = totalGrid1.getText();
		System.out.println("\t\t:   Total price before update quantity " + beforeUpdQty);

		WebElement updQty = driver.findElement(By.xpath(qty));
		updQty.clear();
		updQty.sendKeys("2");

		System.out.println("\t\t: - Click on Update Basket to reflect those changes");

		WebElement updBasketBtn = driver.findElement(By.xpath(updBasket));
		Assert.assertTrue(updBasketBtn.isEnabled());
		System.out.println("\t\t:   \"UPDATE BASKET\" button is enabled");
		driver.findElement(By.xpath(updBasket)).click();
		wait.until(ExpectedConditions.invisibilityOf(updBasketBtn));
		WebElement totalGrid2 = driver.findElement(By.xpath(totalgrid));
		String afterUpdQty = totalGrid2.getText();
		System.out.println("\t\t:   Total price after update quantity " + afterUpdQty);

		if (!beforeUpdQty.equals(afterUpdQty)) {
			System.out.println("Test case 12\t: PASSED");
		} else {
			System.out.println("Test case 12\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 12. Home-Arrivals-Add to Basket-Items-Add book
Expected Result	: User has the feasibility to Update Basket at the time of check out.
				: 
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				:   New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   PROCEED TO CHECKOUT button is enabled.
				: - Click on textbox value under quantity in Check out page to add or subtract books
				:   Total price before update quantity ₹350.00
				: - Click on Update Basket to reflect those changes
				:   "UPDATE BASKET" button is enabled
				:   Total price after update quantity ₹700.00
Test case 12	: PASSED
*/
	}
	
	@Test
	public void testCase13() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 13. Home-Arrivals-Add to Basket-Items-Check-out-Book Final price");
		System.out.println("Expected Result\t: User has the feasibility to find the total price of the books at to find the total price of the books at the time of check out");
		System.out.println("\t\t: ");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   \""+ proceedCheckoutBtn.getText() + "\" button is enabled.");
		
		System.out.println("\t\t: - User can find the Total price of the book in the Check out grid.");
		WebElement totalGrid = driver.findElement(By.xpath(totalgrid));
		Assert.assertTrue(totalGrid.isDisplayed());
		System.out.println("\t\t:   Total price " + totalGrid.getText());

		if (totalGrid.isDisplayed()) {
			System.out.println("Test case 13\t: PASSED");
		} else {
			System.out.println("Test case 13\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 13. Home-Arrivals-Add to Basket-Items-Check-out-Book Final price
Expected Result	: User has the feasibility to find the total price of the books at to find the total price of the books at the time of check out
				: 
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				:   New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   "PROCEED TO CHECKOUT" button is enabled.
				: - User can find the Total price of the book in the Check out grid.
				:   Total price ₹350.00
Test case 13	: PASSED
*/
	}
	
	@Test
	public void testCase14() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 14. Home-Arrivals-Add to Basket-Items-Check-out-Update Basket");
		System.out.println("Expected Result\t: User has the feasibility to Update Basket at the time of check out.");
		System.out.println("\t\t: ");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   \""+ proceedCheckoutBtn.getText() + "\" button is enabled.");
		
		System.out.println("\t\t: - Click on textbox value under quantity in Check out page to add or subtract books");
		WebElement totalGrid1 = driver.findElement(By.xpath(totalgrid));
		String beforeUpdQty = totalGrid1.getText();
		System.out.println("\t\t:   Total price before update quantity " + beforeUpdQty);

		WebElement updQty = driver.findElement(By.xpath(qty));
		updQty.clear();
		updQty.sendKeys("2");

		System.out.println("\t\t: - Click on Update Basket to reflect those changes");

		WebElement updBasketBtn = driver.findElement(By.xpath(updBasket));
		Assert.assertTrue(updBasketBtn.isEnabled());
		System.out.println("\t\t:   \"UPDATE BASKET\" button is enabled");
		driver.findElement(By.xpath(updBasket)).click();
		wait.until(ExpectedConditions.invisibilityOf(updBasketBtn));
		WebElement totalGrid2 = driver.findElement(By.xpath(totalgrid));
		String afterUpdQty = totalGrid2.getText();
		System.out.println("\t\t:   Total price after update quantity " + afterUpdQty);

		if (!beforeUpdQty.equals(afterUpdQty)) {
			System.out.println("Test case 14\t: PASSED");
		} else {
			System.out.println("Test case 14\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 14. Home-Arrivals-Add to Basket-Items-Check-out-Update Basket
Expected Result	: User has the feasibility to Update Basket at the time of check out.				: 
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				:   New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   "PROCEED TO CHECKOUT" button is enabled.
				: - Click on textbox value under quantity in Check out page to add or subtract books
				:   Total price before update quantity ₹350.00
				: - Click on Update Basket to reflect those changes
				:   "UPDATE BASKET" button is enabled
				:   Total price after update quantity ₹700.00
Test case 14	: PASSED
*/
	}
	
	@Test
	public void testCase15() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 15. Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition");
		System.out.println("Expected Result\t: The total always > subtotal because taxes are added in the subtotal");
		System.out.println("\t\t: ");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   \""+ proceedCheckoutBtn.getText() + "\" button is enabled.");
		
		System.out.println("\t\t: - User can find total and subtotal values just above the Proceed to Checkout button.");
		
		String subTotal = driver.findElement(By.xpath(subtotal)).getText().replaceAll("[^0-9]", "");
		double valSubTotal = Double.parseDouble(subTotal)/100;
		System.out.println("\t\t:   Subtotal : " + valSubTotal);
		
		String Total = driver.findElement(By.xpath(total)).getText().replaceAll("[^0-9]", "");
		double valTotal = Double.parseDouble(Total)/100;
		System.out.println("\t\t:   Total    : " + valTotal);
		System.out.println("\t\t:   Subtotal =" + valSubTotal + " < Total =" + valTotal);

		if(valSubTotal<valTotal) {
						System.out.println("Test case 15\t: PASSED");
		}else {
			System.out.println("Test case 15\t: FAILED");
		}		

		driver.close();

/*
Console will be displayed :

Home page
Test case		: 15. Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition
Expected Result	: The total always > subtotal because taxes are added in the subtotal
				: 
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				:   New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   "PROCEED TO CHECKOUT" button is enabled.
				: - User can find total and subtotal values just above the Proceed to Checkout button.
				:   Subtotal : 350.0
				:   Total    : 367.5
				:   Subtotal =350.0 < Total =367.5
Test case 15	: PASSED
*/
	}
	
	@Test
	public void testCase16() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 16. Home-Arrivals-Add to Basket-Items-Check-out functionality");
		System.out.println("Expected Result\t: Clicking on Proceed to Checkout button leads to payment gateway page");
		System.out.println("\t\t: ");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   \""+ proceedCheckoutBtn.getText() + "\" button is enabled.");

		System.out.println("\t\t: - User can find total and subtotal values just above the Proceed to Checkout button.");
		String subTotal = driver.findElement(By.xpath(subtotal)).getText().replaceAll("[^0-9]", "");
		double valSubTotal = Double.parseDouble(subTotal)/100;
		System.out.println("\t\t:   Subtotal : " + valSubTotal);
		
		String Total = driver.findElement(By.xpath(total)).getText().replaceAll("[^0-9]", "");
		double valTotal = Double.parseDouble(Total)/100;
		System.out.println("\t\t:   Total    : " + valTotal);
		System.out.println("\t\t:   Subtotal =" + valSubTotal + " < Total =" + valTotal);

		System.out.println("\t\t: - Click on Proceed to Check out button which navigates to payment gateway page.");
		driver.findElement(By.xpath(checkoutbtn)).click();
		Assert.assertEquals(driver.getTitle(), "Checkout – Automation Practice Site");
		System.out.println("\t\t:   Page Title is " + driver.getTitle());
		
		if(driver.getTitle().equalsIgnoreCase("Checkout – Automation Practice Site")) {
			System.out.println("Test case 16\t: PASSED");
		}else {
			System.out.println("Test case 16\t: FAILED");
		}
		
		driver.close();

/*
Console will be displayed :

Home page
Test case		: 16. Home-Arrivals-Add to Basket-Items-Check-out functionality
Expected Result	: Clicking on Proceed to Checkout button leads to payment gateway page
				: 
Result			: - Click on Shop Menu
				: - Click on Home Menu button
				:   New arrivals = 3
				:	 o Selenium Ruby
				:	 o Thinking in HTML
				:	 o Mastering JavaScript
				: - Click the image in the Arrivals
				:   ADD TO BASKET button is displayed.
				: - Click on the Add To Basket button
				: - User can view that Book in the Menu item with price.
				:   1 Item₹350.00
				: - Click on Item link which navigates to proceed to check out page.
				:   "PROCEED TO CHECKOUT" button is enabled.
				: - Click on Proceed to Check out button which navigates to payment gateway page.
				:   Page Title is Checkout – Automation Practice Site
Test case 16 	: PASSED

*/
	}
	
	@Test
	public void testCase17() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 17. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway");
		System.out.println("Expected Result\t: User has the feasibility to add coupon in the payment gateway page");
		System.out.println("\t\t: and also he can find billing,order and additional details.");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   \""+ proceedCheckoutBtn.getText() + "\" button is enabled.");

		System.out.println("\t\t: - User can find total and subtotal values just above the Proceed to Checkout button.");
		String subTotal = driver.findElement(By.xpath(subtotal)).getText().replaceAll("[^0-9]", "");
		double valSubTotal = Double.parseDouble(subTotal)/100;
		System.out.println("\t\t:   Subtotal : " + valSubTotal);
		
		String Total = driver.findElement(By.xpath(total)).getText().replaceAll("[^0-9]", "");
		double valTotal = Double.parseDouble(Total)/100;
		System.out.println("\t\t:   Total    : " + valTotal);
		System.out.println("\t\t:   Subtotal =" + valSubTotal + " < Total =" + valTotal);

		System.out.println("\t\t: - Click on Proceed to Check out button which navigates to payment gateway page.");
		driver.findElement(By.xpath(checkoutbtn)).click();
		Assert.assertEquals(driver.getTitle(), "Checkout – Automation Practice Site");
		System.out.println("\t\t:   Page Title is " + driver.getTitle());
		
		System.out.println("\t\t: - Now user can fill his details in billing details form and can opt any payment in the payment gateway");
		System.out.println("\t\t:   Direct bank transfer,cheque,cash or paypal.");
		
		driver.findElement(By.xpath(couponlink)).click();
		driver.findElement(By.xpath(couponinput)).sendKeys(couponCode);
		driver.findElement(By.xpath(couponapply)).click();
		String couponDesc = driver.findElement(By.xpath(coupondesc)).getText();
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
		driver.findElement(By.xpath(paymenttype)).click();
		String paymentDesc = driver.findElement(By.xpath(paymentdesc)).getText();
		
		System.out.println("\t\t:   First name   > " + fillFirstname);
		System.out.println("\t\t:   Last name    > " + fillLastname);
		System.out.println("\t\t:   Company name > " + fillCompany);
		System.out.println("\t\t:   Email        > " + fillEmail);
		System.out.println("\t\t:   Phone        > " + fillPhone);
		System.out.println("\t\t:   Country      > " + fillCountry);
		System.out.println("\t\t:   Address1     > " + fillAddress1);
		System.out.println("\t\t:   Address2     > " + fillAddress2);
		System.out.println("\t\t:   City         > " + fillCity);
		System.out.println("\t\t:   State        > " + fillState);
		System.out.println("\t\t:   Postal code  > " + fillPostalcode);
		System.out.println("\t\t:   Payment      > " + paymentDesc);
		System.out.println("\t\t:   ");
		System.out.println("\t\t: - User has the feasibility to add coupon in the payment gateway page");
		System.out.println("\t\t:   and also he can find billing,order and additional details.");
		System.out.println("\t\t:   Coupon label > " + couponDesc);	
		System.out.println("\t\t: o Order detail :  ");
		
		WebElement orderReview = driver.findElement(By.xpath(orderreview));
		Assert.assertTrue(orderReview.isDisplayed());
		System.out.println(orderReview.getText().substring(0,98));
		
		if(orderReview.isDisplayed()) {
			System.out.println("Test case 17\t: PASSED");
		}else {
			System.out.println("Test case 17\t: FAILED");
		}

		driver.close();

/*
Console will be displayed :

Home page
Test case		: 17. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
Expected Result	: User has the feasibility to add coupon in the payment gateway page
				: and also he can find billing,order and additional details.
Result			: - Click on Shop Menu
		: - Click on Home Menu button
		:   New arrivals = 3
		:	 o Selenium Ruby
		:	 o Thinking in HTML
		:	 o Mastering JavaScript
		: - Click the image in the Arrivals
		:   ADD TO BASKET button is displayed.
		: - Click on the Add To Basket button
		: - User can view that Book in the Menu item with price.
		:   1 Item₹350.00
		: - Click on Item link which navigates to proceed to check out page.
		:   "PROCEED TO CHECKOUT" button is enabled.
		: - User can find total and subtotal values just above the Proceed to Checkout button.
		:   Subtotal : 350.0
		:   Total    : 367.5
		:   Subtotal =350.0 < Total =367.5
		: - Click on Proceed to Check out button which navigates to payment gateway page.
		:   Page Title is Checkout – Automation Practice Site
		: - Now user can fill his details in billing details form and can opt any payment in the payment gateway
		:   Direct bank transfer,cheque,cash or paypal.
		:   First name   > Weerawich
		:   Last name    > p
		:   Company name > Supreme
		:   Email        > weerawich@gmail.com
		:   Phone        > 7034889829
		:   Country      > United States (US)
		:   Address1     > 13971 metrotech dr
		:   Address2     > Supreme
		:   City         > Chantilly
		:   State        > Virginia
		:   Postal code  > 20151
		:   Payment      > Cash on Delivery
		:   
		: - User has the feasibility to add coupon in the payment gateway page
		:   and also he can find billing,order and additional details.
		:   Coupon label > Coupon usage limit has been reached.
		: o Order detail :  
Product Total
Mastering JavaScript  × 1 ₹350.00
Subtotal ₹350.00
Roaming Tax ₹17.50
Total ₹367.50

Test case 17	: PASSED

*/
	}	
	
	@Test
	public void testCase18() {
		driver.get(url);
		System.out.println("\nHome page");
		System.out.println("Test case\t: 18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order");
		System.out.println("Expected Result\t:  On clicking place-order button user completes the process where");
		System.out.println("\t\t: the page navigates to Order confirmation page with order details,bank details,customer details and billing details.");
		System.out.println("Result\t\t: - Click on Shop Menu");
		driver.get(url);
		driver.findElement(By.xpath(shopMenu)).click();
		System.out.println("\t\t: - Click on Home Menu button");
		driver.findElement(By.xpath(homeButton)).click();
	
		List<WebElement> arrivals = driver.findElements(By.xpath(arrivalsCount));
		
		System.out.println("\t\t:   New arrivals = " + arrivals.size());	
		for(WebElement bookArrivals : arrivals) {
			System.out.println("\t\t:\t o " + bookArrivals.getText());
		}
		Assert.assertEquals(arrivals.size(),3);

		System.out.println("\t\t: - Click the image in the Arrivals");
		driver.findElement(By.xpath(arrivalImg)).click();
		
		WebElement addCartButton = driver.findElement(By.xpath(addToBasket));
		Assert.assertTrue(addCartButton.isDisplayed());
		System.out.println("\t\t:   " + addCartButton.getText() + " button is displayed.");
		System.out.println("\t\t: - Click on the Add To Basket button");
		addCartButton.click();
		System.out.println("\t\t: - User can view that Book in the Menu item with price.");
		
		WebElement chkViewPrice = driver.findElement(By.xpath(itemsTopButton));
		System.out.println("\t\t:   " + chkViewPrice.getText());
		Assert.assertTrue(chkViewPrice.isDisplayed());
		System.out.println("\t\t: - Click on Item link which navigates to proceed to check out page.");

		WebElement itemButton = driver.findElement(By.xpath(itemsTopButton));
		Assert.assertTrue(itemButton.isEnabled());
		itemButton.click();

		WebElement proceedCheckoutBtn = driver.findElement(By.xpath(proceedCheckout));
		Assert.assertTrue(proceedCheckoutBtn.isEnabled());
		System.out.println("\t\t:   \""+ proceedCheckoutBtn.getText() + "\" button is enabled.");

		System.out.println("\t\t: - User can find total and subtotal values just above the Proceed to Checkout button.");
		String subTotal = driver.findElement(By.xpath(subtotal)).getText().replaceAll("[^0-9]", "");
		double valSubTotal = Double.parseDouble(subTotal)/100;
		System.out.println("\t\t:   Subtotal : " + valSubTotal);
		
		String Total = driver.findElement(By.xpath(total)).getText().replaceAll("[^0-9]", "");
		double valTotal = Double.parseDouble(Total)/100;
		System.out.println("\t\t:   Total    : " + valTotal);
		System.out.println("\t\t:   Subtotal =" + valSubTotal + " < Total =" + valTotal);

		System.out.println("\t\t: - Click on Proceed to Check out button which navigates to payment gateway page.");
		driver.findElement(By.xpath(checkoutbtn)).click();
		Assert.assertEquals(driver.getTitle(), "Checkout – Automation Practice Site");
		System.out.println("\t\t:   Page Title is " + driver.getTitle());
		
		System.out.println("\t\t: - Now user can fill his details in billing details form and can opt any payment in the payment gateway");
		System.out.println("\t\t:   Direct bank transfer,cheque,cash or paypal.");
		
		driver.findElement(By.xpath(couponlink)).click();
		driver.findElement(By.xpath(couponinput)).sendKeys(couponCode);
		driver.findElement(By.xpath(couponapply)).click();
		String couponDesc = driver.findElement(By.xpath(coupondesc)).getText();
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
		driver.findElement(By.xpath(paymenttype)).click();
		String paymentDesc = driver.findElement(By.xpath(paymentdesc)).getText();
		
		System.out.println("\t\t:   First name   > " + fillFirstname);
		System.out.println("\t\t:   Last name    > " + fillLastname);
		System.out.println("\t\t:   Company name > " + fillCompany);
		System.out.println("\t\t:   Email        > " + fillEmail);
		System.out.println("\t\t:   Phone        > " + fillPhone);
		System.out.println("\t\t:   Country      > " + fillCountry);
		System.out.println("\t\t:   Address1     > " + fillAddress1);
		System.out.println("\t\t:   Address2     > " + fillAddress2);
		System.out.println("\t\t:   City         > " + fillCity);
		System.out.println("\t\t:   State        > " + fillState);
		System.out.println("\t\t:   Postal code  > " + fillPostalcode);
		System.out.println("\t\t:   Payment      > " + paymentDesc);
		System.out.println("\t\t:   ");
		System.out.println("\t\t: - User has the feasibility to add coupon in the payment gateway page");
		System.out.println("\t\t:   and also he can find billing,order and additional details.");
		System.out.println("\t\t:   Coupon label > " + couponDesc);	
		System.out.println("\t\t: o Order detail :  ");
		
		WebElement orderReview = driver.findElement(By.xpath(orderreview));
		Assert.assertTrue(orderReview.isDisplayed());
		System.out.println(orderReview.getText().substring(0,98));
		
		System.out.println("\t\t: - Click on Place Order button to complete process, ");
		System.out.println("\t\t:   the page navigates to Order confirmation page");
		driver.findElement(By.xpath(placeorderbtn)).click();
		
		WebElement orderReceive = driver.findElement(By.xpath(orderreceive));
		wait.until(ExpectedConditions.visibilityOfAllElements(orderReceive));
		
		WebElement orderDetails = driver.findElement(By.xpath(orderdetail));
		Assert.assertTrue(orderDetails.isDisplayed());
		System.out.println("\t\t:   " + orderReceive.getText());
		System.out.println(orderDetails.getText());
		
		if(orderDetails.isDisplayed()) {
			System.out.println("Test case 18\t: PASSED");
		}else {
			System.out.println("Test case 18\t: FAILED");
		}

		driver.close();

/*
Console will be displayed :

Home page
Test case	: 18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
Expected Result	:  On clicking place-order button user completes the process where
		: the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
Result		: - Click on Shop Menu
		: - Click on Home Menu button
		:   New arrivals = 3
		:	 o Selenium Ruby
		:	 o Thinking in HTML
		:	 o Mastering JavaScript
		: - Click the image in the Arrivals
		:   ADD TO BASKET button is displayed.
		: - Click on the Add To Basket button
		: - User can view that Book in the Menu item with price.
		:   1 Item₹350.00
		: - Click on Item link which navigates to proceed to check out page.
		:   "PROCEED TO CHECKOUT" button is enabled.
		: - User can find total and subtotal values just above the Proceed to Checkout button.
		:   Subtotal : 350.0
		:   Total    : 367.5
		:   Subtotal =350.0 < Total =367.5
		: - Click on Proceed to Check out button which navigates to payment gateway page.
		:   Page Title is Checkout – Automation Practice Site
		: - Now user can fill his details in billing details form and can opt any payment in the payment gateway
		:   Direct bank transfer,cheque,cash or paypal.
		:   First name   > Weerawich
		:   Last name    > p
		:   Company name > Supreme
		:   Email        > weerawich@gmail.com
		:   Phone        > 7034889829
		:   Country      > United States (US)
		:   Address1     > 13971 metrotech dr
		:   Address2     > Supreme
		:   City         > Chantilly
		:   State        > Virginia
		:   Postal code  > 20151
		:   Payment      > Cash on Delivery
		:   
		: - User has the feasibility to add coupon in the payment gateway page
		:   and also he can find billing,order and additional details.
		:   Coupon label > Coupon usage limit has been reached.
		: o Order detail :  
Product Total
Mastering JavaScript  × 1 ₹350.00
Subtotal ₹350.00
Roaming Tax ₹17.50
Total ₹367.50

		: - Click on Place Order button to complete process, 
		:   the page navigates to Order confirmation page
		:   Thank you. Your order has been received.
ORDER NUMBER:
8793
DATE:
February 28, 2022
TOTAL:
₹367.50
PAYMENT METHOD:
Cash on Delivery
Test case 18	: PASSED

*/
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
