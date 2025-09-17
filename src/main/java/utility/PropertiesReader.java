package utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {
	Properties properties;
	
	public PropertiesReader() {
		try {
			properties = new Properties();
			FileInputStream fi = new FileInputStream("D:\\eclipse-workspace\\Selenium_Cucumber\\src\\main\\resources\\config.properties");
			properties.load(fi);
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public String getBrowserName() {
        return properties.getProperty("browser");
    }
	
	public String getUrl() {
        return properties.getProperty("url");
    }
	
	 public int getHardWait() {
	        return Integer.parseInt(properties.getProperty("hardwait"));
	    }
	 public int getImplicitWait() {
	        return Integer.parseInt(properties.getProperty("hardwait"));
	    }
	 public int getExplicitWait() {
	        return Integer.parseInt(properties.getProperty("hardwait"));
	    }
}
