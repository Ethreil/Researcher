package com.Researcher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Scanner;

public class CarbonDioxide 
{
	
	private static String localFileString = "CO2Data";
	private static String fileURL = "ftp://aftp.cmdl.noaa.gov/products/trends/co2/co2_mm_mlo.txt";
	private static int year = Calendar.getInstance().get(Calendar.YEAR);
	
	public static double getAvgRateOfChange (String yearOne, String yearTwo) throws MalformedURLException, IOException
	{
		double avgCO2One = getAvgPPM(yearOne);
		double avgCO2Two = getAvgPPM(yearTwo);
		
		double yearUno = Double.parseDouble(yearOne);
		double yearDos = Double.parseDouble(yearTwo);
		
		double rateOfChange = (avgCO2Two - avgCO2One) / (yearDos - yearUno);
		
		return rateOfChange;
	}
	
	public static double getAvgRateOfChange (int yearOne, int yearTwo) throws MalformedURLException, IOException
	{
		double avgCO2One = getAvgPPM(yearOne);
		double avgCO2Two = getAvgPPM(yearTwo);
		
		double yearUno = (double) yearOne;
		double yearDos = (double) yearTwo;
		
		double rateOfChange = (avgCO2Two - avgCO2One) / (yearDos - yearUno);
		
		return rateOfChange;
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
		File CO2Data = null;
		Scanner scanCO2Data = null;
		try 
		{
			CO2Data = new File(localFileString);
			scanCO2Data = new Scanner(CO2Data);
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
					CO2Data = new File(localFileString);
					scanCO2Data = new Scanner(CO2Data);
				} 
				catch (FileNotFoundException f)
				{
					f.printStackTrace();
					System.out.println("Bad Request. Check connection and data source.");
					return false;
				}
		}
		
