package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//Example of usage PageFactory & FindBy & How libraries
public class SortedPage {
	
	static WebDriver driver;
	static WebElement sort;
	
	@FindBy(how=How.ID, using="sort")
	static WebElement sortAlternativeVariable;
	
	public SortedPage(WebDriver driver)
	{
		PageFactory.initElements(driver, SortedPage.class);
		
		//select "Price: High to Low" in option menu
		//PageFactory is in use for variable 'sort'
		Select firstDroplist = new Select(sort);   
		firstDroplist.selectByValue("price-desc-rank");
		
		//select "Price: Low to High" in option menu
		//FindBy and How libraries are in use for variable 'sortAlternativeVariable'
		Select secondDroplist = new Select(sortAlternativeVariable);  
		secondDroplist.selectByValue("price-asc-rank");
		SortedPage.driver = driver;
	}
}
