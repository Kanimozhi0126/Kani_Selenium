package assignmentWeek2;


import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

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
		
		driver.findElementByLinkText("Email").click();
		driver.findElementByName("emailAddress").sendKeys("kani012@gmail.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		//drilldown the first lead#
		Thread.sleep(3000); // this is used as a wait time to load the first record and then click on it
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();
		
		//Fetch the lead number and store it in a variable before deleting it
		String leadvalue = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(leadvalue);
		
		String leadID = leadvalue.replaceAll("[^0-9]","");
		System.out.println(leadID);
		//click on delete and on findLeads
		driver.findElementByClassName("subMenuButtonDangerous").click();
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//enter the Lead Id and check if its deleted and no record found is printed on the screen
		
		driver.findElementByXPath("//input[@name='id']").sendKeys(leadID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		
	}

}
