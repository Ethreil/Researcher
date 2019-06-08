package com.Researcher;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;

import org.json.JSONException;

public class Driver {

	public static void main (String[] args) throws MalformedURLException, IOException, JSONException
	{
		int year = Calendar.getInstance().get(Calendar.YEAR);
		/*
		System.out.println(ArcticIce.isLoaded());
		System.out.println(CarbonDioxide.isLoaded());
		System.out.println(GlobalTemperature.isLoaded());
		System.out.println(AntarcticIce.isLoaded());
		System.out.println(GreenlandIce.isLoaded());
		System.out.println(SeaLevel.isLoaded());
		
		
		System.out.println(CarbonDioxide.getAvgPPM(1959));
		System.out.println(GlobalTemperature.isLoaded());
		System.out.println(GlobalTemperature.getAvgLandOceanTemperatureIndex("1880"));
		System.out.println(GlobalTemperature.getAvgRateOfChangeFromCarbonDioxide());
		
		
		System.out.println(GlobalTemperature.getFutureLandOceanTemperatureIndex("2030"));
		System.out.println(CarbonDioxide.getAvgRateOfChange(2017, 2018));
		System.out.println(CarbonDioxide.getAvgRateOfChange(2010, 2017));
		System.out.println(CarbonDioxide.getAvgRateOfChange(1980, 2000));
		
		
		System.out.println(ArcticIce.getFutureExtentMinimum(2040));
		System.out.println(ArcticIce.getFutureAreaMinimum(2040));
		
		
		CarbonDioxide.generateJSONFilePastValues();
		CarbonDioxide.generateJSONFileCurrentValue();
		CarbonDioxide.generateJSONFileFutureValues(CarbonDioxide.getAvgRateOfChange(year - 2, year - 1));
		
		GlobalTemperature.generateJSONFilePastValues();
		GlobalTemperature.generateJSONFileCurrentValue();
		GlobalTemperature.generateJSONFileFutureValues();
		
		ArcticIce.generateJSONFileExtentPastValues();
		ArcticIce.generateJSONFileExtentCurrentValue();
		ArcticIce.generateJSONFileExtentFutureValues();
		ArcticIce.generateJSONFileAreaPastValues();
		ArcticIce.generateJSONFileAreaCurrentValue();
		ArcticIce.generateJSONFileAreaFutureValues();
		*/

	}
}
