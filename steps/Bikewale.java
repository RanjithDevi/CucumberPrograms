package steps;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Bikewale {
	public static ChromeDriver driver;
	@Given("Goto https://www.bikewale.com/")
	public void goto_https_www_bikewale_com() throws InterruptedException {
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
		 driver.get("https://www.bikewale.com/");
	//Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(2000);
	     
	}

	@Given("Go to menu and click new bikes")
	public void go_to_menu_and_click_new_bikes() throws InterruptedException {
		driver.findElementByXPath("//span[@class='navbarBtn nav-icon']").click();
		Thread.sleep(1000);
	    driver.findElementByXPath("//span[text()='New Bikes']").click();;
	    Thread.sleep(1000);
	}

	@Given("Click New Bikes Then compare bikes")
	public void click_New_Bikes_Then_compare_bikes() {
		driver.findElementByXPath("//a[text()='Compare Bikes']").click();
	      
	}

	@Given("Add first bike as Royal Enfield and model as Thunderbird 350")
	public void add_first_bike_as_Royal_Enfield_and_model_as_Thunderbird( ) throws InterruptedException {
		driver.findElementByXPath("(//span[@class='box-label'])[1]").click();
		 Thread.sleep(500);
		driver.findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[1]").click();
		driver.findElementByXPath("//li[text()='Royal Enfield']").click();
		driver.findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[2]").click();
		driver.findElementByXPath("//li[text()='Thunderbird 350']").click();
	     
	}

  @Given("Add second bike Jawa, model as 42 and version Dual Channel ABS - BS VI")
	public void add_second_bike_Jawa_model_as_and_version_Dual_Channel_ABS_BS_VI() throws InterruptedException {
	  driver.findElementByXPath("(//span[@class='add-icon'])[2]").click();
	  Thread.sleep(500);
	  driver.findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[4]").click();
	  Thread.sleep(500);
	  driver.findElementByXPath("(//li[text()='Jawa'])[2]").click();
	  driver.findElementByXPath("(//div[contains(@class,'chosen-container chosen-container-single')])[5]").click();
	  Thread.sleep(500);
	  driver.findElementByXPath("//li[text()='42']").click();
	  driver.findElementByXPath("(//select[@class='chosen-select select-type-version']/following-sibling::div)[2]").click();
	  Thread.sleep(500);
	  driver.findElementByXPath("//li[text()='Dual Channel ABS - BS VI']").click();
	    
	}

	@Given("Add bike brand Kawasaki model as Ninja 300")
	public void add_bike_brand_Kawasaki_model_as_Ninja( ) throws InterruptedException {
		driver.findElementByXPath("(//span[@class='box-label'])[3]").click();
		driver.findElementByXPath("(//select[@class='chosen-select select-type-brand']/following-sibling::div)[3]").click();
		Thread.sleep(500);
		driver.findElementByXPath("(//li[text()='Kawasaki'])[3]").click();
		driver.findElementByXPath("(//select[@class='chosen-select select-type-model']/following-sibling::div)[3]").click();
		Thread.sleep(500);
		driver.findElementByXPath("//li[text()='Ninja 300']").click();
	     
	}

	@When("Click compare")
	public void click_compare() {
		driver.findElementByXPath("//button[@id='btnCompare']").click();
	   
	}

	@Then("Find and print the maximum overall rating of all the bikes and find the max")
	public void find_and_print_the_maximum_overall_rating_of_all_the_bikes_and_find_the_max() {
		Map<String,String> map = new LinkedHashMap<String, String>();
		List<WebElement> name = driver.findElementsByXPath("//a[@class='item-target-link underline-none ']//p");
		List<WebElement> rating = driver.findElementsByXPath("//span[@class='font20 font-bold']");
		for (int i=0;i<name.size();i++)
		{
			map.put(name.get(i).getText(), rating.get(i).getText());
		}
		 for (Entry<String, String> each : map.entrySet()) {
				System.out.println(each.getKey() + " ---------- " + each.getValue());
			
		}
	    List<Double> rate=  new ArrayList<Double>();
	    for (int j=0;j<rating.size();j++)
	    {
	    	System.out.println(Double.parseDouble(rating.get(j).getText()));
	    	rate.add(Double.parseDouble(rating.get(j).getText()));
	    }
	    System.out.println("Ratings : " +rate);
	    Collections.sort(rate);
	    System.out.println("\n All Ratings after sorting : " +Collections.max(rate));
	}
}
