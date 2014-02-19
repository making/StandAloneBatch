package com.yoshio3.chunks;

import javax.batch.api.chunk.ItemProcessor;

/**
 *
 * @author Yoshio Terada
 */
public class MyItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        String line = (String)item ;
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("Processor processItem : ");
        sBuilder.append(line);
        String returnValue = sBuilder.toString();
        System.out.println(returnValue);
        return returnValue;
    }
}