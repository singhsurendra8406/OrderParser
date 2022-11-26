package com.orderparser.serviceimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderparser.model.Order;
import com.orderparser.model.OutputData;
import com.orderparser.service.OrderParser;

@Component
public class JsonParserImpl implements OrderParser {

	public List<OutputData> parser(String inputFileName) {
		
		int counter = 0;
		ObjectMapper mapper = new ObjectMapper();
		BufferedReader reader = null;
		Order order = null;
		List<OutputData> resultList = new ArrayList<>();
		OutputData result = null;
		
		try {
			ClassPathResource res = new ClassPathResource(inputFileName);
		    reader = new BufferedReader(
		        new InputStreamReader(res.getInputStream()));
		    
		    // do reading, usually loop until end of file reading 
		    String mLine;
		    while ((mLine = reader.readLine()) != null) {
		    	
		       order = mapper.readValue(mLine, Order.class);
		       result= new OutputData(order.getOrderId(), order.getAmount(), order.getComment(), inputFileName, ++counter, "OK");
		       resultList.add(result);
		    }
		} catch (Exception e) {
			e.printStackTrace();
			result= new OutputData(order.getOrderId(), order.getAmount(), order.getComment(), inputFileName, ++counter, e.getMessage());
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

}
