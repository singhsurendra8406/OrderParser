package com.orderparser.service;

import java.io.File;
import java.util.List;

import com.orderparser.model.OutputData;

public interface OrderParser {
	
	public List<OutputData> parser(String inputFileName);

}
