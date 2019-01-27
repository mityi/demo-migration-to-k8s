package ru.fxf.demok8s;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(clients = {GreetingClient.class})
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

}

@Slf4j
@RestController
@RequiredArgsConstructor
class ClientController {

    //    private final KubernetesClient kubernetesClient;
    private final GreetingClient client;
    private final DiscoveryClient discoveryClient;
    @Value("${services.greeting-server}")
    private String servicesId;

    @GetMapping("/hi")
    public String hi() {
        discoveryClient.getInstances(servicesId)
                .forEach(instance ->
                        log.info("host:port -> {}:{}",
                                instance.getHost(), instance.getPort()));
        return client.hi();
    }
}

@FeignClient(name = "${services.greeting-server}")
interface GreetingClient {
    @GetMapping("/hi")
    String hi();

}