package com.constant;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ConstantInfo {
	public static String VERSION_VALUE = "0.0.1";
	
	public static void updateVersion(String versionValue) {
		VERSION_VALUE = versionValue;
	}
	
	public static String SUBSCRIBE_PATH = "/smartpe/configCenter/fridge";
	
	public static String PATH_READ_TOKEN = "OC4cQZif";
	
	public static String PATH_WRITE_TOKEN = "vODOUBSV";
	
	public final static Map<String, String> VALUE_MAP = new HashMap<>();
	
	static {
		VALUE_MAP.put("1", "1");
	}
	
	public static void main(String[] args) {
		Double d1 = 35.8;
		Double d2 = 27.9;
		 BigDecimal b1 = new BigDecimal(Double.toString(d1));
	     BigDecimal b2 = new BigDecimal(Double.toString(d2));
	     
	     Double d3 = b1.subtract(b2).doubleValue();
		System.out.println(d1 -d2);
		
		System.out.println(d3);
	}
}
