package home.lab.metrics.metricsdemo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeService {

    private final MeterRegistry meterRegistry;
    private Counter counter;

    void initCounter() {
        counter = Counter.builder("some.property")
                .tag("tag", "whatever")
                .description("Iam testing this")
                .register(meterRegistry);
    }

    void startIncrementing() {
        counter.increment(1.0);
    }

}
