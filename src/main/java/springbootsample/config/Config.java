package springbootsample.config;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springbootsample.feignclient.SomeDistinctServiceClient;
import springbootsample.messaging.PayrollSink;
import springbootsample.messaging.SalaryReceiptSource;

@Configuration
@EnableAsync
@EnableBinding({
        PayrollSink.class,
        SalaryReceiptSource.class
})

@Import({LockConfig.class})
@EnableFeignClients(
        clients = {SomeDistinctServiceClient.class})
@EnableRetry
@EnableJms
@EnableScheduling
public class Config {

}
