package com.springer.nature.interview.writer;

import com.springer.nature.interview.utility.FileWriter;

/**
 * Created by siddharthk on 8/26/2017.
 */
public class FileOutputWriter implements OutputWriter {
    private String outputFileName;

    public FileOutputWriter(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void write(String contents) {
        FileWriter.writeContentsToFile(contents, outputFileName);
    }
}
