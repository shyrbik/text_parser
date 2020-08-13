package by.epamtc.rumiantsau.textparser.dao.impl;

import java.util.*;
import java.io.*;

public class Configuration {
    public static final String regexSentence = "regexSentence";
    public static final String regexWord = "regexWord";
    public static final String regexParagraph = "regexParagraph";
    private static Configuration _instance = null;

    private Properties props = null;

    private Configuration() {
        File file = new File("properties/parserproperties.prop");
        String absolutePropertiesPath = file.getAbsolutePath();


        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream(
                    new File(absolutePropertiesPath));
            props.load(fis);
        }
        catch (Exception e) {
            // обработайте ошибку чтения конфигурации
        }
    }

    public synchronized static Configuration getInstance() {
        if (_instance == null)
            _instance = new Configuration();
        return _instance;
    }

    // получить значение свойства по имени
    public synchronized String getProperty(String key) {
        String value = null;
        if (props.containsKey(key))
            value = (String) props.get(key);
        else {
            // сообщите о том, что свойство не найдено
        }
        return value;
    }
}
