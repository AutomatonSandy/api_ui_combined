
package config;

import java.util.ResourceBundle;

public class ConfigReader {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");

	public static String get(String key) {
		System.out.println("-------------------------"+rb.getString(key));
		return rb.getString(key);
	}
}
