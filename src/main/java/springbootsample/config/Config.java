package springbootsample.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import springbootsample.messaging.PayrollSink;
import springbootsample.messaging.SalaryReceiptSource;

@Configuration
@EnableBinding({
        PayrollSink.class,
        SalaryReceiptSource.class
})
public class Config {

}
