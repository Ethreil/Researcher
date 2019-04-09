package com.Researcher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ArcticIce {
		
	private static String localFileString = "ArcticData";
	private static String fileURL = "https://climate.nasa.gov/system/internal_resources/details/original/1270_minimum_extents_and_area_north_SBA_reg_20171001_2_.txt";
	
	public static double getAvgRateOfChange (String yearOne, String yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getAvgRateOfChange (int yearOne, int yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getAvgRateOfChangeOfRateOfChange (String yearOne, String yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getAvgRateOfChangeOfRateOfChange (int yearOne, int yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getAvgRateOfChangeOfRateOfChange (double rateOfChange, String yearOne, String yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getAvgRateOfChangeOfRateOfChange (double rateOfChange, int yearOne, int yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static String getLatestDate ()
	{
		
		
		return "";
	}
	
	public static boolean isLoaded () throws MalformedURLException, IOException
	{
		File arctic = null;
		Scanner scanArctic = null;
		try 
		{
			arctic = new File(localFileString);
			scanArctic = new Scanner(arctic);
		} 
		catch (FileNotFoundException e)
		{
			 BufferedInputStream in = null;
			 FileOutputStream fout = null;
			 try 
			 {
				 in = new BufferedInputStream(new URL(fileURL).openStream());
				 fout = new FileOutputStream(localFileString);
			 
			 	 byte data[] = new byte[1024];
			 	 int count;
			 while ( (count = in.read(data, 0, 1024) ) != -1) 
			 {
				 fout.write(data, 0, count);
			 }
			 } 
			 finally
			 {
				 if (in != null) in.close();
				 if (fout != null) fout.close();
			 }
			 
				try 
				{
					arctic = new File(localFileString);
					scanArctic = new Scanner(arctic);
				} 
				catch (FileNotFoundException f)
				{
					f.printStackTrace();
					System.out.println("Bad Request. Check connection and data source.");
					return false;
				}
		}
		
		scanArctic.close();
		return true;
	}
	
	public static double getExtentMinimum (String yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getExtentMinimum (int yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getAreaMinimum (String yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getAreaMinimum (int yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureExtentMinimum (double rateOfChange, String yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureExtentMinimum (double rateOfChange, int yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureExtentMinimum (String yearOne, String yearTwo, String yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureExtentMinimum (int yearOne, int yearTwo, int yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureAreaMinimum (String yearDate, double rateOfChange)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureAreaMinimum (int yearDate, double rateOfChange)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureAreaMinimum (String yearDate, String yearOne, String yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureAreaMinimum (int yearDate, int yearOne, int yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getLatestExtentMinimum ()
	{
		
		
		return 0.0;
	}
	
	public static double getLatestAreaMinimum ()
	{
		
		
		return 0.0;
	}
	
}
