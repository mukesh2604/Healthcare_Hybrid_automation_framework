package CareMonitor.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import CareMonitor.utilities.readconfig;

public class Base_class {
	readconfig readfile = new readconfig();
	public String baseURL=readfile.getURL();
	public String username=readfile.getusername();
	public String password=readfile.getpassword();
	public static WebDriver driver;
	
	public static Logger logger;
	@Parameters("browser")
	@BeforeClass
	
	public void setup(String br)
	{			

		logger = Logger.getLogger("CareMonitor_v1");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome"))
			{
				try {
					System.setProperty("webdriver.chrome.driver",readfile.getchromepath());
					driver=new ChromeDriver();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if(br.equals("firefox"))
				try {
					{
						System.setProperty("webdriver.gecko.driver",readfile.getfirefoxpath());
						driver = new FirefoxDriver();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			
		
		
		driver.get ( baseURL ) ;
		logger.info("url is opened");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		
		
		
	}

	@AfterClass
	private void tearDown() {
		// TODO Auto-generated method stub
		
		driver.quit();
		
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
}
