package assignmentWeek2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		//set the webdriver for interaction
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

				//create object 
				ChromeDriver driver = new ChromeDriver();
				//launch URL
				driver.get("http://leaftaps.com/opentaps/control/login");
				//Maximize the window
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//enter username & password & click login
				driver.findElementById("username").sendKeys("DemoSalesManager");
				driver.findElementById("password").sendKeys("crmsfa");
				driver.findElementByClassName("decorativeSubmit").click();
				
				//Click on CRM/SFA link-->Leads-->Create Lead
				driver.findElementByLinkText("CRM/SFA").click();
				driver.findElementByLinkText("Leads").click();
				driver.findElementByLinkText("Create Lead").click();
				
				//enter details in craete lead tab
				
				
				driver.findElementByXPath("//input[@id='createLeadForm_firstName']").sendKeys("Kanimozhi");
				driver.findElementByXPath("//input[@id='createLeadForm_lastName']").sendKeys("Murugesan");
				
				//create object for Select class to use it
				Select source = new Select(driver.findElementById("createLeadForm_dataSourceId"));
				source.selectByValue("LEAD_EMPLOYEE");
				
				driver.findElementById("createLeadForm_annualRevenue").sendKeys("1500");
				driver.findElementById("createLeadForm_industryEnumId").sendKeys("Computer Software");

				Select owner = new Select(driver.findElementById("createLeadForm_ownershipEnumId"));
				owner.selectByVisibleText("S-Corporation");
				
				driver.findElementById("createLeadForm_description").sendKeys("Selenium Automation Tester");
				
				Select marCam = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
				marCam.selectByIndex(6);
				
				Select state = new Select(driver.findElementById("createLeadForm_generalStateProvinceGeoId"));
				state.selectByValue("TX");
				
				driver.findElementById("createLeadForm_primaryEmail").sendKeys("kani012@gmail.com");
				driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9109298282");
				
				driver.findElementByXPath("//input[contains(@class,'small')]").click();
				

	}

}
