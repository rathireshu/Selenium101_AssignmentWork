package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private ConfigReader() {
		// singleton by making constructor private so that no one from outside this
		// class creates extra objects.
	}

	private static Properties pro = null;

	private static void initialize() {
		try {
			pro = new Properties();
			FileReader file = new FileReader("src/test/java/Config/config.properties");
			pro.load(file);
		} catch (IOException e) {
		}
	}

	public static Properties getPropertyObject() {
		if (pro == null) {
			initialize();
		}
		return pro;
	}
}
