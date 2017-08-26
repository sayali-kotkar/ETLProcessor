package com.springer.nature.interview.unit;

import com.springer.nature.interview.transformer.CapitaliseFirstLetterTransformer;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by sayalik on 8/25/2017.
 */
public class CapitaliseFirstLetterTransformerTest {

    CapitaliseFirstLetterTransformer transformer = new CapitaliseFirstLetterTransformer();

    @Test
    public void processWhenOneWordIsPresentInFile() throws FileNotFoundException {
        String capitalisedFileContents = transformer.transform("hello");
        assertThat(capitalisedFileContents, equalTo("Hello"));
    }

    @Test
    public void processWhenMultipleWordsArePresentInLine() throws FileNotFoundException {
        String capitalisedFileContents = transformer.transform("hello world");
        assertThat(capitalisedFileContents, equalTo("Hello World"));

    }

    /*@Test
    public void processWhenMultipleLinesArePresentInFile() throws FileNotFoundException {

        String capitalisedFileContents = transformer.transform("hello world\nhello");
        assertThat(capitalisedFileContents, CoreMatchers.equalTo("Hello World\nHello"));

    }
*/
    @Test
    public void processWhenSpecialCharactersExist() throws FileNotFoundException {

        String capitalisedFileContents = transformer.transform("hello world !");
        assertThat(capitalisedFileContents, equalTo("Hello World !"));
    }

    @Test
    public void processForSampleInput1InInterview() throws FileNotFoundException {

        String capitalisedFileContents = transformer.transform("I am a great coder who loves to solve real world " +
                "problems");
        assertThat(capitalisedFileContents, equalTo("I Am A Great Coder Who Loves To Solve Real World Problems"));

    }


}
