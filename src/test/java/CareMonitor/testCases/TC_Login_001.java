package CareMonitor.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import CareMonitor.pageObject.Login_Page;


public class TC_Login_001 extends Base_class {
	@Test
	
	public void loginTest () throws IOException
	{
		Login_Page lp = new Login_Page (driver);	
		System.out.println(driver.getTitle());
		
		lp.setUserName (username) ;
		logger.info("entered username");
		
		lp.click_next_btn();
		logger.info("click next");
		
		lp.setPassword (password) ;
	    logger.info("set password");
	    
		
		lp.clickSubmit ( ) ;
		
		logger.info("click submit");
		
		if ( driver.getTitle ( ).equals ("CareMonitor Portaldddddd"))
		{
		
		//logger.info("login testcase is passed");
		Assert.assertTrue (true) ;
//		  test =extent.createTest("login successsful");
		}
		else
		{
		captureScreen(driver,"loginTest");
//		logger.info("login testcase is passed");
		Assert.assertTrue (false) ;
//		 test =extent.createTest("login fail");
		}
	}

}
