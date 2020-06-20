package assignmentWeek2;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		//set the webdriver for interaction
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		//create object 
		ChromeDriver driver = new ChromeDriver();
		//launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Maximize the window
		driver.manage().window().maximize();
		//enter username & password & click login
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		//Click on CRM/SFA link-->Leads-->Find Lead
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Find Leads").click();
		
		//enter company name
		driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("TestLeaf");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(3000); 
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();		
		driver.findElementByClassName("subMenuButton").click(); // cicking edit
		
		//get the value of the company field before editing
		String compName = driver.findElementByXPath("(//input[@name='companyName'])[2]").getAttribute("value");
		System.out.println(compName);
		
		//updating the company name
		driver.findElementByXPath("(//input[@name='companyName'])[2]").clear();
		driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("TestLeaf");
		driver.findElementByXPath("(//input[@class='smallSubmit'])[1]").click();
		
		
	}

}
