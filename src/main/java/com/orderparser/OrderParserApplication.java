package com.orderparser;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orderparse.util.ParsingUtil;

@SpringBootApplication(scanBasePackages ={"com.orderparser","com.orderparser.model","com.orderparser.service","com.orderparser.serviceimpl"})
public class OrderParserApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(OrderParserApplication.class, args);
		
		try {
			ParsingUtil.parseData(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
