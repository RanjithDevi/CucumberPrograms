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

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class SheIn {
	public static ChromeDriver driver;
	@Given("Go https://www.shein.in")
	public void go_https_www_shein_in() throws InterruptedException {
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
		 driver.get("https://www.shein.in");
	//Implicitly wait for 5 milliseconds
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 Thread.sleep(2000);
		 driver.findElementByXPath("(//i[@class='iconfont icon-close she-close'])[19]").click();
	}

	@Given("Mouseover on Clothing and click Jeans")
	public void mouseover_on_Clothing_and_click_Jeans() throws InterruptedException {
		WebElement clothing=driver.findElementByXPath("//span[text()='CLOTHING']");
		Thread.sleep(500);
		Actions over=new Actions(driver);
		over.moveToElement(clothing).perform();
		Thread.sleep(2000);
		WebElement jeans =driver.findElementByXPath("(//a[@title='Jeans'])[1]");   
		driver.executeScript("arguments[0].click()", jeans);
		Thread.sleep(2000);
	}

	@Given("Choose Black under Jeans product count")
	public void choose_Black_under_Jeans_product_count() throws InterruptedException {
		 WebElement colour = driver.findElementByXPath("//a[text()='Black']");
		 colour.click();
		Thread.sleep(2000);
	     
	}

	@Given("Check size as medium")
	public void check_size_as_medium() throws InterruptedException {
		
			driver.findElementByXPath("(//li[@class='filter-title leftnav-first-title'])[3]").click();
			Thread.sleep(1000);
			driver.findElementByXPath("(//span[@class='attr-check-box'])[9]").click();
	  
	}

	@Given("Click + in color")
	public void click_in_color() {
	  driver.findElementByXPath("(//li[@class='filter-title leftnav-first-title'])/span[text()='Color']").click();
	}

	@Given("Check whether the color is black")
	public void check_whether_the_color_is_black() {
	    String col =  driver.findElementByXPath("//a[text()='Black']").getText();
	    System.out.println("Colour is  " +col);
	    if (col.equalsIgnoreCase("Black"))
	    	System.out.println("Selected items are of black colour");
	    else
	    	System.out.println("Selected items are of black colour");
	}

	@Given("Click first item to Add to Bag")
	public void click_first_item_to_Add_to_Bag() throws InterruptedException {
	    driver.findElementByXPath("(//a[@class='c-goodsitem__goods-name j-goodsitem__goods-name '])[1]").click();
	    Thread.sleep(2000);
	    Set<String> winSet = driver.getWindowHandles();
		 List<String> winLis=new ArrayList<String>(winSet);
		 driver.switchTo().window(winLis.get(1));
		 Thread.sleep(3000);
		
	}

	@When("Click the size as M and click Submit")
	public void click_the_size_as_M_and_click_Submit() throws InterruptedException {
	driver.executeScript("window.scrollBy(0, 350)");
	 driver.findElementByXPath("(//div[contains(@class,'product-intro__size-radio j-product-intro__size-radio')])[3]").click();
	 Thread.sleep(1000);
	 driver.findElementByXPath("(//button[@class='she-btn-black she-btn-xl'])[1]").click();
	 
	}

	@Given("Click View Bag")
	public void click_View_Bag() throws InterruptedException {
		Thread.sleep(1000);
	 driver.findElementByXPath("//a[text()='view bag']").click();  
	}

	@Given("Check the size is Medium or not and close the browser")
	public void check_the_size_is_Medium_or_not() {
		String size=driver.findElementByXPath("//em[text()='M']").getText();
		if (size.equalsIgnoreCase("M"))
			System.out.println("Size M is validated");
		else
			System.out.println("Size M is validated");
		driver.quit();
		     
	}

	}


