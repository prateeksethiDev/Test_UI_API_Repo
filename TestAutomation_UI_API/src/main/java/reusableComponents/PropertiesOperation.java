package reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesOperation {
	
	static Properties prop = new Properties();
	
	public static String getPropertyValueByKey(String key) throws Exception {
		String propFilePath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		String value =prop.getProperty(key);	
		
		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value does not exists for key: "+key+" in properties file");
		}
		
		return value;
	}

}
