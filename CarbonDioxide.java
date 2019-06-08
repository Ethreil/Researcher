package com.Researcher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONValue;

public class CarbonDioxide 
{
	
	private static String localFileString = "CO2Data";
	private static String fileURL = "ftp://aftp.cmdl.noaa.gov/products/trends/co2/co2_annmean_mlo.txt";
	private static Scanner scanCO2;
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
		if(!isLoaded()) 
		{
			return -1.0;
		}
		File CO2File = new File(localFileString);
		scanCO2 = new Scanner(CO2File);
		
		while (scanCO2.hasNextLine())
		{
			if (scanCO2.next().equals(yearDate))
			{
				return Double.parseDouble(scanCO2.next());
			}
		}
		
		return -1.0;
	}
 	
	public static double getAvgPPM (int yearDate) throws MalformedURLException, IOException
	{
		if(!isLoaded()) 
		{
			return -1.0;
		}
		File CO2File = new File(localFileString);
		scanCO2 = new Scanner(CO2File);
		
		while (scanCO2.hasNextLine())
		{
			if (scanCO2.next().equals(Integer.toString(yearDate)))
			{
				return Double.parseDouble(scanCO2.next());
			}
		}
		
		return -1.0;
	}
	
	public static double getFuturePPM (String yearDate, double rateOfChange) throws MalformedURLException, IOException
	{
		double yearDateDouble = Double.valueOf(yearDate);
		
		return rateOfChange * (yearDateDouble - (double) (year - 1)) + getAvgPPM(year - 1);
	}
	
	public static double getFuturePPM (int yearDate, double rateOfChange) throws MalformedURLException, IOException
	{	
		return rateOfChange * ((double) yearDate - (double) (year - 1)) + getAvgPPM(year - 1);
	}
	
	public static double getFuturePPM (String yearDate, String yearOne, String yearTwo) throws MalformedURLException, IOException
	{
		double rateOfChange = getAvgRateOfChange(yearOne, yearTwo);
		double yearDateDouble = Double.valueOf(yearDate);
		
		return rateOfChange * (yearDateDouble - (double) (year - 1)) + getAvgPPM(year - 1);
	}
	
	public static double getFuturePPM (int yearDate, int yearOne, int yearTwo) throws MalformedURLException, IOException
	{
		double rateOfChange = getAvgRateOfChange(yearOne, yearTwo);
		
		return rateOfChange * ((double) yearDate - (double) (year - 1)) + getAvgPPM(year - 1);
	}
	
	public static double getLatestPPM () throws MalformedURLException, IOException
	{
		if(!isLoaded()) 
		{
			return -1.0;
		}
		
		File CO2File = new File(localFileString);
		scanCO2 = new Scanner(CO2File);
		
		int countLines = 0;
		while (scanCO2.hasNextLine())
		{
			scanCO2.nextLine();
			++countLines;
		}
		
		scanCO2.reset();
		scanCO2 = new Scanner(CO2File);
		
		for (int i = 0; i < countLines - 1; ++i)
		{
			scanCO2.nextLine();
		}
		
		scanCO2.next();
		return Double.parseDouble(scanCO2.next());
	}
	
	public static int getLatestYearInData () throws MalformedURLException, IOException
	{
		isLoaded();
		
		File CO2File = new File(localFileString);
		scanCO2 = new Scanner(CO2File);
		
		int countLines = 0;
		while (scanCO2.hasNextLine())
		{
			scanCO2.nextLine();
			++countLines;
		}
		
		scanCO2.reset();
		scanCO2 = new Scanner(CO2File);
		
		for (int i = 0; i < countLines - 1; ++i)
		{
			scanCO2.nextLine();
		}
		
		
		return Integer.parseInt(scanCO2.next());
	}
	
	public static void generateJSONFilePastValues () throws IOException, JSONException
	{
		JSONObject pastData = new org.json.JSONObject();
		
		for (int i = 1959; i < year ; i = i + 4)
		{
			String intI = Integer.toString(i);
			
			pastData.put(intI, getAvgPPM(intI) );
		}
		
		File file = new File("pastCO2Data.json");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
	 	JSONValue.writeJSONString(pastData, fileWriter);
		fileWriter.close();
	}
	
	public static void generateJSONFileCurrentValue () throws MalformedURLException, JSONException, IOException
	{
		int latestYear = getLatestYearInData();
		
		String yearString = Integer.toString(latestYear);
		JSONObject currentData = new org.json.JSONObject();
		
		currentData.put(yearString, getLatestPPM());
		
		File file = new File("currentCO2Data.json");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
	 	JSONValue.writeJSONString(currentData, fileWriter);
		fileWriter.close();
	}
	
	public static void generateJSONFileFutureValues (double rateOfChange) throws MalformedURLException, JSONException, IOException
	{
		int latestYear = getLatestYearInData();
		JSONObject futureData = new org.json.JSONObject();
		
		for (int i = latestYear + 4; i < 2070 ; i = i + 4)
		{
			String intI = Integer.toString(i);
			
			futureData.put(intI, getFuturePPM(intI, rateOfChange) );
		}
		
		File file = new File("futureCO2Data.json");
		file.createNewFile();
		FileWriter fileWriter = new FileWriter(file);
	 	JSONValue.writeJSONString(futureData, fileWriter);
		fileWriter.close();
	}
	
}
