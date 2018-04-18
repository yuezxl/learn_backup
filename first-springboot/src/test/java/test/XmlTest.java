package test;

import java.io.File;
import java.io.FileInputStream;

public class XmlTest {
	public static void main(String[] args) {
		File file = new File("resources/xml/test.xml");
		
		try{
			FileInputStream xmlFile = new FileInputStream("resources/xml/test.xml");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
