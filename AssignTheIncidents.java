package week5.day5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignTheIncidents {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	 ChromeDriver driver=new ChromeDriver();
	 driver.get("https://dev93361.service-now.com");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.switchTo().frame(0);
	 driver.findElement(By.id("user_name")).sendKeys("admin");
	 driver.findElement(By.id("user_password")).sendKeys("Like&Share22");
	 driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	 driver.switchTo().defaultContent();
	 Thread.sleep(3000);
	 WebElement filter = driver.findElement(By.xpath("//input[@id='filter']"));
		filter.sendKeys("Incident");
		Thread.sleep(3000);
		filter.sendKeys(Keys.ENTER);
	driver.switchTo().frame(0);
	WebElement temp = driver.findElement(By.xpath("(//td[@class='vt']/a)[5]"));
	String text = temp.getText();
	System.out.println(text);
	driver.switchTo().defaultContent();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
	
	
	
//	driver.switchTo().frame(0);
//	String attribute = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
//	driver.switchTo().defaultContent();
	Thread.sleep(3000);
	driver.findElement(By.xpath("(//span[text()='Search']//parent::span)[1]")).click();
	WebElement findElement = driver.findElement(By.xpath("//input[@id='sysparm_search']"));
	findElement.sendKeys(text,Keys.ENTER);
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
	driver.switchTo().defaultContent();
	
	String parentWindow = driver.getWindowHandle();
	
	Set<String> group = driver.getWindowHandles();
	List<String> newWindow=new ArrayList<String>(group);
	driver.switchTo().window(newWindow.get(1));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("software",Keys.ENTER);
	WebElement name = driver.findElement(By.xpath("//a[text()='Software']"));
	String text2 = name.getText();
	System.out.println(name);
	name.click();
	driver.switchTo().window(parentWindow);
	
	
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//button[@id='lookup.incident.assigned_to']")).click();
	 driver.switchTo().defaultContent();
	String parent = driver.getWindowHandle();
	Set<String> AssignTo = driver.getWindowHandles();
	List<String> Windownew=new ArrayList<String>(AssignTo);
	driver.switchTo().window(Windownew.get(1));
	driver.manage().window().maximize();
	WebElement groupname = driver.findElement(By.xpath("//a[text()='ITIL User']"));
	String text3 = groupname.getText();
	System.out.println(groupname);
	groupname.click();
	driver.switchTo().window(parent);

	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Clear the error in the web page");
	driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame(0);
	WebElement findElement2 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
	findElement2.sendKeys(text,Keys.ENTER);
	driver.switchTo().defaultContent();
	
	driver.switchTo().frame(0);
	String AssignTo1 = driver.findElement(By.xpath("(//td[@class='vt']//a)[3]")).getText();
	System.out.println(AssignTo1);
	if(text2.equals(AssignTo1))
		System.out.println("software group is Assigned");
	else
		System.out.println("software group is not Assigned");
	String groupname1 = driver.findElement(By.xpath("(//td[@class='vt']//a)[4]")).getText();
	System.out.println(groupname1);
	if(text3.equals(groupname1))
		System.out.println("Assigned");
	else
		System.out.println("Not Assigned");
	driver.switchTo().defaultContent();
	
	
		
	
	
	
	
	
	
	
	
}
}
