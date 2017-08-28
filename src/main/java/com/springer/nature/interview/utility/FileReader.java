package com.springer.nature.interview.utility;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by sayalik on 8/26/2017.
 */
public class FileReader {

    final static Logger logger = Logger.getLogger(FileReader.class);

    public static String readFileContents(String outputFileName) {
        String allText = "";
        File file = new File(outputFileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
            String line = "";

            while ((line = reader.readLine())!=null) {
                if (allText!="") {
                    allText += "\n";
                }
                allText += line;
            }
        } catch (FileNotFoundException e) {
            logger.error("Not able to find file: " + outputFileName , e);
        } catch (IOException e) {
            logger.error("Error Ocurred while reading the file: " + outputFileName , e);
        }
        return allText;
    }

}
