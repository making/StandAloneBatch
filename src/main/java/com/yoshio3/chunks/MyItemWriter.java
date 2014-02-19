package com.yoshio3.chunks;

import javax.batch.api.chunk.ItemWriter;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Yoshio Terada
 */
public class MyItemWriter implements ItemWriter {

    @Inject
    JobContext jobCtx;

    String fileName;

    BufferedWriter bufWriter;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        fileName = jobCtx.getProperties()
                .getProperty("output_file");
        bufWriter = Files.newBufferedWriter(Paths.get(fileName), Charset.forName("UTF-8"));
    }

    @Override
    public void close() throws Exception {
        bufWriter.close();
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        for (Object obj : items) {
            String data = (String) obj;
            System.out.println("Writer writeItems : " + data);

            bufWriter.write(data);
            bufWriter.newLine();
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}