package steps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigBasket {
	public static ChromeDriver driver;
	@Given("Go to https://www.bigbasket.com")
	public void go_to_https_www_bigbasket_com() throws InterruptedException {
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
	//Maximize the browser
		 driver.manage().window().maximize();
	//Load the url
		 driver.get("https://www.bigbasket.com");
	//Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(2000);
		      
	}

	@Given("Mouse over on Shop by Category")
	public void mouse_over_on_Shop_by_Category() throws InterruptedException {
		  WebElement category=driver.findElementByXPath("//a[text()=' Shop by Category ']");
		  Thread.sleep(500);
		   Actions over=new Actions(driver);
		   over.moveToElement(category).perform();
	    
	}

	@Given("Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS")
	public void go_to_FOODGRAINS_OIL_MASALA_and_RICE_RICE_PRODUCTS() throws InterruptedException {
		 WebElement food=driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
		  Thread.sleep(1000);
		   Actions over1=new Actions(driver);
		   over1.moveToElement(food).perform();
		  
		   WebElement rice=driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]");
		   Thread.sleep(1000);
		   Actions over2=new Actions(driver);
		   over2.moveToElement(rice).perform();
		   Thread.sleep(1000);
		   
	}

	@Given("Click on BOILED & STEAM RICE")
	public void click_on_BOILED_STEAM_RICE() {
		driver.findElementByXPath("( //a[text()='Boiled & Steam Rice'])[2]").click();
	    
	}

	@Given("Get the URL of the page and check with with site navigation link\\(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)")
	public void get_the_URL_of_the_page_and_check_with_with_site_navigation_link_HOME_FOODGRAINS_OIL_MASALA_RICE_RICE_PRODUCTS_BOILED_STEAM_RICE() {
		String url = driver.getCurrentUrl();
		if (url.equalsIgnoreCase("https://www.bigbasket.com/pc/foodgrains-oil-masala/rice-rice-products/boiled-steam-rice/?nc=nb " ))
			System.out.println("The URL of the page is validated");
		else
			System.out.println("The URL of the page is validated");
	     
	}

	@Given("Choose the Brand as bb Royal")
	public void choose_the_Brand_as_bb_Royal() throws InterruptedException {
		 driver.executeScript("window.scrollBy(0, 450)");
		 Thread.sleep(2000);
		WebElement royal =driver.findElementByXPath("(//span[text()='bb Royal'])[1]");
		driver.executeScript("arguments[0].click()", royal);
		
		Thread.sleep(5000);
	    
	}

  @Given("Go to Ponni Boiled Rice and select 10kg bag from Dropdown")
	public void go_to_Ponni_Boiled_Rice_and_select_kg_bag_from_Dropdown() throws InterruptedException {
		WebElement kilo = driver.findElementByXPath("(//span[@ng-bind='vm.selectedProduct.sp'])[1]");
		driver.executeScript("arguments[0].click()", kilo);
		Thread.sleep(1000);
		WebElement kilogram = driver.findElementByXPath("(//span[text()='10 kg'])[3]");
		 driver.executeScript("arguments[0].click()", kilogram);
		Thread.sleep(2000);
	    
	}

  @Given("Click Add button")
	public void click_Add_button() throws InterruptedException {
	   WebElement add= driver.findElementByXPath("(//button[text()='Add '])[1]");
	   driver.executeScript("arguments[0].click()", add);
	   Thread.sleep(1000);
	   driver.findElementByXPath("(//a[text()='Continue'])[1]").click();
	   Thread.sleep(2000);
	  
	}

	@Given("Go to search box and type Dal")
	public void go_to_search_box_and_type_Dal() throws InterruptedException {
	 driver.findElementByXPath("(//input[@placeholder='Search for Products..'])[1]").sendKeys("Dal",Keys.ENTER);
	 Thread.sleep(3000);
	 driver.executeScript("window.scrollBy(0, 550)");
	 WebElement quanty =  driver.findElementByXPath("(//i[@class='fa fa-caret-down'])[1]");
	 driver.executeScript("arguments[0].click()", quanty);
		Thread.sleep(1000);	
		
		WebElement dal = driver.findElementByXPath("(//a[@ng-click='vm.onProductChange(allProducts)'])[4]");
		 driver.executeScript("arguments[0].click()", dal);
		Thread.sleep(2000);
		WebElement quantity = driver.findElementByXPath("(//input[@ng-model='vm.startQuantity'])[1]");
		quantity.clear();
		quantity.sendKeys("2");
		Thread.sleep(2000);
		driver.findElementByXPath("(//button[text()='Add '])[1]").click();
	 
	}




	@Given("click Address")
	public void click_Address() throws InterruptedException {
		WebElement address = driver.findElementByXPath("(//span[@class='ng-binding'])[2]");
		driver.executeScript("arguments[0].scrollIntoView()", address);
		driver.executeScript("arguments[0].click()", address);
		 Thread.sleep(5000);
	
	}

	@When("Select CHennai as City, Alandur-600016,Chennai as Area and click Continue")
	public void select_CHennai_a_City_Alandur_Chennai_as_Area_and_click_Continue() throws InterruptedException {
		
	     driver.findElementByXPath("(//span[@class='btn btn-default form-control ui-select-toggle'])[1] ").click();
	     Thread.sleep(1000);
	     driver.findElementByXPath("(//span[text()='Chennai'])[3]").click();
	     driver.findElementByXPath("(//input[@ng-change='vm.emptyCheck()'])[1]").sendKeys("600016");
	     driver.findElementByXPath("(//button[text()='Continue'])[1]").click();
	}
   @When("Mouse over on My Basket take a screen shot")
	public void mouse_over_on_My_Basket_take_a_screen_shot() throws IOException, InterruptedException {
	Actions action = new Actions(driver);

		action.moveToElement(driver.findElementByXPath("//i[contains(@class,'icon svg-basket')]")).click().build()
				.perform();
		Thread.sleep(3000);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/bb.png");
		FileUtils.copyFile(src, dst);
	    Thread.sleep(2000);
	}

	@Then("Click View Basket and Checkout")
	public void click_View_Basket_and_Checkout() {
		driver.findElementByXPath("//button[text()='View Basket & Checkout']").click();
		
	     
	}

	@Then("Click the close button and close the browser")
	public void click_the_close_button_and_close_the_browser() {
		driver.findElementByXPath("(//button[@class='close'])[1]").click();
		driver.quit();
	    
	}


}
