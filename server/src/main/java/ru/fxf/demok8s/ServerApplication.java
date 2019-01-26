package ru.fxf.demok8s;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}

@RestController
@AllArgsConstructor
@Slf4j
class ServerController {

    @GetMapping("/hi")
    public String hi() {
        log.info("Simon says Hello");
        return "Hello";
    }

    @GetMapping("/greeting")
    public String greeting() {
        log.info("Simon says Morning");
        return "Morning";
    }
}