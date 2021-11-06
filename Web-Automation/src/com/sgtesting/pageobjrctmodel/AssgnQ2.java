package com.sgtesting.pageobjrctmodel;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AssgnQ2 {
	
	public static WebDriver oBrowser=null;
	public static ActiTimePage oPage=null;

	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
		minimizeFlyOutWindow();
		createUser();
		deleteUser();
		logout();
		closeApplication();
	}
	static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "F:\\ExampleAutomation\\Automation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oPage=new ActiTimePage(oBrowser);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	static void navigate()
	{
		try
		{

			oBrowser.navigate().to("http://localhost:82/login.do");
			oBrowser.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	static void login()
	{
		try
		{
			oPage.getUserName().sendKeys("admin");
			oPage.getPassword().sendKeys("manager");
			oPage.getLogin().click();
			Thread.sleep(4000);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	
	static void minimizeFlyOutWindow()
	{
		try
		{
			oPage.getFlyOutWindow().click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}
	}
	static void createUser()
	{
		try
		{
			oPage.getUsers().click();
			Thread.sleep(2000);
			oPage.getAddusers().click();
			Thread.sleep(2000);
			oPage.getFirstname().sendKeys("Viraj");
			oPage.getLastname().sendKeys("Kuppast");
			oPage.getEmail().sendKeys("viraj@2017");
			oPage.getUsername().sendKeys("R.K");
			oPage.getpassword().sendKeys("2021");
			oPage.getRtpassword().sendKeys("2021");
			oPage.getCreateUser().click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();	
		}
	}
	static void deleteUser()
	{
		try
		{
			oPage.getdeleteUser().click();
			Thread.sleep(3000);
			oPage.getDeleteUser().click();
			Thread.sleep(3000);
			Alert oAlert=oBrowser.switchTo().alert();
			String str=oAlert.getText();
			System.out.println(str);
			oAlert.accept();
			Thread.sleep(3000);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		static void logout()
		{
			try
			{
				oPage.getLogout().click();
				Thread.sleep(2000);
			}catch(Exception e)
			{
				e.printStackTrace();		
			}
		}
		
		static void closeApplication()
		{
			try
			{
				oBrowser.quit();
			}catch(Exception e)
			{
				e.printStackTrace();		
			}
		}
	}
