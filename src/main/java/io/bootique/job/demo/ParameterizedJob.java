package io.bootique.job.demo;

import io.bootique.job.BaseJob;
import io.bootique.job.JobMetadata;
import io.bootique.job.runnable.JobResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ParameterizedJob extends BaseJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterizedJob.class);

    private static final String DATE_PARAM = "d";
    private static final String LONG_PARAM = "l";

    public ParameterizedJob() {
        // pass a metadata object to the super constructor that defines supported parameter names and types
        super(JobMetadata.builder(ParameterizedJob.class)
                .dateParam(DATE_PARAM)
                .longParam(LONG_PARAM)
                .build());
    }

    @Override
    public JobResult run(Map<String, Object> params) {

        LOGGER.info("Job runs with parameters: (d: {}), (l: {})"
                , params.get(DATE_PARAM)
                , params.get(LONG_PARAM));

        return JobResult.success(getMetadata());
    }
}
