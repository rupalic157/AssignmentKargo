package generic;

public interface AutoConstants {
	
// Constants to be used throughout the project
	
//Driver Paths
	String ChromedriverKey = "webdriver.chrome.driver";
	String ChromedriverPath = "../AssignmentKargo/BrowserDrivers/chromedriver";
	String PROPERTY_PATH = "../AssignmentKargo/src/test/resources/configs.properties";
	String GeckoExe = "webdriver.gecko.driver";
	String GeckoPath = "..";
	String IE_EXE = "webdriver.ie.driver";
	String IE_PATH = "..";
	
//Manual Data For Billing Details
	String FIRSTNAME = "Automation";
	String LASTNAME = "Testing";
	String COMPANYNAME = "Kargo";
	String EMAILID = "automationtesting@company.ie";
	String PHONE = "8888888888";
	String COUNTRY = "India";
	String OTHERCOUNTRY = "Republic of Ireland";
	String ADDRESSFIELD1 = "Somewhere In Mumbai";
	String ADDRESSFIELD2 = "1";
	String CITY = "Mumbai";
	String POSTCODE = "X91X91";
	String STATE = "Maharashtra";
	String ORDERNOTE = "SHIP IT ASAP";
	String PAYMENTOPTION = "cheque";
	
//TestCaseOne variables
	int MIN = 150;
	int MAX = 450;
	
//Page TITLES
	String HOMEPAGE = "Automation Practice Site";
	String SHOPPAGE = "Products – Automation Practice Site";
	String CARTPAGE = "Basket – Automation Practice Site";
	String CHECKOUT = "Checkout – Automation Practice Site";
	
//SORTING Inputs
	String POPULARITY = "Sort by popularity";
	String AVERAGE = "Sort by average rating";
	String NEWNESS = "Sort by newness";
	String LTH = "Sort by price: low to high";
	String HTL = "Sort by price: high to low";
	
}
