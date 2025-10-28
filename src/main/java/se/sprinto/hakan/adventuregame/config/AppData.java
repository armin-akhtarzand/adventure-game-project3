package se.sprinto.hakan.adventuregame.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppData {
    private final String author;
    private final String version;
    private static AppData instance;
    private Properties properties;
    String tempAuthor = "okänd";
    String tempVersion = "okänd";



    private AppData() {

        properties = new Properties();
        try {
            FileReader reader = new FileReader("AppData.properties");
            properties.load(reader);
            tempAuthor = properties.getProperty("author");
            tempVersion = properties.getProperty("version");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.author = tempAuthor;
        this.version = tempVersion;

        }
    public static AppData getInstance(){
        if(instance == null){
            instance = new AppData();
        }
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getAuthor() {
        return author;
    }

    public String getVersion() {
        return version;
    }
}
