package org.example.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static String getProperty(String key) throws FileNotFoundException {



        try{
            prop = new Properties();
            //File Input Stream

            FileInputStream file = new FileInputStream("src/test/resources/config.properties");

            prop.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }


}
