package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    private static String propertyFile = "/application.properties";

    //override default property file
    public static void usePropertyFile(String propertyFile){
        propertyFile = propertyFile;
    }

    public static String loadProperty(String name){
        String propertyValue = "";
        Properties prop = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream(propertyFile);
            // load a properties file
            prop.load(input);
            // get the property value
            propertyValue =  prop.getProperty(name);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propertyValue;
    }

    //override default property file and get property
    public static String loadProperty(String name, String propertyFile){
        propertyFile = propertyFile;
        return  loadProperty(name);
    }
}
