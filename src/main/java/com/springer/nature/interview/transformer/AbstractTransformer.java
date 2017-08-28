package com.springer.nature.interview.transformer;

import com.springer.nature.interview.reader.InputReader;
import com.springer.nature.interview.utility.FileReader;
import com.springer.nature.interview.writer.OutputWriter;
import org.apache.log4j.Logger;

/**
 * Created by sayalik on 8/26/2017.
 */
public abstract class AbstractTransformer implements Transformer {

    final static Logger logger = Logger.getLogger(AbstractTransformer.class);

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

       logger.info("Transformer called..");

       String contents =  reader.read();
       String modifiedContents = transform(contents);
       writer.write(modifiedContents);

       logger.info("Transformation completed successfully..");
    }


    public abstract String transform(String contents);
}
