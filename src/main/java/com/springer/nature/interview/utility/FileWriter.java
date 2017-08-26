package com.springer.nature.interview.utility;

import java.io.File;
import java.io.IOException;

/**
 * Created by sayalik on 8/26/2017.
 */
public class FileWriter {

    public static void writeContentsToFile(String transformedContents, String outputFile) {
        java.io.FileWriter writer = null;
        try {
            writer = new java.io.FileWriter(outputFile);
            writer.write(transformedContents);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
