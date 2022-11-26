package com.orderparse.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import com.orderparser.model.OutputData;
import com.orderparser.service.OrderParser;
import com.orderparser.serviceimpl.CSVParserImpl;
import com.orderparser.serviceimpl.JsonParserImpl;

public class ParsingUtil {
	
	@Autowired
	private static ResourceLoader resourceLoader;
	
	enum FILE_TYPE
	{
		JSON("JSON"),
		CSV("CSV");
		
		private String value;
		
		FILE_TYPE(String value)
		{
			this.value = value;
		}
		
		public static FILE_TYPE fromString(String text) {
	        for (FILE_TYPE ft : FILE_TYPE.values()) {
	            if (text.toLowerCase().contains(ft.value.toLowerCase())) {
	                return ft;
	            }
	        }
	        return null;
	    }
	}

	
	
	public static void parseData(String[] fileNameArray) throws IOException
	{
		List<OutputData> completeResult = new ArrayList<>();
		OrderParser parser = null;;
		
		for(String fileName : fileNameArray)
	    {
			
		//	ClassPathResource res = new ClassPathResource(fileName);
			//res.getInputStream(
		//	File file = res.getFile();;//new File(ParsingUtil.class.getClassLoader().getResource(fileName).getFile());//res.getFile();
			//FileReader r = new FileReader(new File("/orders1.csv"));
			switch(FILE_TYPE.fromString(fileName))
			{
				case JSON:
					parser= new JsonParserImpl();
					break;
			    case CSV:
			    	parser= new CSVParserImpl();
			    	break;
			    default : 
			    	break;
			}	
			
			if(Objects.nonNull(parser))
				completeResult.addAll(parser.parser(fileName));
		     
		}
		if(Objects.nonNull(completeResult))
			printResult(completeResult);
	}
	
	private static void printResult(List<OutputData> resultList)
	{
		resultList.stream().forEach(System.out::println);
	}
}
