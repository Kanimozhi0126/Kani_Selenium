package assignmentWeek3;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//import org.apache.commons.math3.analysis.function.Add;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailList {

	public static void main(String[] args) throws InterruptedException{
	//set the property for webdriver connection
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

	//create object 
	ChromeDriver driver = new ChromeDriver();
	
	//launch URL
	driver.get("https://erail.in/");
	
	//Maximize the window
	driver.manage().window().maximize();
	
	//check on 'sort on date' checkbox
	driver.findElementByXPath("//input[@id='chkSelectDateOnly']").click();
	
	//clear from and to station that is defaulted and enter the details newly	
	driver.findElementByXPath("//input[@id='txtStationFrom']").clear();
	driver.findElementByXPath("//input[@id='txtStationFrom']").sendKeys("Chennai",Keys.TAB);
	
	driver.findElementByXPath("//input[@id='txtStationTo']").clear();
	driver.findElementByXPath("//input[@id='txtStationTo']").sendKeys("Delhi", Keys.ENTER); 
	
	Thread.sleep(3000);
	
	//create an empty Set 
	Set<String> set = new TreeSet<String>();
	
	//get the list of trains available in the site for your search
	List<WebElement> trainNames = driver.findElementsByXPath("//td[@style=';']");
	
	//Get the List size
	int listSize = trainNames.size();
	System.out.println("Size of the List is : " + listSize);
	
	System.out.println("********");
	
	for (WebElement eachTrain : trainNames) {
		
		System.out.println(eachTrain.getText()); //prints all the train names in the List one by one
		set.add(eachTrain.getText()); // adding the List to empty Set created earlier
	}
	
	int setSize = 0;
	System.out.println("********");
	for (String setTrains : set) {
		setSize = set.size();
		System.out.println(setTrains);
		System.out.println("Size of the Set is : " +setSize);
	}
	
	if(setSize == listSize)
	{
	
	System.out.println("No duplicate Trains found");
	}
	else
		System.out.println("Duplicate trains found");
	}

}
 