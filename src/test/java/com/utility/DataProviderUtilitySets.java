package com.utility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUtilitySets extends DataProviderExcel{
	
	/*
	 * This utlity calls the method from DataProviderClass (return DataProviderExcel.getData("login");)
	 *  we can create number of DATAPROVIDERS we have to just change the sheetName from whichever sheet you want to fetch the Data
	 */
	
	@DataProvider
	public String[][] loginTestData() throws EncryptedDocumentException, IOException
	{
		return DataProviderExcel.getData("login");
	}
	
	@DataProvider
	public String[][] createAccountData() throws EncryptedDocumentException, IOException
	{
		return DataProviderExcel.getData("accountcreation");
	}
	
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		DataProviderUtilitySets h = new DataProviderUtilitySets();
		h.createAccountData();
		
	}
	
	
	
	
	
	

}
