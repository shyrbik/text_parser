package by.epamtc.rumiantsau.textparser.dao.impl;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReader {
    private static final Logger log = LoggerFactory.getLogger(FileReader.class);



   // public static String filePath = "F:\\javaprojects\\resourses\\textforparsing.txt";
    public String readText(){

        //формируем относительный путь к текстовому файлу
        File file = new File("resourses/textforparsing.txt");
        String absolutePath = file.getAbsolutePath();
        String line;
        StringBuffer text = new StringBuffer();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(absolutePath), StandardCharsets.UTF_8))){
            while ((line = reader.readLine()) != null) {
                text.append(line);
                text.append("\n");
            }
        }
        catch (IOException e) {
            log.error("Problem with FilePass. Check for file existence!", e);
            }
        return text.toString();
    }
}
