package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions{
	public ChromeDriver driver;
	@Given("User opens the Chrome browser")
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Given("User loads the production URL")
	public void loadURL()
	{
		driver.get("http://leaftaps.com/opentaps");
	}
	@Given("User maximizes the browser")
	public void maxBrowser()
	{
		driver.manage().window().maximize();
	}
	@Given("User sets the implicitly timeout")
	public void impWait()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Given("User sets the username (.*)  in loginpage")
	public void enterUserName(String data)
	{
		driver.findElementById("username").sendKeys(data);
	}
		
	@Given("User sets the password (.*) in loginpage")
	public void enterPassword(String data)
	{
		driver.findElementById("password").sendKeys(data);
	}
	@When("User clicks the login button in login page")
	public void clickLogin()
	{
		driver.findElementByClassName("decorativeSubmit").click();
	}
	

	@Then("User should be navigated to Leaftaps page")
	public void verifyLogin()
	{
		System.out.println("Login is success");
	}
	
	
	@When("User clicks the CRMSFA link in Leaftaps page")
	public void clickCRMSFA()
	{
		driver.findElementByLinkText("CRM/SFA").click(); 
	}
	@Then("User should be able to navigate to MyHome page")
	public void checkCRMSFA()
	{
		System.out.println("clicked CRMSFA successfully");
	}

	@When("User clicks Leads link in MyHome page")
	public void clickLeads()
	{
		driver.findElementByLinkText("Leads").click();
	}
	@Then("User should be able to navigate to MyLeads page")
	public void verifyMyLeadsPage()
	{
		System.out.println("Logged into MyLeads page successfully");
	}
	@When("User clicks the Create Lead link in MyLeads page")
	public void clickCreateLead()
	{
		driver.findElementByLinkText("Create Lead").click();
	}
	@Then("Create Lead form should be opened in Create Lead page")
	public void verifyCreateLeadPage()
	{
		System.out.println("Create Lead Page dispalyed successfully");
	}
	@Then("User enters the company name (.*)")
	public void enterCompanyName(String data)
	{
	  driver.findElementById("createLeadForm_companyName").sendKeys(data);
	}
	@Then("User enters the first name (.*)")
	public void enterFirstName(String data)
	{
		driver.findElementById("createLeadForm_firstName").sendKeys(data);
	}
	@Then("User enters the last name (.*)")
	public void enterLastName(String data)
	{
		driver.findElementById("createLeadForm_lastName").sendKeys(data);
	}
	@When("User clicks the Create Lead button in CreateLead page")
	public void clickCreateLeadbutton()
	{
		driver.findElementByName("submitButton").click();
	}
	@Then("User should be navigated to View Lead page")
	public void VerifyCreateLead()
	{
		System.out.println("Lead Created and viewed Successfully");
	}

	@But("Create Lead is failiure")
	public void checkFailiure()
	{
		System.out.println("Create Lead is not success");
	}
	}


