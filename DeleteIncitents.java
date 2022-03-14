package week5.day5;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncitents {
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
			filter.sendKeys("Incidents");
			Thread.sleep(3000);
			filter.sendKeys(Keys.ENTER);
			driver.switchTo().frame(0);
			
//			List<WebElement> num = driver.findElements(By.xpath("//td[@class='vt']//a"));
//			int size =num.size();
//			System.out.println(size);
//			for (int i = 1; i < size; i++) {
//				
//				
//				String text = driver.findElement(By.xpath("//div[@id='incident_list']//tr["+i+"]//td[@class='vt'][1]")).getText();
//				//System.out.println(text);
//				}
//			Thread.sleep(3000);
//			String text = driver.findElement(By.xpath("//td[@class='vt']//a[text()='INC0010020']")).getText();
//			System.out.println(text);
			
			driver.findElement(By.xpath("//td[@class='vt']//a[text()='INC0010019']")).click();
			String attribute = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
			System.out.println(attribute);
			driver.findElement(By.xpath("(//button[text()='Delete'])[1]")).click();
			driver.findElement(By.xpath("//button[@id='ok_button']")).click();
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(0);
			Thread.sleep(3000);
			WebElement findElement = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
			findElement.sendKeys(attribute,Keys.ENTER);
			driver.switchTo().defaultContent();
			
			driver.switchTo().frame(0);
			String text2 = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
			String incident="No records to display";
			
			if(text2.matches(incident))
				System.out.println("incident is  deleted");
			else
				System.out.println("incident is not deleted");
	}
			}


