package CareMonitor.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import CareMonitor.pageObject.Login_Page;
import CareMonitor_v1.*;

public class TC_LoginDDT_001 extends Base_class {
	@Test(dataProvider="LoginData")
	public void loginDDT(String user , String pwd)
	{
		Login_Page lp=new Login_Page(driver);
		lp.setUserName (user) ;
		logger.info("entered username");
		
		lp.click_next_btn();
		logger.info("click next");
		
		lp.setPassword (pwd) ;
	    logger.info("set password");
	    
		
		lp.clickSubmit ( ) ;
		
		logger.info("click submit");
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/CareMonitor/testData/data_driven_testing.xlsx";
		
		int rownum=CareMonitor.utilities.XLUtils.getRowCount(path, "Sheet1");
		int colcount=CareMonitor.utilities.XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=CareMonitor.utilities.XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

	
	
}
