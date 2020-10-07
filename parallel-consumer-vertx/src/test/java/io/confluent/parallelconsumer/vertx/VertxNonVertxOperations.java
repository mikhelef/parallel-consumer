package io.confluent.parallelconsumer.vertx;

/*-
 * Copyright (C) 2020 Confluent, Inc.
 */

import io.confluent.parallelconsumer.ParallelEoSStreamProcessorImpl;
import io.confluent.parallelconsumer.ParallelConsumerOptions;
import io.confluent.parallelconsumer.ParallelEoSStreamProcessorImplTest;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.ext.web.client.WebClient;

/**
 * Ensure all plain operations still work with the extended vertx consumer
 */
public class VertxNonVertxOperations extends ParallelEoSStreamProcessorImplTest {

    @Override
    protected ParallelEoSStreamProcessorImpl initAsyncConsumer(ParallelConsumerOptions parallelConsumerOptions) {
        VertxOptions vertxOptions = new VertxOptions();
        Vertx vertx = Vertx.vertx(vertxOptions);
        parallelConsumer = new VertxParallelEoSStreamProcessor<>(consumerSpy, producerSpy, vertx, WebClient.create(vertx), parallelConsumerOptions);

        return parallelConsumer;
    }

}
