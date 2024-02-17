package generic;

import java.io.FileInputStream;
import java.util.Properties;

//Load the properties into the project
public class LoadProperties implements AutoConstants{
	public static String getPropertyValue(String key)
	{
		String path = PROPERTY_PATH;
		Properties prop = new Properties();
		try 
		{
			FileInputStream file = new FileInputStream(path);
			prop.load(file);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}


}
