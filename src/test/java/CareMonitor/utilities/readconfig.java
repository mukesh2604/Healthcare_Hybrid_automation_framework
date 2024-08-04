package CareMonitor.utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

public class readconfig {
	static Properties pro;
	public readconfig() 
	{
		File src = new File("./Configuration/config.properties");
		try {
			
		
		FileInputStream fis =  new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		} catch (Exception e) {
			System.out.println( "exception is" + e);
		}
	}
	
	public String getURL ( )
	{
	String url =pro.getProperty("baseURL") ;
	return url ;
	
	}
	
	public String getusername( )
	{
	String url =pro.getProperty("username") ;
	return url ;
	
	}
	
	public String getpassword( )
	{
	String password =pro.getProperty("password");
	return password ;
	}
	public  String getchromepath( )
	{
	String chromepath =pro.getProperty("chromepath");
	return chromepath ;
	
	}
	public  String getfirefoxpath( )
	{
	String firefox =pro.getProperty("firefoxpath");
	return firefox ;
	
	}
	
}
