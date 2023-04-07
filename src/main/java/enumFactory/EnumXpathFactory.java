package enumFactory;

public enum EnumXpathFactory {
	
	/*
	 * Amazon Home Page
	 */
	
	AMAZON_SEARCH_BOX("//input[@type='text']"),
	CLICK_MOBILE_CATEGORY_OPTION("//a[normalize-space()='Mobiles']"),
	CLICK_HELP_BUTTON_AT_BOTTOM("//a[normalize-space()='Help']"),
	CLICK_BESTSELLER_BUTTON("//a[@href='/gp/bestsellers/?ref_=nav_cs_bestsellers']");
	
	
	
	
	private String homePageFuntions;
	private EnumXpathFactory(String homePageFuntions)
	{
		this.homePageFuntions=homePageFuntions;
	}
	
	public String getValue()
	{
		return this.homePageFuntions;
	}


}
