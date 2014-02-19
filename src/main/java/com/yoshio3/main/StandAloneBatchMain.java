package com.yoshio3.main;

import java.util.Properties;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;

/**
 *
 * @author Yoshio Terada
 */
public class StandAloneBatchMain {

    public static void main(String... args) {
        JobOperator job = BatchRuntime.getJobOperator();
        long id = job.start("my-batch-job", new Properties());
    }
}
