package br.com.producers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class producersApplication {

    public static void main(String[] args) {
        SpringApplication.run(producersApplication.class, args);
    }
}
