package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by acedric on 05/04/2017.
 */
public class Reading_PropertiesFile {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        Properties prop = new Properties();
        FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\Employee.properties");
//        FileInputStream fs = new FileInputStream("C:\\Workspace\\execise\\src\\test\\java\\config\\Employee.properties");
        prop.load(fs);
        System.out.println(prop.getProperty("name"));

    }


}
