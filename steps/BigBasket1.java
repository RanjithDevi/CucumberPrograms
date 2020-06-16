
package steps;

 
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigBasket1 {
	 
private Hooks hooks;
	
	public BigBasket1(Hooks hooks) {
		this.hooks = hooks;
	}

	@Given("Go to https://www.bigbasket.com")
	public void go_to_https_www_bigbasket_com() throws InterruptedException {
		hooks.getDriver().get("https://www.bigbasket.com/");
   	    Thread.sleep(2000);
		      
	}

	@Given("Mouse over on Shop by Category")
	public void mouse_over_on_Shop_by_Category() throws InterruptedException {
		  WebElement category=hooks.getDriver().findElementByXPath("//a[text()=' Shop by Category ']");
		  Thread.sleep(500);
		  Actions over=new Actions(hooks.getDriver());
		  over.moveToElement(category).perform();
	    
	}

	@Given("Go to Beverages and Fruit juices & Drinks")
	public void go_to_Beverages_and_Fruit_juices_Drinks() throws InterruptedException {
		WebElement food=hooks.getDriver().findElementByXPath("(//a[text()='Beverages'])[2]");
		  Thread.sleep(1000);
		   Actions over1=new Actions(hooks.getDriver());
		   over1.moveToElement(food).perform();
	  
	}

	@Given("Click on JUICES")
	public void click_on_JUICES() throws InterruptedException {
		WebElement juices=hooks.getDriver().findElementByXPath("(//a[text()='Fruit Juices & Drinks'])[2]");
		Thread.sleep(1000);
		Actions over2=new Actions(hooks.getDriver());
		over2.moveToElement(juices).perform();
		Thread.sleep(2000);
	  
	     
	}

	@Given("Click Tropicana and Real under Brand")
	public void click_Tropicana_and_Real_under_Brand() throws InterruptedException {
		hooks.getDriver().findElementByXPath("(//a[text()='Juices'])[2]").click();
		Thread.sleep(1000);
		hooks.getDriver().findElementByXPath("(//span[text()='Real'])[1]").click();
		Thread.sleep(2000);
		
		
		
	   
	}

	@Given("Check count of the products from each Brands and total count")
	public void check_count_of_the_products_from_each_Brands_and_total_count() throws InterruptedException {
	String real = hooks.getDriver().findElementByXPath("( //h2[@class='ng-binding'])[3]").getText().replaceAll("\\D", "").trim();
		Thread.sleep(3000);
		int realno = Integer.parseInt(real);
		System.out.println("Real brand count is " +realno);
		Thread.sleep(2000);
		hooks.getDriver().findElementByXPath("(//span[text()='Tropicana'])[1]").click();
		Thread.sleep(2000);
		String tropic = hooks.getDriver().findElementByXPath("( //h2[@class='ng-binding'])[3]").getText().replaceAll("\\D", "").trim();
		Thread.sleep(3000);
		int tropicnono = Integer.parseInt(tropic);
		System.out.println("Tropicano brand count is " +tropicnono);
		Thread.sleep(3000);
		String total = hooks.getDriver().findElementByXPath("( //h2[@class='ng-binding'])[3]").getText().replaceAll("\\D", "").trim();
		int totalno = Integer.parseInt(total);
		int finaltot = realno + tropicnono ;
		System.out.println("Total count of Real and Tropicana is " +finaltot);
	   
	}

	@Given("Check whether the products is availabe with Add button.")
	public void check_whether_the_products_is_availabe_with_Add_button() {
		List<WebElement> products = hooks.getDriver().findElementsByXPath("//button[@class='btn btn-add col-xs-9']");
	    List<WebElement> add = hooks.getDriver().findElementsByXPath("//button[text()='Add ']");
	    int n=0, a=0;
	    for (WebElement each : products) {
	    	    	
	    	if (each.getText().equalsIgnoreCase("ADD"))
	    	{
	    		 
	    		a=a+1;
		    }
	    	if (each.getText().equalsIgnoreCase("NOTIFY ME"))
	    	{
	    		 
	    		n=n+1;
				
	    	}
	    	
		}
	    System.out.println("Number of products with ADD button " +a);
	    System.out.println("Number of products with NOTIFY ME  button " +n);
	    
	}

	@Given("Add the First listed available product")
	public void add_the_First_listed_available_product() throws InterruptedException {
		String prodname = hooks.getDriver().findElementByXPath("(//div[@class='col-sm-12 col-xs-7 prod-name'])[1]").getText();
		System.out.println("First Available product is \n " +prodname);
		hooks.getDriver().findElementByXPath("(//button[@class='btn btn-add col-xs-9'])[3]").click();
		Thread.sleep(2000);
		//hooks.getDriver().findElementByXPath("(//a[text()='Change Location'])[1]").click();
	     
	}

	@Given("Click on Change Address")
	public void click_on_Change_Address() throws InterruptedException {
		WebElement address = hooks.getDriver().findElementByXPath("(//a[text()='Change Location'])[1]");
		hooks.getDriver().executeScript("arguments[0].click()", address);
		//hooks.getDriver().executeScript("arguments[0].scrollIntoView()", address);
				 Thread.sleep(5000);
		 
	    
	}

	@Given("Select CHennai as City, Alandur,Chennai as Area  and click Continue")
	public void select_CHennai_as_City_Alandur_Chennai_as_Area_and_click_Continue() throws InterruptedException {
		 hooks.getDriver().findElementByXPath("(//span[@class='btn btn-default form-control ui-select-toggle'])[1] ").click();
	     Thread.sleep(1000);
	     hooks.getDriver().findElementByXPath("(//span[text()='Chennai'])[3]").click();
	     hooks.getDriver().findElementByXPath("(//input[@ng-change='vm.emptyCheck()'])[1]").sendKeys("600016");
	     hooks.getDriver().findElementByXPath("(//button[text()='Continue'])[1]").click();
	     
	}

	@Given("Mouse over on My Basket print the product name. count and price")
	public void mouse_over_on_My_Basket_print_the_product_name_count_and_price() throws InterruptedException {
	   WebElement basket=hooks.getDriver().findElementByXPath("//span[text()='My Basket']");
		  Thread.sleep(500);
		  Actions overs=new Actions(hooks.getDriver());
		  overs.moveToElement(basket).perform();
		  String name = hooks.getDriver().findElementByXPath("//div[@class='product-name']").getText();
		  System.out.println("\n Product name  : "+name);
		  String quantity = hooks.getDriver().findElementByXPath("(//div[@qa='pcsMB'])[1]").getText();
		  String juiceQuantity = quantity.substring(0, 1);
		  System.out.println("\n Product quantity  : "+juiceQuantity);
		  String price = hooks.getDriver().findElementByXPath("//span[@ng-bind='cartItem.mrp']").getText();
		  System.out.println("\n Product price   :  Rs."+price);
		  
	
	
	}

	@When("Click View Basket and Checkout")
	public void click_View_Basker_and_Checkout() throws InterruptedException {
	   hooks.getDriver().findElementByXPath("//button[text()='View Basket & Checkout']").click();
	   Thread.sleep(2000);
	   
	}
	@Then("Click the close button and close the browser")
	public void quit() throws InterruptedException
	{
		hooks.getDriver().findElementByXPath("(//button[@class='close'])[1]").click();
		Thread.sleep(2000);
		hooks.getDriver().quit();
	}
}


