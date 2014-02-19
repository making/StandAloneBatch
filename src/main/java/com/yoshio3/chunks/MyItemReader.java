package com.yoshio3.chunks;

import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyItemReader implements ItemReader {

    @Inject
    JobContext jobCtx;

    BufferedReader bufReader;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        String fileName = jobCtx.getProperties()
                .getProperty("input_file");
        bufReader = Files.newBufferedReader(Paths.get(fileName), Charset.forName("UTF-8"));
    }

    @Override
    public void close() throws Exception {
        bufReader.close();
    }

    @Override
    public Object readItem() throws Exception {
        String data = bufReader.readLine();
        System.out.println("Reader readItem : " + data);
        return data;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}