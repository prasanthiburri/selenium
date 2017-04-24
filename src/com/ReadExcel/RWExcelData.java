package com.ReadExcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import library.ExcelDataConfig;

public class RWExcelData {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		        //System.out.println(excel.getData(0,0,1));
        //System.out.println(excel.getData(0,0,1));
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SamJo\\Desktop\\java sw\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		FirefoxDriver Driver=new FirefoxDriver();
		ExcelDataConfig excel = new ExcelDataConfig("C:\\Users\\SamJo\\Desktop\\java sw\\excel data\\TestData.xlsx");
		//-----------------------------------------------------------
		        String surl=excel.getData(0,0,0);
		        String sUN=excel.getData(0,0,1);
				String sPWD=excel.getData(0,0,2);
				
		//------------------------------------------------------
		
		//Open application
		Driver.get(surl);
		//wait for 2 sec
		Thread.sleep(2000);
		//Verify home page
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Home Page displayed");
		}
		else
		{
			System.out.println("Failed to open home page");
			return;
		}
		//--------------------------------------------
		//Create elements for user name,password,login and clear
		WebElement objUN=Driver.findElement(By.name("txtUserName"));
		WebElement objPWD=Driver.findElement(By.name("txtPassword"));
		WebElement objLogin=Driver.findElement(By.name("Submit"));
		WebElement objClear=Driver.findElement(By.name("clear"));
		//-----------------------------------------------
		//Verify user name
		if(objUN.isDisplayed())
		{
			System.out.println("User name diplayed");
		}
		else
		{
			System.out.println("Failed to display");
			return;
		}
		//Verify password
		if(objPWD.isDisplayed())
		{
			System.out.println("Password diplayed");
		}
		else
		{
			System.out.println("Failed to display");
			return;
		}
		//Verify Login and clear
		if(objLogin.isDisplayed() && objClear.isDisplayed())
		{
			System.out.println("Login and clear diplayed");
		}
		else
		{
			System.out.println("Failed to display");
			return;
		}
				
		//Login to orangeHRM
		objUN.clear();
		objUN.sendKeys(sUN);
		objPWD.clear();
		objPWD.sendKeys(sPWD);
		objLogin.click();
		//wait for 2 seconds
		Thread.sleep(2000);
		//Verify home page
		if(Driver.getTitle().equals("OrangeHRM"))
		{
			System.out.println("OrangeHRM Page displayed");
		}
		else
		{
			System.out.println("Failed to login");
			return;
		}	
		//Create elements for Change password and Logout
		WebElement objCP=Driver.findElement(By.linkText("Change Password"));
		WebElement objLogout=Driver.findElement(By.linkText("Logout"));	
		//Verify Change Password & Logout
		if(objCP.isDisplayed() && objLogout.isDisplayed())
		{
			System.out.println("Change Password & Logout are displayed");
		}
		else
		{
			System.out.println("Failed to display");
			return;
		}
		//--------------------------------------------------------
		//Click on logout
		objLogout.click();
		//wait for 2 sec
		Thread.sleep(2000);
		//Verify home page
		if(Driver.getTitle().equals("OrangeHRM - New Level of HR Management"))
		{
			System.out.println("Signoff sucessfull & Home Page displayed");
		}
		else
		{
			System.out.println("Failed to Signoff");
			return;
		}
		//-------------------------------------------------
		Driver.close();
		Driver.quit();
	}

        
        
	}


