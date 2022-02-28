package automationtesting;

import java.io.FileInputStream;
import java.util.Properties;

import net.bytebuddy.implementation.bind.annotation.Super;

public class ConfigFileReader {
	static String filePath;
	private static Properties configFile;

	public ConfigFileReader(String filePath) {
  
		try {
			
			FileInputStream input = new FileInputStream(filePath);
			configFile = new Properties();
			configFile.load(input);
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
 
	}

	public String getProperties(String keyname) {
		return configFile.getProperty(keyname);
		
	}
 
}
