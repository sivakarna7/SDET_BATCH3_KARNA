package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import modules.TestData;


public class PropertiesUtil {

	public Properties getProperties(String filePath) throws IOException {
		TestData.p = new Properties();
		TestData.input = new FileInputStream(filePath);
		TestData.p.load(TestData.input);
		return TestData.p;
	}
}
