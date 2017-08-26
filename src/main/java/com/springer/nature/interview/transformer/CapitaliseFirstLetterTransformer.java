package com.springer.nature.interview.transformer;

import com.springer.nature.interview.reader.InputReader;
import com.springer.nature.interview.writer.OutputWriter;

/**
 * Created by sayalik on 8/26/2017.
 */
public class CapitaliseFirstLetterTransformer extends AbstractTransformer {

    public CapitaliseFirstLetterTransformer(InputReader reader, OutputWriter writer) {
        super(reader, writer);
    }

    public CapitaliseFirstLetterTransformer() {
        super();
    }

    public String transform(String contents) {
        String[] allLines = contents.split("\\n");
        String transformedContents = "";

        for (String line: allLines) {
            if(transformedContents != ""){
                transformedContents += "\\n";
            }
            String convertLine = convertLine(line);
            transformedContents += convertLine;
        }
        return transformedContents;
    }

    private String convertLine(String line) {
        String[] allWords = line.split("\\s");
        String newLine = "";
        for (String word : allWords) {
            word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            if (newLine != "") {
                newLine += " ";
            }
            newLine += word;
        }
        return newLine;
    }
}
