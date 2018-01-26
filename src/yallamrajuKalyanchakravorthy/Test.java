package yallamrajuKalyanchakravorthy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");// It provides link between Selenium Test Case and Chrome Browser
		WebDriver driver=new ChromeDriver(); // Create chrome driver in selenium webdriver interface
		driver.get("http://www.amazon.com"); // launches the amazon site in chrome browser
		driver.manage().window().maximize(); //Maximize the chrome wimdow

		Select dropdown=new Select(driver.findElement(By.id("searchDropdownBox")));//Handling dropdown web element 
		dropdown.selectByVisibleText("Books");
		driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']")).sendKeys("Nike"); //Handling text area web element
		driver.findElement(By.tagName("input")).click(); //Handling button
		driver.findElement(By.tagName("h2")).click(); //Selecting the First book from the list of books
		String textarea1=driver.findElement(By.xpath(".//*[@id='a-autoid-6-announce']/span[2]/span")).getText(); // Capturing the Price of the hardcover edition
		System.out.println(textarea1);

		String elementtype=driver.findElement(By.id("add-to-cart-button")).getAttribute("type");
		String elementname=driver.findElement(By.id("add-to-cart-button")).getAttribute("value");
		System.out.println(elementtype);
		System.out.println(elementname);
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.xpath(".//*[@id='hlb-view-cart-announce']")).click();

		String textarea2=driver.findElement(By.xpath(".//*[@id='sc-subtotal-amount-activecart']/span")).getText();//Capturing the price related to subtotal amount
		System.out.println(textarea2);

		//Assert that the Subtotal amount matches the hardcover price from the product page

		if(textarea1.equals(textarea2)){
			System.out.println("Subtotal amount matches with the price of the hardcover edition");
			
		}
		else{
			System.out.println("Amount varies");
		}
		driver.close();
	}

}
