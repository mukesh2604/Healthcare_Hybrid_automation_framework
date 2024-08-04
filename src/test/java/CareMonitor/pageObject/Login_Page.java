package CareMonitor.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver Idriver ;
	
	public Login_Page ( WebDriver rdriver )
	{
	Idriver = rdriver ;
	
	PageFactory.initElements ( rdriver , this ) ;
    }

	
	@FindBy ( name = "userName" )
	@CacheLookup
	WebElement txtUserName ;
	
	@FindBy ( xpath = "//*[@id=\"login-middle\"]/form/div/div[3]/button" )
	@CacheLookup
	WebElement next_btn ;
	
	
	@FindBy ( xpath = "/html/body/app-root/main/app-login/div/div/div/div[2]/form/div/div[3]/input" )
	@CacheLookup
	WebElement txtPassword ;
	
	@FindBy ( xpath = "//*[@id=\"login-middle\"]/form/div/div[5]/button")
	@CacheLookup
	WebElement btnLogin ;
	
	public void setUserName ( String uname )
	{
	txtUserName.sendKeys ( uname ) ;
	}
	
	public void click_next_btn()
	{
		next_btn.click();
	}
	
	
	public void setPassword ( String pwd )
	{
	txtPassword.sendKeys ( pwd ) ;
	}
	
	
	public void clickSubmit ( )
	{
	btnLogin.click ( ) ;
	}
}
