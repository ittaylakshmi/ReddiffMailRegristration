package reddiffautomaton;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReddiffAcctCreation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String getTextExpected = "Yippie! The ID you've chosen is available.";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		driver.findElement(By.cssSelector("input[name*='name']")).sendKeys("Bala Krishna Telugu");
		driver.findElement(By.xpath("//input[contains(@name,'login')]")).sendKeys("nanda_2212");
		driver.findElement(By.xpath("//input[contains(@value,'availability')]")).click();
		Thread.sleep(5000);
		String getText=driver.findElement(By.xpath("//div/font/b")).getText();
		System.out.println(getText);
//		By elelocator=By.xpath("//div/font/b");
//		String getText=waitForElementPresent(driver, elelocator, 30).getText();
////		String getText=driver.findElement(By.xpath("//div/font/b")).getText();
		
		if (getText.equalsIgnoreCase(getTextExpected))
		{
			driver.findElement(By.cssSelector("input[id='newpasswd']")).sendKeys("Amaniaaa@0522");
			driver.findElement(By.cssSelector("input[id='newpasswd1']")).sendKeys("Amaniaaa@0522");
			driver.findElement(By.xpath("//table/tbody[1]/tr[1]/td[3]/input")).sendKeys("Amani@gmail.com");
//			driver.findElement(By.xpath("//table/tbody[1]/tr[1]/td[1]/input")).click();
			Thread.sleep(5000);
			driver.findElement(By.cssSelector("input#mobno")).sendKeys("999999999999");
			driver.findElement(By.xpath("//select[contains(@name,'DOB_Day')]/option[6]")).click();
			driver.findElement(By.xpath("//select[contains(@name,'DOB_Month')]/option[7]")).click();
			driver.findElement(By.xpath("//select[contains(@name,'DOB_Year')]/option[44]")).click();
			driver.findElement(By.xpath("//select[contains(@onchange,'show')]/option[219]")).click();
		}
		else 
		{
			System.out.println("Id already Exist. Please Choose New Reddiffmail ID");
		}
	}
	
//	public static WebElement waitForElementPresent(WebDriver driver, By locator, int timeout)
//	{
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		return driver.findElement(locator);
//	}

}
