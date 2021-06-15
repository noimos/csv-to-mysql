package org.noimos.csv2mysql.ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;

/**
 *
 * @author Mahen Samaranayake
 */
public class PropertiesRW {

    Properties properties;
    String fileName = "connection.props";

    public PropertiesRW() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(new File(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public void storeProperties(Properties properties) {
        try {
            properties.store(new FileWriter(new File(fileName)), "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
