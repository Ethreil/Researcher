package com.Researcher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class GlobalTemperature {
	
	private static String localFileString = "TemperatureData";
	private static String fileURL = "https://data.giss.nasa.gov/gistemp/graphs/graph_data/Global_Mean_Estimates_based_on_Land_and_Ocean_Data/graph.txt";

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
		File globalTemp = null;
		Scanner scanGlobalTemp = null;
		try 
		{
			globalTemp = new File(localFileString);
			scanGlobalTemp = new Scanner(globalTemp);
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
					globalTemp = new File(localFileString);
					scanGlobalTemp = new Scanner(globalTemp);
				} 
				catch (FileNotFoundException f)
				{
					f.printStackTrace();
					System.out.println("Bad Request. Check connection and data source.");
					return false;
				}
		}
		
		scanGlobalTemp.close();
		return true;
	}
	
	public static double getAvgLandOceanTemperatureIndex (String yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getAvgLandOceanTemperatureIndex (int yearDate)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureLandOceanTemperatureIndex (String yearDate, double rateOfChange)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureLandOceanTemperatureIndex (int yearDate, double rateOfChange)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureLandOceanTemperatureIndex (String yearDate, String yearOne, String yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getFutureLandOceanTemperatureIndex (int yearDate, int yearOne, int yearTwo)
	{
		
		
		return 0.0;
	}
	
	public static double getLatestFutureLandOceanTemperatureIndex ()
	{
		
		return 0.0;
	}
	
}
