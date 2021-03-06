package Assignment.FileHandling;
/*
 * this file reads the configuration file.
 * author @shreya.dwivedi
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {

	static Logger logger = LogManager.getLogger(EmployeeRecordMaintainance.class.getName());
	public static Properties property = new Properties();

	// the following function returns the properties instance which can be used
	// to access the configuration files
	public static void getFile()throws Exception {
		// try with resources to open and access the configuration file
		try (FileInputStream propertyfile = new FileInputStream("./resources/config.properties")) {
			property.load(propertyfile);
		}
		// logs the error and exists the system in case of empty config file
		catch (Exception e) {
			throw new Exception("Issue with config.property file, default paths of the file are assigned.");
			
		}
	}
	public static String getResources(String key) {
		return property.getProperty(key);
	}

}
