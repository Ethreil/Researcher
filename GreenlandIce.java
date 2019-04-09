package com.Researcher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class GreenlandIce {
	
	private static String localFileString = "GreenlandData";
	private static String fileURL = "ftp://podaac-ftp.jpl.nasa.gov/allData/tellus/L3/mascon/RL05/JPL/CRI/mass_variability_time_series/greenland_mass_200204_201706.txt";

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
		File greenland = null;
		Scanner scanGreenland = null;
		try 
		{
			greenland = new File(localFileString);
			scanGreenland = new Scanner(greenland);
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
					greenland = new File(localFileString);
					scanGreenland = new Scanner(greenland);
				} 
				catch (FileNotFoundException f)
				{
					f.printStackTrace();
					System.out.println("Bad Request. Check connection and data source.");
					return false;
				}
		}
		
		scanGreenland.close();
		return true;
	}
	
	public static double getAvgIceMassVariation (String yearDate)
	{
		
		
		return 0.0;
	
	}
	
	public static double getAvgMassVariation (int yearDate)
	{
		
		
		return 0.0;
	
	}
	
	public static double getFutureIceMassVariation (String yearDate, double rateOfChange)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureIceMassVariation (int yearDate, double rateOfChange)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureIceMassVariation (String yearDate, String yearOne, String yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureIceMassVariation (int yearDate, int yearOne, int yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getLatestIceMassVariation ()
	{
		
		
		return 0.0;
	}

}
