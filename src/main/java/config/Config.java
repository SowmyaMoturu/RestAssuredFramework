package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Config {

    private static Properties properties;

    public Config() {
        Properties p = new Properties();
       String filePath =System.getProperty("user.dir") + "\\src\\main\\resources\\GlobalConfig.properties";
        try {
            p.load(new FileInputStream(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties = p;
    }
    public static String readProperty(String key) throws IOException{
        Config config = new Config();
        return properties.getProperty(key);
    }

    public static void populateSettings() throws IOException {
        Config config = new Config();
        Settings.App_URL = properties.getProperty("appURl");
        Settings.UserName = properties.getProperty("userName");
        Settings.Password = properties.getProperty("password");
        Settings.HostName = properties.getProperty("hostName");
        Settings.Sid = properties.getProperty("sid");
        Settings.DbUserName = properties.getProperty("dbUserName");
        Settings.DbPassword = properties.getProperty("dbPassword");
        Settings.TestDataFolder = properties.getProperty("testDataFolder");
        Settings.BrowserType = properties.getProperty("browserType");
        Settings.ScreenShotsFolderPath = properties.getProperty("ScreenShotsFolderPath");
        Settings.base_uri = properties.getProperty("baseURI");
        Settings.base_path = properties.getProperty("basePath");
         Settings.authHeader = properties.getProperty("authHeader");
        Settings.authKey = properties.getProperty("authKey");

    }
    }






