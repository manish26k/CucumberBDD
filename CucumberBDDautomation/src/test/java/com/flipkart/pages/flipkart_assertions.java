package com.flipkart.pages;


import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.flipkart.base.flipkart_createdriver;

public class flipkart_assertions extends flipkart_createdriver
{
	 //public static ResourceBundle bundle;
	 public static boolean Validatepagetitle( WebDriver driver, String expTitle)
	  {
		 boolean result=false;
		 
		 System.out.println(driver);
		 System.out.println(driver.getTitle());
		 System.out.println(expTitle);
		 if(driver.getTitle().trim().contains(expTitle.trim()))
		 {
			 result=true;
		 }
		 return result;
	  }
	  
	 public static boolean ValidateFeaturebrandtext( WebDriver driver, String locType, String locValue)
	   {
	 	  boolean result=false;
	 	  
	 	  try
	 	  {
	 		 System.out.println("**Enter in the try block**");
	 		 System.out.println(driver.findElement(By.xpath(locValue)).isDisplayed());
	 		 if(locType.equalsIgnoreCase("xpath"))
	 		 {
	 			 result= driver.findElement(By.xpath(locValue)).isDisplayed();
	 			 //System.out.println("Feature brand Heading title is displayed");
	 		 }
	 		 
	 	 }
	 	  catch(Exception e)
	 	  {
	 		 System.out.println("**Didn't enter in try block**");  
	 	  }
	 	  return result;
	   }
	 
	 public static boolean ValidateRandom2ndprod( WebDriver driver, String locType, String locValue)
	   {
	 	  boolean result=false;
	 	 
	 	 try
	 	  {
	 		System.out.println("--Enter in the try block--");
	 		 if(locType.equalsIgnoreCase("xpath"))
	 		 {
	 			 result= driver.findElement(By.xpath(locValue)).isDisplayed();
	 			 System.out.println("Random2ndprod is displayed");
	 		 }
	 		 
	 	 }
	 	  catch(Exception e)
	 	  {
	 		 System.out.println("--Didn't enter in try block---");  
	 	  }
	 	  return result;
	   } 
	 
	 public static boolean ValidatePRODaddedinCART( WebDriver driver, String locType, String locValue)
	   {
	 	  boolean result=false;
	 	 
	 	 try
	 	  {
	 		System.out.println("&&Enter in the try block&&");
	 		 if(locType.equalsIgnoreCase("xpath"))
	 		 {
	 			 result= driver.findElement(By.xpath(locValue)).isDisplayed();
	 			 System.out.println("Product is added into the cart");
	 		 }
	 		 
	 	 }
	 	  catch(Exception e)
	 	  {
	 		 System.out.println("&&Didn't enter in try block&&");  
	 	  }
	 	  return result;
	   } 
	 
	 /*public static boolean flipkart_searchPageURL( WebDriver driver, String expURL)
	   {
	 	 boolean result=false;
	 	 
	 	 System.out.println("*************");
	 	 
	 	 System.out.println(driver.getCurrentUrl());
	 	 System.out.println(expURL);
	 	 if(driver.getCurrentUrl().equalsIgnoreCase(expURL))
	 	 {
	 		 result=true;
	 	 }
	 	 return result;
	   }*/
	 
	

	
	
}
