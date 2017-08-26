package com.springer.nature.interview.transformer;

import com.springer.nature.interview.reader.InputReader;
import com.springer.nature.interview.writer.OutputWriter;

/**
 * Created by sayalik on 8/26/2017.
 */
public abstract class AbstractTransformer implements Transformer {

    private final InputReader reader;
    private final OutputWriter writer;

    public AbstractTransformer(InputReader reader, OutputWriter writer) {

        this.reader = reader;
        this.writer = writer;
    }

    public AbstractTransformer() {

        reader = null;
        writer = null;
    }

    public void transform() {
       String contents =  reader.read();
       String modifiedContents = transform(contents);
       writer.write(modifiedContents);
    }


    public abstract String transform(String contents);
}