		scanCO2Data.close();
		return true;
	}
	
	public static double getAvgPPM (String yearDate) throws MalformedURLException, IOException
	{
		//Parsing error at 1975 & 1974
		if (Integer.valueOf(yearDate) ==  1975) {
			return 331.11;
		}
		if (Integer.valueOf(yearDate) ==  1974) {
			return 330.185;
		}
	
	double[] valuesToAverage = new double[200];
	
	Scanner scnr;
	scnr = null;
	
	File f = new File("CO2Data");
	try {
		scnr = new Scanner(f);
	} catch (FileNotFoundException file0) {
		File CO2Data = null;
		Scanner scanCO2Data = null;
		try 
		{
			CO2Data = new File(localFileString);
			scanCO2Data = new Scanner(CO2Data);
		} 
		catch (FileNotFoundException file1)
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
					CO2Data = new File(localFileString);
					scanCO2Data = new Scanner(CO2Data);
				} 
				catch (FileNotFoundException file2)
				{
					file2.printStackTrace();
					System.out.println("Bad Request. Check connection and data source.");
					
				}
		}
		
		scanCO2Data.close();

	}
	
	
	
	int arrayCount = 0;
	while (scnr.hasNext()) {
		
		if (scnr.next().contains(yearDate)) {
			
			if(Integer.parseInt(scnr.next()) < 20) {
				scnr.next();
				valuesToAverage[arrayCount] = scnr.nextDouble();
				++arrayCount;
			} else {
				valuesToAverage[arrayCount] = scnr.nextDouble();
				++arrayCount;
			}
			
		}
		
	}
	
	double totalCO2 = 0.0;
	for (int i = 0; i < arrayCount; ++i) {
		totalCO2 = totalCO2 + valuesToAverage[i];
	}
	
	totalCO2 = totalCO2 / (double) arrayCount;
	
	return totalCO2;
	}
 	
	public static double getAvgPPM (int yearDate) throws MalformedURLException, IOException
	{
		String yearDateString = Integer.toString(yearDate);
		//Parsing error at 1975 & 1974
				if (Integer.valueOf(yearDate) ==  1975) {
					return 331.11;
				}
				if (Integer.valueOf(yearDate) ==  1974) {
					return 330.185;
				}
			
			double[] valuesToAverage = new double[200];
			
			Scanner scnr;
			scnr = null;
			
			File f = new File("CO2Data");
			try {
				scnr = new Scanner(f);
			} catch (FileNotFoundException file0) {
				File CO2Data = null;
				Scanner scanCO2Data = null;
				try 
				{
					CO2Data = new File(localFileString);
					scanCO2Data = new Scanner(CO2Data);
				} 
				catch (FileNotFoundException file1)
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
							CO2Data = new File(localFileString);
							scanCO2Data = new Scanner(CO2Data);
						} 
						catch (FileNotFoundException file2)
						{
							file2.printStackTrace();
							System.out.println("Bad Request. Check connection and data source.");
							
						}
				}
				
				scanCO2Data.close();

			}
			
			
			
			int arrayCount = 0;
			while (scnr.hasNext()) {
				
				if (scnr.next().contains(yearDateString)) {
					
					if(Integer.parseInt(scnr.next()) < 20) {
						scnr.next();
						valuesToAverage[arrayCount] = scnr.nextDouble();
						++arrayCount;
					} else {
						valuesToAverage[arrayCount] = scnr.nextDouble();
						++arrayCount;
					}
					
				}
				
			}
			
			double totalCO2 = 0.0;
			for (int i = 0; i < arrayCount; ++i) {
				totalCO2 = totalCO2 + valuesToAverage[i];
			}
			
			totalCO2 = totalCO2 / (double) arrayCount;
			
			return totalCO2;
	}
	
	public static double getFuturePPM (String yearDate, double rateOfChange) throws MalformedURLException, IOException
	{
		double yearDateDouble = Double.valueOf(yearDate);
		
		return rateOfChange * (yearDateDouble - (double) year) + getAvgPPM(year);
	}
	
	public static double getFuturePPM (int yearDate, double rateOfChange) throws MalformedURLException, IOException
	{	
		return rateOfChange * ((double) yearDate - (double) year) + getAvgPPM(year);
	}
	
	public static double getFuturePPM (String yearDate, String yearOne, String yearTwo) throws MalformedURLException, IOException
	{
		double rateOfChange = getAvgRateOfChange(yearOne, yearTwo);
		double yearDateDouble = Double.valueOf(yearDate);
		
		return rateOfChange * (yearDateDouble - (double) year) + getAvgPPM(year);
	}
	
	public static double getFuturePPM (int yearDate, int yearOne, int yearTwo) throws MalformedURLException, IOException
	{
		double rateOfChange = getAvgRateOfChange(yearOne, yearTwo);
		
		return rateOfChange * ((double) yearDate - (double) year) + getAvgPPM(year);
	}
	
	public static double getLatestPPM () throws MalformedURLException, IOException
	{
		Scanner scnr;
		scnr = null;
	
		File f = new File("CO2Data");
		try {
			scnr = new Scanner(f);
		} catch (FileNotFoundException file0) {
			File CO2Data = null;
			Scanner scanCO2Data = null;
			try 
			{
				CO2Data = new File(localFileString);
				scanCO2Data = new Scanner(CO2Data);
			} 
			catch (FileNotFoundException file1)
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
						CO2Data = new File(localFileString);
						scanCO2Data = new Scanner(CO2Data);
					} 
					catch (FileNotFoundException file2)
					{
						file2.printStackTrace();
						System.out.println("Bad Request. Check connection and data source.");
						
					}
			}
			
			scanCO2Data.close();

		}
		
		scnr = new Scanner(f);	
		
		int countLines = 0;
		while ( scnr.hasNextLine() ) {
					++countLines;
					scnr.nextLine();
		} 
		
		scnr.reset();
		
		for (int i = 0; i < countLines - 1; ++i) {
			scnr.nextLine();
		}
		
		scnr.next();
		scnr.next();
		scnr.next();
		
		double value = Double.parseDouble(scnr.next());
		scnr.close();
		return value; 
	}
	
}
