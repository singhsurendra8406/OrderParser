package com.orderparser.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.orderparser.model.OutputData;
import com.orderparser.service.OrderParser;

@Component
public class CSVParserImpl implements OrderParser {

	@Override
	public List<OutputData> parser(String inputFileName) {
		
		int counter = 0;
		BufferedReader reader = null;
		String[] values = null;
		List<OutputData> resultList = new ArrayList<>();
		OutputData result = null;
		String mLine;
		 
		try {
			ClassPathResource res = new ClassPathResource(inputFileName);
		    reader = new BufferedReader(
		        new InputStreamReader(res.getInputStream()));
		    
		    //skip column names
		    reader.readLine();
		    while ((mLine = reader.readLine()) != null) {
		    	
		       values = sanitizeData(mLine).split(",");
		       
		       result= new OutputData(Integer.valueOf(values[0]), Float.valueOf(values[1]), values[3], inputFileName, ++counter, "OK");
		       resultList.add(result);
		    }
		} catch (Exception e) {
			e.printStackTrace();
			result= new OutputData(Integer.valueOf(values[0]), Float.valueOf(values[1]), values[3], inputFileName, ++counter, e.getMessage());
			resultList.add(result);
			
		} finally {
		    if (reader != null) {
		         try {
		             reader.close();
		         } catch (IOException e) {
		         }
		    }
		}
		return resultList;
	}
	
	
	private String sanitizeData(String unsanitizedData)
	{
		StringBuffer temp = new StringBuffer(unsanitizedData);
		
		if(unsanitizedData.startsWith("\""))
			temp.deleteCharAt(0);
		if(unsanitizedData.endsWith("\""))
			temp.deleteCharAt(temp.length()-1);
		
		return temp.toString();
	}

}
