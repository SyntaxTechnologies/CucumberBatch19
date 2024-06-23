package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String read(String key,String path)  {
        Properties properties=new Properties();
        try(FileInputStream fis=new FileInputStream(path)){
            properties.load(fis);
        }catch (IOException fe){
            fe.printStackTrace();
        }

        return properties.getProperty(key);
    }

    public static String read(String key)  {

        return  read(key,Constants.CONFIG_FILE_PATH);

    }
}
