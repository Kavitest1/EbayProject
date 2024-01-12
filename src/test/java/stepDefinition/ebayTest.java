package stepDefinition;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class ebayTest {
	
	
	public WebDriver driver;
	


@Given("We are on ebay login page")
public void we_are_on_ebay_login_page() {
	
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
	driver.get("https://www.ebay.com/");
	driver.manage().window().maximize();
	
	}


@When("I navigate to search in Cellphones and accessories")
public void i_navigate_to_search_in_cellphones_and_accessories() throws InterruptedException {

	driver.findElement(By.id("gh-shop-a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//li/a[text()=\"Cell phones & accessories\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("a[_sp='p2489527.m4337.l9750.c26']")).click();
	
}


@Then("Add filters appearing in the pop-up and then apply")
public void add_filters_appearing_in_the_pop_up_and_then_apply() throws InterruptedException {
	driver.get("https://www.ebay.com/b/Cell-Phones-Smartphones/9355/bn_320094");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	js.executeScript("window.scrollBy(0,800)");
	Thread.sleep(3000);
	
	driver.findElement(By.className("brm__all-filters")).click();
	Thread.sleep(3000);
	
	js.executeScript("document.querySelector('.x-overlay__wrapper--left').scrollTop=5000");
	
	Thread.sleep(3000);
	
	
	driver.findElement(By.xpath("//div[@data-aspecttitle=\"price\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".x-textrange__input.x-textrange__input--from")).sendKeys("20");
	driver.findElement(By.cssSelector(".x-textrange__input.x-textrange__input--to")).sendKeys("30000");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("div[data-aspecttitle=\"LH_ItemCondition\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//label[@for=\"c3-subPanel-LH_ItemCondition_New_cbx\"]")).click();
	
	driver.findElement(By.xpath("//button[@aria-label=\"Apply\"]")).click();
	Thread.sleep(3000);

}
@Then("Verify that filter tags are applied")
public void verify_that_filter_tags_are_applied() {
	
	
	driver.findElement(By.xpath("//button[@class=\"x-flyout__button\"][1]")).click();
	List<WebElement> li=driver.findElements(By.cssSelector("li.brm__aspect-item--applied a"));
	String[] l= {"Condition: New","Price: $20.00 to $30,000.00"};
	List al=Arrays.asList(l);
	for(int i=0;i<li.size();i++)
	{
	String s=li.get(i).getText();
	System.out.println(s);
	if(al.contains(s))
	{
	Assert.assertTrue(true);
	}
	
	}
}




@When("We search a string in search bar")
public void we_search_a_string_in_search_bar() {

	driver.findElement(By.className("gh-tb")).sendKeys("Macbook");
	driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
	driver.findElement(By.id("gh-cat-box")).click();
	
	}


@When("Change the search bar")
public void change_the_search_bar() throws InterruptedException {
	Select s=new Select(driver.findElement(By.id("gh-cat")));
	s.selectByValue("58058");
	driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
	Thread.sleep(2000);

}


@Then("verify the page loads")
public void verify_the_page_loads() {

String title=driver.getTitle();	
Assert.assertEquals(title, "Macbook in Computers/Tablets & Networking for sale | eBay");
System.out.println(title);
}


@Then("Verify the search criteria")
public void verify_the_search_criteria() {

	String s=driver.findElement(By.xpath("//div[@class='s-item__title']/span/span")).getText();
	System.out.println(s);
	String[] st=s.split(" ");
	List al=Arrays.asList(st);
	if(al.contains(s))
	{
		Assert.assertTrue(true);
	}
}


}
