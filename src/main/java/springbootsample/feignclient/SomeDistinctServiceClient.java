package springbootsample.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        url = "${account-service.uri}",
        name = "sample-application"
)
public interface SomeDistinctServiceClient {

    @GetMapping(value = "distinctservice/{param1}", produces = MediaType.APPLICATION_JSON_VALUE)
    Account getAccounts(@PathVariable("param1") String param1,
                        @RequestParam("param2") String param2);

}