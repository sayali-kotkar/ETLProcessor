package com.springer.nature.interview.intergration;

import com.springer.nature.interview.reader.FileInputReader;
import com.springer.nature.interview.reader.InputReader;
import com.springer.nature.interview.transformer.CapitaliseFirstLetterTransformer;
import com.springer.nature.interview.transformer.Transformer;
import com.springer.nature.interview.writer.FileOutputWriter;
import com.springer.nature.interview.writer.OutputWriter;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.*;

import static com.springer.nature.interview.utilities.FileCreator.createFileWithContents;
import static com.springer.nature.interview.utility.FileReader.readFileContents;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by sayalik on 8/26/2017.
 */
public class CapitaliseFirstLetterTransformerTest {

    @Test
    public void transform() throws Exception {

        String inputFileName = "c:\\test\\sayali\\input1.txt";
        String outputFileName = "c:\\test\\sayali\\output1.txt";
        String inputContents = "I am a great coder who loves to solve real world problems";
        String outputContents = "I Am A Great Coder Who Loves To Solve Real World Problems";

        //GIVEN
        createFileWithContents(inputFileName, inputContents);
        InputReader reader = new FileInputReader(inputFileName);
        OutputWriter writer = new FileOutputWriter(outputFileName);
        Transformer transformer = new CapitaliseFirstLetterTransformer(reader, writer);

        //WHEN
        transformer.transform();

        //THEN
        checkOutPutFileIsCreated(outputFileName);
        checkContentsAreTransformed(outputFileName, outputContents);

    }

    @Test
    public void transformInput2() throws Exception {

        String inputFileName = "c:\\test\\sayali\\input2.txt";
        String outputFileName = "c:\\test\\sayali\\output2.txt";
        String inputContents = "Design patterns helps me to write good modular and extensible code";
        String outputContents = "Design Patterns Helps Me To Write Good Modular And Extensible Code";

        //GIVEN
        createFileWithContents(inputFileName, inputContents);
        InputReader reader = new FileInputReader(inputFileName);
        OutputWriter writer = new FileOutputWriter(outputFileName);
        Transformer transformer = new CapitaliseFirstLetterTransformer(reader, writer);

        //WHEN
        transformer.transform();

        //THEN
        checkOutPutFileIsCreated(outputFileName);
        checkContentsAreTransformed(outputFileName, outputContents);

    }

    private void checkContentsAreTransformed(String outputFileName, String outputContents) {
        String fileContents = readFileContents(outputFileName);
        assertThat(fileContents, equalTo(outputContents));
    }

    private void checkOutPutFileIsCreated(String outputFileName) {
        File file = new File(outputFileName);
        assertThat("The output file" + outputFileName + "is not created ",file.exists(), CoreMatchers.is(true));
    }
}
