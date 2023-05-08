package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public Properties init_Prop() {
        prop = new Properties();

        /**
         * This method is used to load the properties from config.properties file
         * @return it returns Properties prop object
         */
        try{
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(fileInputStream);
        }catch(IOException e){
            e.printStackTrace();
        }

        return prop;
    }

}
