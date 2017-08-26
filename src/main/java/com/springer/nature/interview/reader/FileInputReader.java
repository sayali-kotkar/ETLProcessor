package com.springer.nature.interview.reader;


import static com.springer.nature.interview.utility.FileReader.*;

/**
 * Created by sayalik on 8/26/2017.
 */
public class FileInputReader implements InputReader {
    private String fileName;

    public FileInputReader(String fileName) {

        this.fileName = fileName;
    }

    public String read() {
        return readFileContents(fileName);
    }
}
