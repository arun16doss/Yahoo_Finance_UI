package Yahoo_Finance_UI.Yahoo_Finance_UI;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsecaseOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://finance.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("#ybar-sbq")).sendKeys("Tes");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@title='Tesla, Inc.'])[1]")));
		driver.findElement(By.xpath("(//li[@title='Tesla, Inc.'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
//		String teslaTitle=driver.getTitle();
//		
			String stockPrice=driver.findElement(By.xpath("//span[@data-testid='qsp-price']")).getText();
			Float stockPriceNum=new Float(stockPrice);
//			int stockPriceNum=Integer.parseInt(stockPricebeforeDec);
			if(stockPriceNum>200)
			{
				System.out.println("Stock Price is greater than 200");
			}
			else
			{
				System.out.println("Stock Price is lower than 200");
			}
					
			String prevClose=driver.findElement(By.xpath("//span[@title='Previous Close']/following::span[1]")).getText();
			String volume=driver.findElement(By.xpath("//span[@title='Volume']/following::span[1]")).getText();
			System.out.println("Previous Close "+prevClose);
			System.out.println("volume of the day is "+volume);
//			driver.close();
//		}

	}

}
