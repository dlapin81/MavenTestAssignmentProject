package cucumberTest;

import automationFramework.Browser;
import automationFramework.CommonFunctionality;
import utility.ConstantAmazon;
//import pageObjects.HomePage;
//import pageObjects.SortedPage;
//import pageObjects.ProductPage;

import static org.junit.Assert.*;
import org.junit.*;

import cucumber.api.java.en.*;
import cucumber.api.java.Before;
import cucumber.api.java.After;


@SuppressWarnings("unused")
public class FirstTestCaseStepDefinition {
	
	@Before("@OpenBrowser")
	public void init()
	{
		//Nothing here
	}
	
	@Given("^I open \"([^\"]*)\"$")
	//######## HomePage ########
	//Action: Go to home page
	public void I_openHomePage(String url)
	{
		CommonFunctionality.GotoPage(url);
		//Verify (with title) that correct url is opened
		Assert.assertTrue("Provided title cannot be found on web page!", CommonFunctionality.isAt(ConstantAmazon.HomePageTitle));
	}

	@Given("^I select \"([^\"]*)\" from option menu$")
	//######## SortedPage ########
	//Action: Sort results by selected choice "*******"
	public void I_selectItemFromOptionMenu(String selectItem) throws InterruptedException
	{
		if(selectItem.equals("Price: High to Low"))
		{
			CommonFunctionality.SelectValueToSearchByID("price-desc-rank", "sort");
			Thread.sleep(3000);
		}
		else
		{
			Assert.fail("Given parameter for I_selectItemFromOptionMenu(), \"" + selectItem + "\", does not exist in option menu!\n");
		}
	}
	
	@Given("^I select \"([^\"]*)\" product$")
	//######## SortedPage ########
	//Select product by the number "*******" of the list items (li[*])
	public void I_selectProduct(String productNumber)
	{
		if(productNumber.equals("second"))
		{
			CommonFunctionality.ClickOnElementByXPath(ConstantAmazon.LinkToSecondProduct);
		}
		else
		{
			Assert.fail("Given parameter for I_selectProduct(), \"" + productNumber + "\", is not implemented or incorrect!\n");
		}
	}
	
	@When("^I enter \"([^\"]*)\" in search textbox$")
	public void I_enterKeywordToSearchTextbox(String searchKeyword) {
		//######## HomePage ########
		//Action: Enter keyword to webElement found by ID.
		CommonFunctionality.EnterKeywordToSearchByID(searchKeyword, "twotabsearchtextbox");		
	}
	
	@Then("^I should get page title and search result info bar updated as \"([^\"]*)\"$")	
	public void I_should_get_correct_result(String expectedResult) {
		//######## SearchPage ########
		//Verify (with title) that search is done successfully
		Assert.assertTrue("Searched keyword cannot be found on the page title!", CommonFunctionality.ElementContainsTextByType(expectedResult, "title", "title"));

        //Additional verification that search is done successfully
		Assert.assertTrue("Searched keyword cannot be found on the search result info bar!", CommonFunctionality.SearchByXPath("\"" + expectedResult + "\"", ConstantAmazon.SearchResultsInfoBar));
	}
	
	@Then("^I should get option menu \"([^\"]*)\" selected$")	
	public void I_should_get_option_menu_selected(String expectedResult) {
        //Verify that option ******* is selected in options menu
		Assert.assertTrue("Option \"" + expectedResult + "\" is NOT selected!", CommonFunctionality.OptionIsSelected(expectedResult, ConstantAmazon.PriceHighToLowOption));
	}	
	
	@Then("^I should get product topic as \"([^\"]*)\"$")	
	public void I_should_get_product_topic_as(String expectedResult) {
		//######## ProductPage ########
        //Verify that product topic cointains text "*******"
		Assert.assertTrue("Product topic DOES NOT contain text \"" + expectedResult + "\"!", CommonFunctionality.ElementContainsTextByType(expectedResult, "id", "productTitle"));
	}		

	@And("^I should get information bar updated to \"([^\"]*)\"$")
	public void I_should_get_info_bar_updated(String expectedResult) {
        //Verify that "Showing most relevant results sorted by *******" text is visible on the page
		Assert.assertTrue("Option \"" + expectedResult + "\" is NOT selected!", CommonFunctionality.ElementContainsTextByType(expectedResult, "XPath", ConstantAmazon.SortedResultsInfoBar) && CommonFunctionality.ElementContainsTextByType(expectedResult, "XPath", ConstantAmazon.SortedResultsInfoBar));
	}	
	
	@After("@CloseBrowser")
	public void closeBrowser()
	{
		Browser.Close();
	}
}
