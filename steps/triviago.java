
package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class triviago {
	public static ChromeDriver driver;
 
     
	@Given("Launch https://www.trivago.com")
	public void launchHttpsWwwTrivagoCom() throws InterruptedException {
		//Launching Chromebrowser
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 System.setProperty("webdriver.chrome.silentOutput", "true");
	//To disable notifications
		 ChromeOptions options= new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		 options.addArguments("--incognito");
		 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 
		  driver=new ChromeDriver(options);
		 //JavascriptExecutor js =  (JavascriptExecutor) driver;
					 
	//Maximize the browser
		 driver.manage().window().maximize();
	//Load the url
		 driver.get("https://www.trivago.com");
	//Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.executeScript("window.scrollBy(0,150)", "");
		    Thread.sleep(1000);
	

	}


	@And("Type Agra in Destination and select Agra, Uttar Pradesh")
	public void typeAgraInDestinationAndSelectAgraUttarPradesh() throws InterruptedException
	{
		 
		    driver.findElementByXPath("//input[@id='querytext']").sendKeys("Agra,UttarPradesh");
		    driver.findElementByXPath("//span[text()='City - Uttar Pradesh, India']").click();

	}

	@Given("Choose June 15 as check in and July 30 as check out")
	public void chooseMayAsCheckInAndJuneAsCheckOut() throws InterruptedException {
	 	 
		 WebElement fromdate= driver.findElementByXPath("(//span[text()='15'])");
		 driver.executeScript("arguments[0].click()", fromdate);
	 	 Thread.sleep(1000);
	 	WebElement todate=driver.findElementByXPath("//span[text()='30']");
	 	driver.executeScript("arguments[0].click()", todate);
	 
	}

	@Given("Select Room as Family Room")
	public void selectRoomAsFamilyRoom() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Family rooms']")).click(); Thread.sleep(1000);    
	    
	}

   @Given("Choose Number of Adults 2, Childern 1 and set Child's Age as 4")
	public void chooseNumberOfAdultsChildernAndSetChildSAgeAs( ) throws InterruptedException {
	 
	   WebElement adults = driver.findElement(By.xpath("(//select[@class='df-select'])[1]"));
	    Select selectAdults = new Select(adults);
	    selectAdults.selectByVisibleText("2"); 
	    WebElement children = driver.findElement(By.xpath("(//select[@class='df-select'])[2]"));
	    Select selectChildren = new Select(children);
	    selectChildren.selectByVisibleText("1");
	    Thread.sleep(1000);
	    WebElement childrenAge = driver.findElement(By.xpath("//select[@class='df-select js-select-child-age']"));
	    Select selectChildrenAge = new Select(childrenAge);
	    selectChildrenAge.selectByVisibleText("4");
	   
	   


	}

	@Given("Click Confirm button and click Search")
	public void clickConfirmButtonAndClickSearch() throws InterruptedException {
		driver.findElementByXPath("//span[text()='Confirm']").click();
		Thread.sleep(500);
		driver.findElementByXPath("//span[text()='Search']").click();
		
	    
	}

	@Given("Select Accommodation type as Hotels only and choose 4 stars")
	public void selectAccommodationTypeAsHotelsOnlyAndChooseStars() throws InterruptedException {
		driver.findElementByXPath("//strong[text()='Accommodation']").click();
		driver.findElementByXPath("//input[@id='acc-type-filter-1']").click();
		Thread.sleep(1000);
		WebElement star= driver.findElementByXPath("//span[text()='4-star hotels']");
		 driver.executeScript("arguments[0].click()", star);
		driver.findElementByXPath("//button[text()='Done']").click();
		
	    
	}

	@Given("Select Guest rating as Very Good")
	public void selectGuestRatingAsVeryGood() {
		driver.findElementByXPath("(//span[@class='filter-item__placeholder'])[2]").click();
		driver.findElementByXPath("//span[text()='Very good']").click();
	}

	@Given("Set Hotel Location as Agra Fort and click Done")
	public void setHotelLocationAsAgraFortAndClickDone() throws InterruptedException {
		 driver.findElementByXPath("(//span[@class='filter-item__placeholder'])[3]").click();
		  
		    WebElement hotelLocation = driver.findElementById("pois");
		    Select hotelLoca = new Select(hotelLocation);
		    hotelLoca.selectByVisibleText("Agra Fort");
		    WebElement action = driver.findElementByXPath("//button[text()='Done']");
		    driver.executeScript("arguments[0].click()", action);
	    
	}

	@When("In more Filters, select Air conditioning, Restaurant and WiFi and click Done")
	public void inMoreFiltersSelectAirConditioningRestaurantAndWiFiAndClickDone() throws InterruptedException {
		driver.findElementByXPath("//span[text()='Select']").click();
		driver.findElementByXPath("//label[text()='Air conditioning']").click();
		driver.findElementByXPath("//label[text()='WiFi']").click();
		driver.findElementByXPath("//button[text()='Show more']").click();
		Thread.sleep(500);
		driver.findElementByXPath("//label[text()='Restaurant']").click();
		driver.findElementByXPath("//button[text()='Done']").click();
	     
	     
	}

	@When("Sort the result as Rating & Recommended")
	public void sortTheResultAsRatingRecommended() {
			WebElement result = driver.findElementById("mf-select-sortby");
		    Select resultsel = new Select(result);
		    resultsel.selectByVisibleText("Rating & Recommended");
		   
	}

	@Then("Print the Hotel name, Rating, Number of Reviews and Click View Deal")
	public void printTheHotelNameRatingNumberOfReviewsAndClickViewDeal() {
		System.out.println("The hotel name is " +driver.findElementByXPath("(//span[@class='item-link name__copytext'])[1]").getText());
		System.out.println("The hotel star is " +driver.findElementByXPath("(//span[@itemprop='ratingValue'])[1]").getText());
		System.out.println("The number of reviews is : "+driver.findElementByXPath("(//span[@class='details-paragraph details-paragraph--rating'])[1]").getText().replaceAll("\\D",""));
		driver.findElementByXPath("(//span[text()='View Deal'])[1]").click();
		
	    
	}

	@Then("Print the URL of the Page")
	public void printTheURLOfThePage() {
		Set<String> winSet = driver.getWindowHandles();
		 List<String> winLis=new ArrayList<String>(winSet);
		 driver.switchTo().window(winLis.get(1));
		 System.out.println("The current URL of the page is : " +driver.getCurrentUrl());


	    
	}

	@Then("Print the Price of the Room and click Choose Your Room")
	public void printThePriceOfTheRoomAndClickChooseYourRoom() {
	     System.out.println("The price of the room is : " +driver.findElementByXPath("(//div[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper'])[1]").getText());
	     driver.findElementByXPath("(//span[@class='bui-button__text'])[1]").click();
	     
	}

	@Then("Click Reserve and I'll Reserve")
	public void clickReserveAndILlReserve() {
	driver.findElementByXPath("(//span[@class='bui-button__text'])[4]").click();
	driver.findElementByXPath("(//span[@class='bui-button__text'])[12]").click();
	}
	
	@And("#And Close the browser")
	public void close()
	{
		driver.quit();
	}
    
	    
	}

	
	 

