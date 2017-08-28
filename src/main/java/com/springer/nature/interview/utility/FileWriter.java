package com.springer.nature.interview.utility;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * Created by sayalik on 8/26/2017.
 */
public class FileWriter {

    final static Logger logger = Logger.getLogger(FileWriter.class);

    public static void writeContentsToFile(String transformedContents, String outputFile) {
        java.io.FileWriter writer = null;
        try {
            writer = new java.io.FileWriter(outputFile);
            writer.write(transformedContents);
        } catch (IOException e) {
            logger.error("Error occurred while writing contents to file:" + outputFile, e);
        }finally {
            if(writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                   logger.error("Error occurred while closing the resource", e);
                }
            }
        }
    }
}
