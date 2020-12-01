package com.jijo.bank.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import java.util.TimeZone;
@SpringBootApplication
@ComponentScan({
    "com.jijo.bank.restsupport",
    "com.jijo.bank.customer",
    "com.jijo.bank.onboarding"
})
@EnableEurekaClient
public class App {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(App.class, args);
    }
}
