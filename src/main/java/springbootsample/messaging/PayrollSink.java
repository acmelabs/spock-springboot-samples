package springbootsample.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PayrollSink {

    String INPUT = "PayrollSink";

    @Input(PayrollSink.INPUT)
    SubscribableChannel input();
}
