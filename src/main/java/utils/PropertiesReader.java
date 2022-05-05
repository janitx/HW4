package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    private static final String FILE = "src/main/resources/config.properties";
    private static Logger logger = LogManager.getLogger("PropertiesReader");

    Properties property = new Properties();

    public PropertiesReader() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(FILE);
            property.load(fis);
        } catch (IOException e) {
            logger.info("Properties file is not exit");
        }
    }

    public String getUrl() {
        return property.getProperty("URL");
    }

    public String getPathToFiltersFileXml() {
        return property.getProperty("FILE_FILTERS_PRODUCT_XML");
    }

}
