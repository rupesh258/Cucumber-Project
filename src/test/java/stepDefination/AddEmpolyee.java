package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddEmpolyee {
	String beforeid;
	String afterid;
	WebDriver driver;

	@Given("^user navigates url \"([^\"]*)\"$")
	public void user_navigates_url(String appUrl) throws Throwable {
		System.setProperty("webdriver.chrome.driver","E:\\Testing file\\New folder\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appUrl);
	    
	}

	@When("^user logs as username \"([^\"]*)\" and logs as password \"([^\"]*)\"$")
	public void user_logs_as_username_and_logs_as_password(String username, String password) throws Throwable {
		
		 driver.findElement(By.name("txtUsername")).sendKeys(username);
		  driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user click login button$")
	public void user_click_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();
	}

	@When("^user click pim button$")
	public void user_click_pim_button() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
	}

	@When("^user click add button$")
	public void user_click_add_button() throws Throwable {
		driver.findElement(By.name("btnAdd")).click();
	}

	@When("^user Enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Enter_and_and(String fname, String mname, String lname) throws Throwable {
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("middleName")).sendKeys(mname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
	}

	@When("^user capture emid$")
	public void user_capture_emid() throws Throwable {
	   beforeid =driver.findElement(By.name("employeeId")).getAttribute("value");
	}

	@When("^user click save button$")
	public void user_click_save_button() throws Throwable {
		driver.findElement(By.id("btnSave")).click();
	}

	@When("^user capture emid after save$")
	public void user_capture_emid_after_save() throws Throwable {
		afterid=driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']")).getAttribute("value");
	}

	@Then("^user valid emid$")
	public void user_valid_emid() throws Throwable {
	   if (beforeid.equals(afterid)) {
		   System.out.println("Emp Added success::"+beforeid+"    "+afterid);
		
	} else {
		System.out.println("Emp Added fail::"+beforeid+"    "+afterid);

	}
	}

	@Then("^user close Browser$")
	public void user_close_Browser() throws Throwable {
	    driver.close();
	}

}
