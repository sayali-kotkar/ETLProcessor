package com.springer.nature.interview.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sayalik on 8/26/2017.
 */
public class FileCreator {

    public static File createFileWithContents(String fileName, String contents) {
        File file = new File(fileName);
        boolean newFile = false;
        BufferedWriter writer = null;
        try {

            file.getParentFile().mkdirs();
            newFile = file.createNewFile();

            if(newFile){
                writer = new BufferedWriter(new FileWriter(file));
                writer.write(contents);
            }

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
        return file;
    }
}
