package generic;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class readFile {
	public static String url = "";
 
	public static String fileread(String key) throws IOException {
		Properties read = new Properties();
		FileReader fr = new FileReader("./src/test/resources/testData.properties");
		read.load(fr);
		url = read.getProperty(key);
		return url;

	}
	
	
	public static void main(String[] args) throws IOException {
		String u=fileread("Url");
		System.out.println(u);
	}
}
