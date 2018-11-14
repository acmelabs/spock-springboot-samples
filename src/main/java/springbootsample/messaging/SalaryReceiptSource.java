package springbootsample.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface SalaryReceiptSource {
    String OUTPUT = "SalaryReceiptSource";

    @Output(SalaryReceiptSource.OUTPUT)
    SubscribableChannel output();
}



