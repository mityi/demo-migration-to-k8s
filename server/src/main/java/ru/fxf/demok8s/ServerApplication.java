package ru.fxf.demok8s;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}

@RestController
@AllArgsConstructor
@Slf4j
class ServerController {

    private final MyReloadableProperty reloadableProperty;

    @GetMapping("/hi")
    public String hi() {
        log.info("Simon says {}", reloadableProperty.getProperty());
        return reloadableProperty.getProperty();
    }

    @GetMapping("/greeting")
    public String greeting() {
        log.info("Simon says Morning");
        return "Morning";
    }
}

@Configuration
@ConfigurationProperties(prefix = "reloadable")
@Data
class MyReloadableProperty {
    private String property;
}
