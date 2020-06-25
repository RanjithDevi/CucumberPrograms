package steps;

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

public class Lenskart {

	public static ChromeDriver driver;
	@Given("Goto https://www.lenskart.com/")
	public void goto_https_www_lenskart_com() throws InterruptedException {
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
		 driver.get("https://www.lenskart.com/");
	//Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(2000);
	     
	}

	@Given("Mouseover on Contact Lenses")
	public void mouseover_on_Contact_Lenses() throws InterruptedException {
		   WebElement lens=driver.findElementByXPath("(//a[@href='/contact-lenses.html'])[1]");
		   Actions over=new Actions(driver);
		   over.moveToElement(lens).perform();
		//   Thread.sleep(500);
	}

	@Given("Click on Monthly under Explore By Disposability")
	public void click_on_Monthly_under_Explore_By_Disposability() {
		driver.findElementByXPath("//div[@id='cssmenu']/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/span[1]").click();
	    
	}

	@Given("Select brand as Aqualens")
	public void select_brand_as_Aqualens() {
		driver.findElementByXPath("//span[text()='Aqualens(10)']").click();
	   
	}

	@Given("Click on the first product")
	public void click_on_the_first_product() {
		driver.findElementByXPath("(//img[@class='img-responsive'])[1]").click();
	  
	}

	@When("Click Buy Now")
	public void click_Buy_Now() throws InterruptedException {
	  WebElement buy= driver.findElementByXPath("//button[text()='BUY NOW']");
	  driver.executeScript("arguments[0].click()", buy);
	  Thread.sleep(1000);
	}

	@Then("Select No of boxes as 2 and Power as -1 for both eyes")
	public void select_No_of_boxes_as_and_Power_as_for_both_eyes( ) throws InterruptedException {
		
		WebElement theme = driver.findElementByName("boxes");
		Thread.sleep(500);
	    Select seltheme = new Select(theme);
	    seltheme.selectByVisibleText(" 2 Box"); 
	    
	    driver.findElementByXPath("(//span[text()='Please Select'])[1]").click();
	    driver.findElementByXPath("//div[text()='-1.00']").click();
	    
	    WebElement theme1 =driver.findElementByXPath("(//select[@name='boxes'])[2]");
		Thread.sleep(500);
	    Select seltheme1 = new Select(theme1);
	    seltheme1.selectByVisibleText("2 Box"); 
		Thread.sleep(500);
		
	    driver.findElementByXPath("(//div[@class=' dropdown-display cl-dd'])[2]").click();
	    driver.findElementByXPath("//div[text()='-1.00']").click();
	    
	    
	   
	}

	@Then("Type your name in User's name")
	public void type_your_name_in_User_s_name() {
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys("RanjithDevi");
	    
	}

	@Then("And click Save and continue")
	public void and_click_Save_and_continue() {
		driver.findElementByXPath("(//button[contains(@class,'submit-btn submit-btn')])[1]").click();
	     
	}

	@Then("Print total amount and click Proceed to Checkout")
	public void print_total_amount_and_click_Proceed_to_Checkout() {
		String total = driver.findElementByXPath("//div[@class='margin-t0 f14']").getText();
		System.out.println("Total Amount is : Rs. "+ total);
	    
	}

}
