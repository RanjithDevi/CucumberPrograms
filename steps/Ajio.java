package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Ajio {
	public static ChromeDriver driver;
	 
	@Given("Go to https://www.ajio.com")
	public void go_to_https_www_ajio_com() throws InterruptedException 
	{
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
		 driver.get("https://www.ajio.com/shop/women");
	//Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(2000);
		// driver.findElementByXPath("//button[text()='Allow Location']").click();
		// Thread.sleep(5000);
	}

	@Given("Mouseover on Women, CATEGORIES and click on Kurtas")
	public void mouseover_on_Women_CATEGORIES_and_click_on_Kurtas() throws InterruptedException {
	     WebElement women=driver.findElementByXPath("(//a[text()='WOMEN'])[1]");
		 Thread.sleep(3000);
		 Actions over=new Actions(driver);
		 over.moveToElement(women).perform();
		 
		 WebElement category=driver.findElementByXPath("( //a[text()='CATEGORIES'])[1]");
		 Thread.sleep(3000);
		 Actions over1=new Actions(driver);
		 over1.moveToElement(category).perform();
		 
		 driver.findElementByXPath("(//a[text()='Kurtas'])[2]").click();
		 Thread.sleep(5000);
		 
		 
	}

	@Given("Click on Brands and choose Ajio")
	public void click_on_Brands_and_choose_Ajio() throws InterruptedException {
		 
		 driver.executeScript("window.scrollBy(0, 250)");
		 Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='brands']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//label[@class='facet-linkname facet-linkname-brand facet-linkname-AJIO']").click();
		Thread.sleep(5000);
	}

	@Given("Check all the results are Ajio")
	public void check_all_the_results_are_Ajio() {
		int s=0;
		List<WebElement> ajio = driver.findElementsByXPath("//div[@class='brand']");
		System.out.println("Number of items : "+ajio.size());
		for (WebElement eachvalue : ajio)
        {
			String name=eachvalue.getText();
			System.out.println(name);
			if (name.equalsIgnoreCase("AJIO"))
				s=1;
				break;
		}
		if (s==1)
			System.out.println("All the brands displayed are Ajio");
		else
			System.out.println("All the brands displayed are not  Ajio");
			
	}

	@Given("Set Sort by the result as Discount")
	public void set_Sort_by_the_result_as_Discount() throws InterruptedException 
	{
		WebElement sort = driver.findElementByXPath("//span[@class='ic-Chevron-down']");
		driver.executeScript("arguments[0].click()", sort);
		Thread.sleep(500);
		driver.findElementByXPath("//option[text()='Discount']").click();
		

	   
	}

	@When("Select the Color and click ADD TO BAG")
	public void select_the_Color_and_click_ADD_TO_BAG() throws InterruptedException {
	     driver.findElementByXPath("(//div[@class='name'])[1]").click();
	     Thread.sleep(2000);
	     Set<String> winSet = driver.getWindowHandles();
		 List<String> winLis=new ArrayList<String>(winSet);
		 driver.switchTo().window(winLis.get(1));
		driver.findElementByXPath("//img[@class='swatch-image swatch-image-selected']").click();
		Thread.sleep(500);
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		
		 

	}

 @Then("Verify the error message Select your size to know your estimated delivery date")
	public void verify_the_error_message_Select_your_size_to_know_your_estimated_delivery_date() {
	 String error =driver.findElementByXPath("//span[@class='edd-pincode-msg-details']").getText();
		if (error.equalsIgnoreCase("Select your size to know your estimated delivery date."))
			System.out.println("The error message is displayed");
		else
			System.out.println("The error message is not displayed");
		 
	}

	@Then("Select size and click ADD TO BAG")
	public void select_size_and_click_ADD_TO_BAG() throws InterruptedException 
	{
		driver.findElementByXPath("(//div[@class='circle size-variant-item size-instock '])[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("603103");
		Thread.sleep(2000);
		
	}

	@Then("click on Enter pin-code to know estimated delivery date")
	public void click_on_Enter_pin_code_to_know_estimated_delivery_date() throws InterruptedException {
		driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
		Thread.sleep(2000);
	}

	@Then("Print the message and click Go to  Bag")
	public void print_the_message_and_click_Go_to_Bag() throws InterruptedException {
		System.out.println(driver.findElementByXPath("//ul[@class='edd-message-success-details']").getText());
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		Thread.sleep(2000);
		
        driver.findElementByXPath("//div[text()='PROCEED TO BAG']").click();
	    
	}

	@Then("Click on Proceed to Shipping and close the browser")
	public void click_on_Proceed_to_Shipping_and_close_the_browser() {
	driver.findElementByXPath("//button[text()='Proceed to shipping']").click();
	driver.quit();
	    
	}


	}
