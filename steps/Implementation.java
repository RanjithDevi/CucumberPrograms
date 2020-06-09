package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
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

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberOptions()
public class Implementation {
	public static ChromeDriver driver;
	 
	 

	@Given("Launch https://www.carwale.com")
	public void launch_https_www_carwale_com() 
	{
	//Launching Chromebrowser
		 System.setProperty("webdriver.chrome.silentOutput", "true");
		 System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	//To disable notifications
		 DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		 ChromeOptions options= new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 options.addArguments("--incognito");
		 capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	     driver=new ChromeDriver(options);
	//Maximize the browser
		 driver.manage().window().maximize();
	//Load the url
		 driver.get("https://www.carwale.com/");
	//Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 
	}

	@And("Click on Used")
	public void click_on_Used() throws InterruptedException
	 {	
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
		Thread.sleep(2000);
	  }

	@Given("Select the City as Chennai")
	public void select_the_City_as_Chennai() throws InterruptedException {
		 
		 driver.findElementByXPath("//input[@placeholder='Type to select city name, e.g. Mumbai']").sendKeys("Chennai,Tamil Nadu");
		 driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
		 Thread.sleep(1000);
		
	}

	@Given("Select budget min 8L and max 12L and Click Search")
	public void select_budget_min_L_and_max_L_and_Click_Search() throws InterruptedException 
	{
		 driver.findElementByXPath("//li[text()='8 Lakh']").click();
		 driver.findElementByXPath("(//li[text()='12 Lakh'])[2]").click();
		 Thread.sleep(1000);
		 driver.findElementByXPath("//button[@id='btnFindCar']").click();
		 Thread.sleep(1000);
	}

	@Given("Select Cars with Photos under Only Show Cars With")
	public void select_Cars_with_Photos_under_Only_Show_Cars_With() throws InterruptedException {
		 
		  driver.executeScript("window.scrollBy(0, 450)");
		 
		  driver.findElementByXPath("(//li[@class='us-sprite'])[1]").click();
		   
		 Thread.sleep(1000);
	     
	}

	@Given("Select Manufacturer as Hyundai --> Creta")
	public void select_Manufacturer_as_Creta() throws InterruptedException {
		
		 
		 driver.executeScript("window.scrollBy(0, 600)");
		 driver.findElementByXPath("//span[text()=' Hyundai ']").click();
		 Thread.sleep(500);			 
		 
		 driver.findElementByXPath("(//span[@class='model-txt'])[1]").click();
		 
		 Thread.sleep(500);	     
	}

	@Given("Select Fuel Type as Petrol")
	public void select_Fuel_Type_as_Petrol() throws InterruptedException {
	 
		driver.findElementByXPath("(//h3[@class='sub-values'])[6]").click();;
		 Thread.sleep(500);
		 
		 driver.findElementByXPath("(//span[text()='Petrol'])[1]").click();;
	}

	@Given("Select Best Match as KM Low to High")
	public void select_Best_Match_as() throws InterruptedException {
		 WebElement sortElement = driver.findElementById("sort");
		 Select sortDD = new Select(sortElement);
		 sortDD.selectByVisibleText("KM: Low to High");
		 Thread.sleep(3000);
		 
	}

	@Then("Validate the Cars are listed with KMs Low to High")
	public void validate_the_Cars_are_listed_with_KMs_Low_to_High() throws InterruptedException {
		
		 List<WebElement> kmList = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
		  
		 List<Integer> intKms = new ArrayList<Integer>();
		 List<Integer> befsort = new ArrayList<Integer>();
		 Thread.sleep(1000);
		 for (int i=0;i<kmList.size();i++)
		 {
			  String putset=kmList.get(i).getText().replaceAll("\\D","").trim();
			  int kms=Integer.parseInt(putset);
			  intKms.add(kms);
			  befsort.add(kms);
			 
		 }	 
		Collections.sort(intKms);
		System.out.println("Before Sorting " +befsort);
		 System.out.println("After Sorting " +intKms);
		 Thread.sleep(1000);
		 if (befsort.equals(intKms))
		    System.out.println("Both the displayed list and sorted list of kms remains the same");
		 else
		 System.out.println("Both the displayed list and sorted list of kms are different");
		 String name;
		 WebElement carlowkm= driver.findElementByXPath("(//span[@class='image-container__gallery-icon slideShow']/following-sibling::span)[1]");
		 driver.executeScript("arguments[0].click()", carlowkm);
		 
		 for (int i=1;i<2;i++)
		 {
			 System.out.println(intKms.get(0));
		
			 name=driver.findElementByXPath("(//span[@class='spancarname card-detail-block__title-text'])[" +i+ "]").getText();
			 System.out.println(name);
			// WebElement carlowkm= driver.findElementByXPath("(//span[@class='image-container__gallery-icon slideShow']/following-sibling::span)[" +i+ "]");
			// js.executeScript("arguments[0].click()", carlowkm);
			 Thread.sleep(2000);
			// driver.executeScript("window.scrollBy((724, 10))");
			
			 Thread.sleep(2000);
			
		 }
		 WebElement wishList = driver.findElementByXPath("//li[@data-action='ShortList&CompareWindow_Click']");
		 driver.executeScript("arguments[0].click()", wishList);
			
		 WebElement moreDetails = driver.findElementByXPath("//a[contains(text(),'More details')]");
		 driver.executeScript("arguments[0].click()", moreDetails);
		 
		 Thread.sleep(3000);
		 
		 Set<String> winSet = driver.getWindowHandles();
		 List<String> winLis=new ArrayList<String>(winSet);
		 driver.switchTo().window(winLis.get(1));
		 
		 Map<String,String> map = new LinkedHashMap<String, String>();
		 List<WebElement> overview =driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//div[@class='equal-width text-light-grey']");
		 List<WebElement> price =driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//div[@class='equal-width dark-text']");
		 for (int i=0;i<overview.size();i++)
		 {
							 
			 map.put(overview.get(i).getText(), price.get(i).getText());
		 }
		 for (Entry<String, String> each : map.entrySet()) {
				System.out.println(each.getKey() + " ---------- " + each.getValue());
			
		}
	 
		 
	}
	    
	@And("Close the browser")
	public void close_the_browser() 
	{
	     driver.close();
	}

	
}
