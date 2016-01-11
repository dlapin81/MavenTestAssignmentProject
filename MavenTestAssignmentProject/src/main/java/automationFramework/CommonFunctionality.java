package automationFramework;

public class CommonFunctionality
{
	public static void GotoPage(String Url)
	{
		Browser.Goto(Url);
	}
	
	public static boolean isAt(String PageTitle)
	{			
		return PageTitle.equals(Browser.getTitle());
	}
	
	public static void EnterKeywordToSearchByID(String EnterSearchKeyword, String SearchElementID)
	{
		Browser.findWebElementById(SearchElementID);
		Browser.searchWebElement(EnterSearchKeyword);
	}

	public static boolean SearchByXPath(String CheckKeyword, String xPath) {
		return CheckKeyword.equals(Browser.returnStringByXPath(xPath));
	}

	public static void SelectValueToSearchByID(String SelectElementByValue, String SearchElementID) {
		Browser.findWebElementById(SearchElementID);
		Browser.selectElementByValue(SelectElementByValue);
	}

	public static boolean OptionIsSelected(String CheckKeyword, String xPath) {
		return Browser.optionSelected(CheckKeyword, xPath);
	}

	public static boolean ElementContainsTextByType(String TextToCheck, String Type, String string) {
		if(Type.toString().equals("XPath"))
		{
			return Browser.returnStringByXPath(string).contains(TextToCheck);			
		}
		else if(Type.toString().equals("id"))
		{
			return Browser.returnStringById(string).contains(TextToCheck);						
		}
		else if(Type.toString().equals("title"))
		{
			return Browser.getTitle().contains(TextToCheck);
		}		
		else
		{
			return false;
		}
	}

	public static void ClickOnElementByXPath(String xPath) {
		Browser.searchWebElementByXPath(xPath);
		Browser.clickOnWebElement();		
	}	
}		

